package com.developeriqtracker.usermanagementservice.service;

import com.developeriqtracker.usermanagementservice.model.GitHubContributor;

import java.util.List;

public interface GitHubContributorService {

    List<GitHubContributor> getGitHubContributors();

    List<GitHubContributor> getAllContributors();
}


