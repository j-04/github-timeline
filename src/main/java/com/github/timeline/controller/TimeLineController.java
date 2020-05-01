package com.github.timeline.controller;

import com.github.timeline.exception.ObjectNotFoundException;
import com.github.timeline.service.TimeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TimeLineController {
    private TimeLineService timeLineService;

    @Autowired
    public void setModelFactoryService(TimeLineService timeLineService) {
        this.timeLineService = timeLineService;
    }

    @GetMapping(path = {"/", ""})
    public String index() {
        System.out.println(Thread.currentThread());
        return "index";
    }

    @GetMapping("/user")
    public String user(@RequestParam("login") String login, Model model) throws ObjectNotFoundException {
        timeLineService.user(login, model);
        return "user";
    }

    @GetMapping("/user/{login}/repos")
    public String repositories(@PathVariable String login,
            Model model) throws ObjectNotFoundException {
        timeLineService.repositories(login, model);
        return "repos";
    }

    @GetMapping("/user/{login}/repo/{repoName}/commits")
    public String commits(@PathVariable String login,
                          @PathVariable String repoName,
                          Model model) throws ObjectNotFoundException {
        timeLineService.commits(login, repoName, model);
        return "commits";
    }

}
