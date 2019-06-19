package com.waa.dragons.mediationattendance.controller.admin;

import com.waa.dragons.mediationattendance.domain.Attendance;
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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
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

    @Qualifier("attendanceJob")
    private Job importAttendanceJob;

    @Qualifier("attendanceJobSpecial")
    private Job importSpecialAttendanceJob;


    @Autowired
    public FileUploadController(AttendanceService attendanceService, JobLauncher jobLauncher,Job importAttendanceJob,Job importSpecialAttendanceJob) {
        this.attendanceService = attendanceService;
        this.jobLauncher = jobLauncher;
        this.importAttendanceJob = importAttendanceJob;
        this.importSpecialAttendanceJob = importSpecialAttendanceJob;
    }



    @PostMapping("/admin/uploadData")
    public String processFileUpload(@RequestParam("file") MultipartFile multipartFile) throws IOException {


        String path = new ClassPathResource("tmp/").getURL().getPath();
        File fileToImport = new File(path +multipartFile.getOriginalFilename());
        OutputStream outputStream = new FileOutputStream(fileToImport);
        IOUtils.copy(multipartFile.getInputStream(), outputStream);
        outputStream.flush();
        outputStream.close();


        new Thread(()->{
            try {
                jobLauncher.run(importAttendanceJob, new JobParametersBuilder()
                        .addString("fileName", multipartFile.getOriginalFilename())
                        .toJobParameters()).getEndTime();
            } catch (JobExecutionAlreadyRunningException ex){}
            catch (JobRestartException ex){}
            catch (JobInstanceAlreadyCompleteException ex){}
            catch (JobParametersInvalidException ex){}
        }).run();



        return "dataForm";
    }

    @GetMapping("/uploadData")
    public String getUploadForm(){
        return "dataForm";
    }

}
