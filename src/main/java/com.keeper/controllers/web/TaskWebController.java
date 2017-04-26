package com.keeper.controllers.web;

/*
 * Created by @GoodforGod on 25.04.2017.
 */

import com.keeper.model.dao.User;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.model.dto.TaskDTO;
import com.keeper.service.impl.TaskService;
import com.keeper.service.impl.UserService;
import com.keeper.util.Translator;
import com.keeper.util.resolve.TemplateResolver;
import com.keeper.util.resolve.WebResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * Default Comment
 */
@Controller
public class TaskWebController {

    private final TaskService taskService;
    private final UserService userService;

    @Autowired
    public TaskWebController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @RequestMapping(value = WebResolver.TASK, method = RequestMethod.GET)
    public ModelAndView taskGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.TASK);

        return modelAndView;
    }

    @RequestMapping(value = WebResolver.TASK_CREATE, method = RequestMethod.GET)
    public ModelAndView taskCreateForm(@RequestParam(value = "id", required = false) Long id, Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.TASK_FORM);

        TaskDTO taskDTO = (id == null) ? new TaskDTO() : Translator.convertToDTO(taskService.get(id).get());

        modelAndView.addObject("task", taskDTO);

        return modelAndView;
    }

    @RequestMapping(value = WebResolver.TASK_CREATE, method = RequestMethod.POST)
    public ModelAndView taskUpdateOrCreate(@Valid TaskDTO task, Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.TASK);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByEmail(auth.getName()).get();
        task.setCreateDate(LocalDateTime.now());
        task.setLastModifyDate(LocalDateTime.now());
        task.setTopicStarterId(user.getId());
        task.setOriginGeoPoint(new GeoPointDTO(0L,
                                        "150.4214",
                                        "24.12412",
                                        4));

        taskService.add(Translator.convertToDAO(task));

        modelAndView.addObject("user", user);
        modelAndView.addObject("task", task);

        return modelAndView;
    }
}