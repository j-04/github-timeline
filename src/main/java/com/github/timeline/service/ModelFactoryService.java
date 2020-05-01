package com.github.timeline.service;

import com.github.timeline.entity.Repository;
import com.github.timeline.entity.User;
import com.github.timeline.entity.Commit;
import org.springframework.ui.Model;

import java.util.List;

public interface ModelFactoryService {
    void buildUserModel(User user, Model model);
    void buildRepositoriesModel(List<Repository> repositories, String login, Model model);
    void buildCommitsModel(List<Commit> commits, String login, Model model);
}
