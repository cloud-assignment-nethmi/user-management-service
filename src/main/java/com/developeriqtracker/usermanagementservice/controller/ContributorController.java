package com.developeriqtracker.usermanagementservice.controller;

import com.developeriqtracker.usermanagementservice.model.GitHubContributor;
import com.developeriqtracker.usermanagementservice.service.GitHubContributorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/git-hub")

public class ContributorController {

    private GitHubContributorService gitHubContributorService;

    @GetMapping("/contributors")
    public ResponseEntity<List<GitHubContributor>> getGitHubContributors() {
        return ResponseEntity.ok(this.gitHubContributorService.getGitHubContributors());
    }

    @GetMapping("/contributors/get-all")
    public ResponseEntity<List<GitHubContributor>> getAllContributors() {
        return ResponseEntity.ok(this.gitHubContributorService.getAllContributors());
    }
}


