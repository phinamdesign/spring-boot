package com.codegym.student.config;

import com.codegym.student.service.StudentService;
import com.codegym.student.service.impl.StudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
     @Bean
    public StudentService studentService(){
         return new StudentServiceImpl();
     }
}
