package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication

@Getter
@AllArgsConstructor
public class Task {
    private Long id;
    private String title;
    private String content;
}
