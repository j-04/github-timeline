package com.github.timeline.service;

import com.github.timeline.entity.Commit;
import com.github.timeline.entity.Repository;
import com.github.timeline.entity.User;
import com.github.timeline.exception.ObjectNotFoundException;

import java.util.List;

public interface GitHubHttpClientService {
    User getUser(String login) throws ObjectNotFoundException;
    List<Repository> getRepositories(String login) throws ObjectNotFoundException;
    List<Commit> getCommits(String login, String repoName) throws ObjectNotFoundException;
}
