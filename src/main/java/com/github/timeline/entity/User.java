package com.github.timeline.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private int followers;
    private int following;
    private String id;
    private String login;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("repos_url")
    private String reposUrl;
    private String type;
    private String name;
    private String email;
    private String bio;
    private String company;
    @JsonProperty("created_at")
    private String createdAt;
}