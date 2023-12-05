package com.developeriqtracker.usermanagementservice.service.external;


import com.developeriqtracker.usermanagementservice.dto.GitHubContributorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
public class GitHubExternalClient {

    private final RestTemplate restTemplate;

    @Value("${github.user-detail-url}")
    private String gitHubUserDetailsUrl;

    public GitHubExternalClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GitHubContributorDto> getUserDetails() {
        ResponseEntity<List<GitHubContributorDto>> response = restTemplate.exchange(gitHubUserDetailsUrl, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
    }


}
