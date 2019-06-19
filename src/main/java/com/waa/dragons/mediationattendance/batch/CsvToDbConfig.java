package com.waa.dragons.mediationattendance.batch;

import com.waa.dragons.mediationattendance.Config.DBLogProcessor;

import com.waa.dragons.mediationattendance.domain.Attendance;
import org.apache.catalina.Server;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
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
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableBatchProcessing
public class CsvToDbConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ItemReader<DefaultAttendance> itemReader;

    @Autowired
    private ItemReader<SpecialAttendance> itemReaderSpecial;

    @Autowired
    private ItemProcessor<DefaultAttendance, Attendance> defaultItemProcessor;

    @Autowired
    private ItemProcessor<SpecialAttendance, Attendance> specialItemProcessor;

    @Autowired
    private ItemWriter<Attendance> itemWriter;

    @Primary
    @Bean("attendanceJob")
    public Job attendanceJob(JobBuilderFactory jobBuilders, StepBuilderFactory stepBuilders){
        return jobBuilders.get("attendanceReadJob").start(attendanceReadStep()).build();
    }

    @Bean("attendanceJobSpecial")
    public Job attendanceJobSpecial(JobBuilderFactory jobBuilders, StepBuilderFactory stepBuilders){
        return jobBuilders.get("attendanceJobSpecial").start(attendanceReadStepSpecial()).build();
    }

    @Bean
    public Step attendanceReadStep(){
        return stepBuilderFactory.get("attendanceReadStep")
                .<DefaultAttendance, Attendance>chunk(1000)
                .reader(itemReader)
                .processor(defaultItemProcessor)
                .writer(itemWriter)
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public Step attendanceReadStepSpecial(){
        return stepBuilderFactory.get("attendanceReadStepSpecial")
                .<SpecialAttendance,Attendance>chunk(10)
                .reader(itemReaderSpecial)
                .processor(specialItemProcessor)
                .writer(itemWriter)
                .build();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
        taskExecutor.setConcurrencyLimit(4);
        return taskExecutor;
    }
    @Bean
    @Scope(value = "step", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public FlatFileItemReader<DefaultAttendance> reader(@Value("#{jobParameters[fileName]}")
                                                             String fileName){

        return new FlatFileItemReaderBuilder<DefaultAttendance>()
                .name("attendanceReader")
                .resource(new ClassPathResource("tmp/medAttend.csv"))
                .delimited().names(new String[] {"barCode", "date","type", "location"})
                .targetType(DefaultAttendance.class).build();

    }


    @Bean
    @Scope(value = "step", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public FlatFileItemReader<SpecialAttendance> readerSpecial(@Value("#{jobParameters[fileName]}")
                                                                String fileName){

        return new FlatFileItemReaderBuilder<SpecialAttendance>()
                .name("attendanceReaderSpecial")
                .resource(new ClassPathResource("tmp/specialAttend.csv"))
                .delimited().names(new String[] {"date", "studentId","stuName"})
                .targetType(SpecialAttendance.class).build();

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
