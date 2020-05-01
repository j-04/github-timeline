package com.github.timeline.service;

import com.github.timeline.exception.ObjectNotFoundException;
import com.github.timeline.util.SorterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class TimeLineServiceImplement implements TimeLineService {
    private GitHubHttpClientService client;
    private ModelFactoryService modelFactory;

    @Autowired
    public TimeLineServiceImplement(@Qualifier("gitHubHttpClientService") GitHubHttpClientService client,
                                    @Qualifier("modelFactoryService") ModelFactoryService modelFactory) {
        this.client = client;
        this.modelFactory = modelFactory;
    }

    @Override
    public void user(String login, Model model) throws ObjectNotFoundException {
        var user = client.getUser(login);
        modelFactory.buildUserModel(user, model);
    }

    @Override
    public void repositories(String login, Model model) throws ObjectNotFoundException {
        var repositories = client.getRepositories(login);
        modelFactory.buildRepositoriesModel(repositories, login, model);
    }

    @Override
    public void commits(String login, String repoName, Model model) throws ObjectNotFoundException {
        var commits = client.getCommits(login, repoName);
        modelFactory.buildCommitsModel(commits, login, model);
    }
}
