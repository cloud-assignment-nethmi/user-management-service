package com.developeriqtracker.usermanagementservice;

import com.developeriqtracker.usermanagementservice.model.GitHubContributor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class GitHubContributorTest {

    @InjectMocks
    private GitHubContributor gitHubContributor;

    @Test
    public void testGitHubContributorModel() {
        // Mock data
        String id = "123";
        String login = "john_doe";
        int gitHubId = 456;
        String nodeId = "abc123";
        String reposUrl = "https://github.com/john_doe/repos";
        String type = "user";
        boolean siteAdmin = false;
        int contributions = 10;

        // Set mock data on the model
        gitHubContributor.setId(id);
        gitHubContributor.setLogin(login);
        gitHubContributor.setGitHubId(gitHubId);
        gitHubContributor.setNodeId(nodeId);
        gitHubContributor.setReposUrl(reposUrl);
        gitHubContributor.setType(type);
        gitHubContributor.setSiteAdmin(siteAdmin);
        gitHubContributor.setContributions(contributions);

        // Verify the model's data
        assertEquals(id, gitHubContributor.getId());
        assertEquals(login, gitHubContributor.getLogin());
        assertEquals(gitHubId, gitHubContributor.getGitHubId());
        assertEquals(nodeId, gitHubContributor.getNodeId());
        assertEquals(reposUrl, gitHubContributor.getReposUrl());
        assertEquals(type, gitHubContributor.getType());
        assertEquals(siteAdmin, gitHubContributor.isSiteAdmin());
        assertEquals(contributions, gitHubContributor.getContributions());
    }
}

