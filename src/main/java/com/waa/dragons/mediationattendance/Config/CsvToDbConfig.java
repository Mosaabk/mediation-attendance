package com.waa.dragons.mediationattendance.Config;

import com.waa.dragons.mediationattendance.domain.Attendance;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.access.SecurityMetadataSource;

import javax.sql.DataSource;

@EnableBatchProcessing
@Configuration
public class CsvToDbConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    @Bean
    public Job attendanceJob(JobBuilderFactory jobBuilders, StepBuilderFactory stepBuilders){
        return jobBuilders.get("attendanceReadJob").start(attendanceReadStep()).build();
    }

    @Bean
    public Step attendanceReadStep(){
        return stepBuilderFactory.get("attendanceReadStep")
                .<Attendance, Attendance>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer()).build();
    }

    @Bean
    public FlatFileItemReader<Attendance> reader(){

        return new FlatFileItemReaderBuilder<Attendance>()
                .name("attendanceReader")
                .resource(new ClassPathResource("medAttend.csv"))
                .delimited().names(new String[] {"barCode", "date", "location","type"})
                .targetType(Attendance.class).build();

    }


    @Bean
    public ItemProcessor<Attendance, Attendance> processor() {
        return new DBLogProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Attendance> writer(){
        return new JdbcBatchItemWriterBuilder<Attendance>()
                .dataSource(dataSource)
                .sql("INSERT INTO ATTENDANCE (BAR_CODE, DATE, LOCATION, TYPE) VALUES (:barCode, :date, :location, :type)")
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Attendance>())
                .build();
    }

    @Bean
    public LineMapper<Attendance> lineMapper() {
        DefaultLineMapper<Attendance> lineMapper = new DefaultLineMapper<Attendance>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("barCode", "date", "location", "type");
        lineTokenizer.setIncludedFields(0,1,2,3,4);
        BeanWrapperFieldSetMapper<Attendance> fieldSetMapper = new BeanWrapperFieldSetMapper<Attendance>();
        fieldSetMapper.setTargetType(Attendance.class);
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }


}
