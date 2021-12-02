package com.java.study.group.todolist.controller;

import com.java.study.group.todolist.dto.Task;
import com.java.study.group.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class Todo {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public String todo (Model model) {
        List <Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "todo";
    }

    @PostMapping
    public ModelAndView addTask (Task task) {
        ModelAndView modelAndView = new ModelAndView("todo");
        taskRepository.save(task);

        List <Task> tasks = taskRepository.findAll();
        modelAndView.addObject("tasks",tasks);

        return modelAndView;
    }
}
