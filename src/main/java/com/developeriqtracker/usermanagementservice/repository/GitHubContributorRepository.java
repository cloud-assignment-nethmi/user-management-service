package com.developeriqtracker.usermanagementservice.repository;

import com.developeriqtracker.usermanagementservice.model.GitHubContributor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GitHubContributorRepository extends MongoRepository<GitHubContributor, String> {

}

