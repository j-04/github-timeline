package com.github.timeline.service;

import com.github.timeline.entity.Commit;
import com.github.timeline.entity.Repository;
import com.github.timeline.entity.User;
import com.github.timeline.exception.ObjectNotFoundException;
import com.github.timeline.httpclient.GitHubHttpClient;
import com.github.timeline.util.SorterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GitHubHttpClientServiceImplement implements GitHubHttpClientService {
    private final GitHubHttpClient client;
    private final SorterService sorterService;
    private final String topSecret = "*TOP SECRET*";

    @Autowired
    public GitHubHttpClientServiceImplement(@Qualifier("gitHubHttpClient") GitHubHttpClient client,
                                            @Qualifier("sorterService") SorterService sorterService) {
        this.client = client;
        this.sorterService = sorterService;
    }

    @Override
    public User getUser(String login) throws ObjectNotFoundException {
        var user = client.getUser(login);
        if (user == null)
            throw new ObjectNotFoundException("User with login " + login + " not found");
        if (user.getName() == null)
            user.setName(topSecret);
        if (user.getBio() == null)
            user.setBio(topSecret);
        if (user.getCompany() == null)
            user.setCompany(topSecret);
        if (user.getEmail() == null)
            user.setEmail(topSecret);
        user.setCreatedAt(getHandledDate(user.getCreatedAt()));
        return user;
    }

    @Override
    public List<Repository> getRepositories(String login) throws ObjectNotFoundException {
        var repos = client.getUserRepositories(login);
        if (repos == null)
            throw new ObjectNotFoundException("Repositories of user with login " + login + " not found");
        repos = repos.stream()
                .filter(r -> r.getIsFork().equals("false"))
                .collect(Collectors.toList());

        for (Repository repo: repos) {
            repo.setCreatedAt(getHandledDate(repo.getCreatedAt()));
            repo.setUpdatedAt(getHandledDate(repo.getUpdatedAt()));
        }
        repos = sorterService.sortRepos(repos);
        repos.stream()
                .filter(r -> r.getDescription() == null)
                .forEach(r -> r.setDescription(topSecret));
        return repos;
    }

    @Override
    public List<Commit> getCommits(String login, String repoName) throws ObjectNotFoundException {
        var commits = client.getRepoCommits(login, repoName);
        if (commits == null)
            throw new ObjectNotFoundException("Repository commits with name " + repoName + " of user with login" + login + " not found");
        for (Commit commit: commits) {
            Commit.Committer committer = commit.getCommitProperty().getCommitter();
            Commit.CommitProperty commitProperty = commit.getCommitProperty();
            committer.setDate(getHandledDate(committer.getDate()));
            commitProperty.setMessage(commitProperty.getMessage().split("\n")[0]);
        }
        return commits;
    }

    private String getHandledDate(String date) {
        return date.replaceAll("T.*Z", "");
    }
}
