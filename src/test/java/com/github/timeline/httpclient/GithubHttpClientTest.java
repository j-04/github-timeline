package com.github.timeline.httpclient;

import com.github.timeline.entity.Commit;
import com.github.timeline.entity.Repository;
import com.github.timeline.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GithubHttpClientTest {
    @Autowired
    @Qualifier("gitHubHttpClient")
    private GitHubHttpClient client;

    @Before
    public void before() {
        for (int i = 0; i < 30; i++) {
            System.out.print("-------");
        }
        System.out.println();
    }

    @Test
    public void testSuccessfulGetUser() {
        final String login = "j-04";
        User user = client.getUser(login);
        System.out.println(user);
        Assert.assertNotNull(user);
    }

    @Test
    public void testUnsuccessfulGetUser() {
        final String wrongLogin = "jjj-0123";
        User user = client.getUser(wrongLogin);
        Assert.assertNull(user);
        System.out.println(user);
    }

    @Test
    public void testSuccessfulGetRepositories() {
        final String login = "j-04";
        List<Repository> repositories = client.getUserRepositories(login);
        System.out.println(repositories);
        Assert.assertNotNull(repositories);
    }

    @Test
    public void testUnsuccessfulGetRepositories() {
        final String login = "jjj-0123";
        List<Repository> repositories = client.getUserRepositories(login);
        System.out.println(repositories);
        Assert.assertNull(repositories);
    }

    @Test
    public void testSuccessfulGetCommits() {
        final String login = "j-04";
        final String repoName = "artificial-neural-networks";
        List<Commit> commits = client.getRepoCommits(login, repoName);
        System.out.println(commits);
        Assert.assertNotNull(commits);
    }
}
