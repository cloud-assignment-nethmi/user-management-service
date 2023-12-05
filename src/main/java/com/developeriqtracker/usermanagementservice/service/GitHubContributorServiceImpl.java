package com.developeriqtracker.usermanagementservice.service;

import com.developeriqtracker.usermanagementservice.dto.GitHubContributorDto;
import com.developeriqtracker.usermanagementservice.model.GitHubContributor;
import com.developeriqtracker.usermanagementservice.repository.GitHubContributorRepository;
import com.developeriqtracker.usermanagementservice.service.external.GitHubExternalClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GitHubContributorServiceImpl implements GitHubContributorService {

    private final GitHubExternalClient githubExternalClient;
    private final GitHubContributorRepository gitHubContributorRepository;

    @Override
    public List<GitHubContributor> getGitHubContributors() {
        List<GitHubContributor> gitHubContributors = new ArrayList<>();

        List<GitHubContributorDto> gitHubContributorDtoList = this.githubExternalClient.getUserDetails();
        gitHubContributorDtoList.forEach(gitHubContributorDto -> {
            GitHubContributor gitHubContributor = this.generateGitHubUserObject(gitHubContributorDto);
            gitHubContributors.add(gitHubContributor);
        });

        this.gitHubContributorRepository.saveAll(gitHubContributors);

        return gitHubContributors;


    }

    @Override
    public List<GitHubContributor> getAllContributors() {
        return this.gitHubContributorRepository.findAll();
    }

    private GitHubContributor generateGitHubUserObject(GitHubContributorDto gitHubContributorDto) {
        return GitHubContributor.builder()
                .gitHubId(gitHubContributorDto.getId())
                .login(gitHubContributorDto.getLogin())
                .contributions(gitHubContributorDto.getContributions())
                .type(gitHubContributorDto.getType())
                .siteAdmin(gitHubContributorDto.isSiteAdmin())
                .reposUrl(gitHubContributorDto.getReposUrl())
                .nodeId(gitHubContributorDto.getNodeId())
                .build();
    }

}

