package com.java.study.group.todolist.controller;

import com.java.study.group.todolist.dto.Task;
import com.java.study.group.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Todo {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/todo")
    public String todo (Model model) {
        List <Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "todo";
    }
}
