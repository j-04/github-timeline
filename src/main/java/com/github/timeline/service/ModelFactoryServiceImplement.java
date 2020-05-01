package com.github.timeline.service;

import com.github.timeline.entity.Commit;
import com.github.timeline.entity.Repository;
import com.github.timeline.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ModelFactoryServiceImplement implements ModelFactoryService {
    @Override
    public void buildUserModel(User user, Model model) {
        model.addAttribute("user", user);
    }

    @Override
    public void buildRepositoriesModel(List<Repository> repositories, String login, Model model) {
        model.addAttribute("repos", repositories);
        model.addAttribute("rsize", repositories.size());
        model.addAttribute("login", login);
    }

    @Override
    public void buildCommitsModel(List<Commit> commits, String login, Model model) {
        model.addAttribute("commits", commits);
        model.addAttribute("login", login);
    }
}
