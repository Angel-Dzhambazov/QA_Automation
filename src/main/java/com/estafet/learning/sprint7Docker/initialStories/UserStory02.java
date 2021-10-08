package com.estafet.learning.sprint7Docker.initialStories;

import com.estafet.learning.sprint7Docker.BasicDocker;
import com.github.dockerjava.api.command.BuildImageResultCallback;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.Ports;

import java.io.File;

import static com.github.dockerjava.api.model.HostConfig.newHostConfig;

public class UserStory02 extends BasicDocker {
    public static void main(String[] args) {
        // subTask 01 create postgres and mysql dockerfile
        String customPostgresImage = dockerClient.buildImageCmd()
                .withDockerfile(new File("src/main/resources/postgresImageDockerfile/Dockerfile"))
                .withPull(true)
                .withNoCache(true)
                .exec(new BuildImageResultCallback())
                .awaitImageId();

        ExposedPort tcp5432 = ExposedPort.tcp(5432);
        Ports portBindings = new Ports();
        portBindings.bind(tcp5432, Ports.Binding.bindPort(5432));

        String containerName = "automated-postgres-container";
        CreateContainerResponse container
                = dockerClient.createContainerCmd(customPostgresImage)
                .withExposedPorts(tcp5432)
                .withHostConfig(newHostConfig().withPortBindings(portBindings))
                .withName(containerName)
                .exec();

        //subTask 03 start / stop / kill container
        dockerClient.startContainerCmd(containerName).exec();
    }
}