package com.java.study.group.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Todo {

    @GetMapping("/")
    public String todo (){
        return "todo";
    }
}
