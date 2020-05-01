package com.github.timeline.httpclient;

import com.github.timeline.entity.Commit;
import com.github.timeline.entity.Repository;
import com.github.timeline.entity.User;

import java.util.List;

public interface GitHubHttpClient {
    User getUser(String login);
    List<Repository> getUserRepositories(String login);
    List<Commit> getRepoCommits(String login, String repoName);
}
