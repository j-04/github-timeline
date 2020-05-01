package com.github.timeline.service;

import com.github.timeline.exception.ObjectNotFoundException;
import org.springframework.ui.Model;

public interface TimeLineService {
    void user(String login, Model model) throws ObjectNotFoundException;
    void repositories(String login, Model model) throws ObjectNotFoundException;
    void commits(String login, String repoName, Model model) throws ObjectNotFoundException;
}
