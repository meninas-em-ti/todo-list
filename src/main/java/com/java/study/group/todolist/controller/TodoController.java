package com.java.study.group.todolist.controller;

import com.java.study.group.todolist.entity.Task;
import com.java.study.group.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public ModelAndView listTasks() {
        List <Task> tasks = taskRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("todo");
        modelAndView.addObject("tasks", tasks);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addTask(Task task) {
        taskRepository.save(task);
        return listTasks();
    }

}
