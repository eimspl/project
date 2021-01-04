package com.crud.tasks.domain;


import lombok.Getter;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@Getter
@AllArgsConstructor
public class TaskDto {
    private Long id;
    private String title;
    private String content;
}
