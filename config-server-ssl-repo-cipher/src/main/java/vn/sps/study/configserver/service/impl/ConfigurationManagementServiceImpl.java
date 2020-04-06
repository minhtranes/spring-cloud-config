/*
 * Class: ConfigurationManagementService
 *
 * Created on Sep 18, 2018
 *
 * (c) Copyright Swiss Post Solutions Ltd, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package vn.sps.study.configserver.service.impl;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.server.environment.MultipleJGitEnvironmentRepository;
import org.springframework.stereotype.Service;

import vn.sps.study.configserver.service.ConfigurationManagementService;

@Service
public class ConfigurationManagementServiceImpl
        implements ConfigurationManagementService {

    private static final Logger LOGGER = LoggerFactory
        .getLogger(ConfigurationManagementServiceImpl.class);

    private Git git = null;

    @Autowired
    private MultipleJGitEnvironmentRepository repository;

    private CredentialsProvider credentialsProvider;
    
    @PostConstruct
    void initialize() {
        credentialsProvider = new UsernamePasswordCredentialsProvider(repository.getUsername(), repository.getPassword());
    }

    @Override
    public void commitAndPush(
        final String application,
        final String profile,
        final String label,
        final String message) throws Exception {

        this.init();

        // Make the local repository ready
        this.repository.getLocations(application, profile, label);

        this.git.commit().setAll(true).setMessage(message).call();

        this.git.push()
            .setCredentialsProvider(credentialsProvider)
            .call();

        LOGGER.info("Pushed local repository with message [{}].", message);
    }

    @SuppressWarnings("unused")
    private File getWorkingDirectory() {
        return this.repository.getBasedir();
    }

    private void init() throws IOException {
        if (this.git != null) {
            return;
        }

        final String repoPath = this.repository.getBasedir().getPath();
        final Repository localRepo = new FileRepository(repoPath + "/.git");
        this.git = new Git(localRepo);
        LOGGER.info("Initialized local repository at path {}", repoPath);
    }

    @SuppressWarnings("unused")
    private void updateLocalRepo() throws Exception {
        LOGGER.info("Updating the local repository.");
        this.init();
        this.git.pull()
        .setCredentialsProvider(credentialsProvider)
            .call();
    }
}
