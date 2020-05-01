package com.github.timeline.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ExceptionController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        int code = (int) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("org.springframework.web.servlet.DispatcherServlet.EXCEPTION");
        model.addAttribute("code", code);
        model.addAttribute("message", exception.getMessage());
        return "timeline_error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
