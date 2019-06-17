package com.waa.dragons.mediationattendance.controller.admin;

import com.waa.dragons.mediationattendance.service.AttendanceService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class FileUploadController {

    private JobLauncher jobLauncher;

    private AttendanceService attendanceService;

    private Job importUserJob;


    @Autowired
    public FileUploadController(AttendanceService attendanceService, JobLauncher jobLauncher,Job job) {
        this.attendanceService = attendanceService;
        this.jobLauncher = jobLauncher;
        this.importUserJob = job;
    }



    @PostMapping("/admin/uploadData")
    public String processFileUpload(@RequestParam("file") MultipartFile multipartFile) throws IOException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {


        String path = new ClassPathResource("tmp/").getURL().getPath();
        File fileToImport = new File(path +multipartFile.getOriginalFilename());
        OutputStream outputStream = new FileOutputStream(fileToImport);
        IOUtils.copy(multipartFile.getInputStream(), outputStream);
        outputStream.flush();
        outputStream.close();


        JobExecution jobExecution = jobLauncher.run(importUserJob, new JobParametersBuilder()
                .addString("fullPathFileName", fileToImport.getAbsolutePath())
                .toJobParameters());




        return "dataForm";
    }

    @GetMapping("/uploadData")
    public String getUploadForm(){
        return "dataForm";
    }

}
