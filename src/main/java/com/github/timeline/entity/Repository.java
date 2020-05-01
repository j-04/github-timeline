package com.github.timeline.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {
    @JsonProperty("stargazers_count")
    private int stars;
    @JsonProperty("watchers_count")
    private int watchers;
    @JsonProperty(required = false)
    private boolean hasCommits;
    private long id;
    @JsonProperty("fork")
    private String isFork;
    private String name;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("description")
    private String description;
}
