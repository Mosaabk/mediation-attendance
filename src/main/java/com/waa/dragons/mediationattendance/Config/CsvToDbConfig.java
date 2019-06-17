package com.waa.dragons.mediationattendance.Config;

import com.waa.dragons.mediationattendance.domain.Attendance;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

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

    private static final String OVERRIDDEN_BY_EXPRESSION = null;




    @Bean
    public Job attendanceJob(JobBuilderFactory jobBuilders, StepBuilderFactory stepBuilders){
        return jobBuilders.get("attendanceReadJob").start(attendanceReadStep()).build();
    }

    @Bean
    public Step attendanceReadStep(){
        return stepBuilderFactory.get("attendanceReadStep")
                .<Attendance, Attendance>chunk(100)
                .reader(reader(OVERRIDDEN_BY_EXPRESSION))
                .processor(processor())
                .writer(writer()).build();
    }

    @Bean
    @Scope(value = "step", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public FlatFileItemReader<Attendance> reader(@Value("#{jobParameters[fullPathFileName]}")
                                                             String pathToFile){

        System.out.println(pathToFile);
        return new FlatFileItemReaderBuilder<Attendance>()
                .name("attendanceReader")
                .resource(new ClassPathResource("tmp/medAttend.csv"))
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
