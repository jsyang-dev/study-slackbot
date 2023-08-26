package me.study.slackbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class StudySlackbotApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudySlackbotApplication.class, args);
    }

}
