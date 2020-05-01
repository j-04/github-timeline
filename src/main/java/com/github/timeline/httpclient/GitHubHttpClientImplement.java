package com.github.timeline.httpclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.timeline.entity.Commit;
import com.github.timeline.entity.Repository;
import com.github.timeline.entity.User;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
public class GitHubHttpClientImplement implements GitHubHttpClient {
    private static Logger logger = LoggerFactory.getLogger(GitHubHttpClientImplement.class);

    private OkHttpClient client;
    private ObjectMapper objectMapper;

    @Value("${github.clientId}")
    private String clientId;

    @Value("${github.token}")
    private String token;

    @Autowired
    public GitHubHttpClientImplement(OkHttpClient client, ObjectMapper objectMapper) {
        this.client = client;
        this.objectMapper = objectMapper;
    }

    @Override
    public User getUser(String login) {
        User user = null;
        final String url = "https://api.github.com/users/" + login;
        Request request = getRequest(url);
        try {
            Response response = client.newCall(request).execute();
            if (response.code() == 200) {
                try {
                    user = objectMapper.readValue(Objects.requireNonNull(response.body()).string(), User.class);
                } catch (JsonProcessingException ex) {
                    logger.error("Caught an error during json processing: " + ex);
                }
                logRate(response);
            }
        } catch (IOException e) {
            logger.error("Caught an error during request call: " + e);
        }
        return user;
    }

    @Override
    public List<Repository> getUserRepositories(String login) {
        List<Repository> repositories = new ArrayList<>();
        final String url = "https://api.github.com/users/" + login + "/repos";
        Request request = getRequest(url);

        try {
            Response response = client.newCall(request).execute();
            if (response.code() == 200) {
                try {
                    repositories = objectMapper.readValue(Objects.requireNonNull(response.body()).string(), new TypeReference<>() {});
                } catch (JsonProcessingException ex) {
                    logger.error("Caught an error during json processing: " + ex);
                }
                logRate(response);
            }
        } catch (IOException e) {
            logger.error("Caught an error during request call: " + e);
        }
        return repositories;
    }

    @Override
    public List<Commit> getRepoCommits(String login, String repoName) {
        List<Commit> commits = new ArrayList<>();
        final String url = "https://api.github.com/repos/" + login + "/" + repoName + "/commits";
        Request request = getRequest(url);

        try {
           Response response = client.newCall(request).execute();
           if (response.code() == 200) {
               try {
                   commits = objectMapper.readValue(Objects.requireNonNull(response.body()).string(), new TypeReference<>() {});
               } catch (JsonProcessingException ex) {
                   logger.error("Caught an error during json processing: " + ex);
               }
               logRate(response);
           }
        } catch (IOException e) {
            logger.error("Caught an error during request call: " + e);
        }
        return commits;
    }

    private Request getRequest(String url) {
        return new Request.Builder()
                .url(url)
                .addHeader(clientId, token)
                .cacheControl(
                        new CacheControl.Builder()
                                .maxAge(60, TimeUnit.SECONDS)
                                .build()
                )
                .build();
    }

    private void logRate(Response response) {
        logger.info("Api calls: " + response.header("X-RateLimit-Remaining") + "/"+ response.header("X-RateLimit-Limit") + ";");
    }
}
