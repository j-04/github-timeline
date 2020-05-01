package com.github.timeline.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Commit {
    private String sha;
    @JsonProperty("commit")
    private CommitProperty commitProperty;
    @JsonProperty("html_url")
    private String htmlUrl;

    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CommitProperty {
        @JsonProperty("committer")
        Committer committer;
        @JsonProperty("message")
        String message;
    }

    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Committer {
        @JsonProperty("name")
        String name;
        @JsonProperty("email")
        String email;
        @JsonProperty("date")
        String date;
    }
}
