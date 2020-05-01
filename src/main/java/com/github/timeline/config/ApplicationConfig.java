package com.github.timeline.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.timeline.httpclient.GitHubHttpClient;
import com.github.timeline.httpclient.GitHubHttpClientImplement;
import com.github.timeline.service.*;
import com.github.timeline.util.SorterService;
import com.github.timeline.util.SorterServiceImplement;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.github.timeline.*")
public class ApplicationConfig {
    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public GitHubHttpClient gitHubHttpClient() {
        return new GitHubHttpClientImplement(okHttpClient(), objectMapper());
    }

    @Bean
    public GitHubHttpClientService gitHubHttpClientService() {
        return new GitHubHttpClientServiceImplement(gitHubHttpClient(), sorterService());
    }

    @Bean
    public ModelFactoryService modelFactoryService() {
        return new ModelFactoryServiceImplement();
    }

    @Bean
    public SorterService sorterService() {
        return new SorterServiceImplement();
    }

    @Bean
    public TimeLineService timeLineService() {
        return new TimeLineServiceImplement(gitHubHttpClientService(), modelFactoryService());
    }
}
