package com.estafet.learning.docker.testing;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.Bind;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateContainer extends  Docker {
    public static void main(String[] args) {

        // this creates bugged container. Cannot be started
        CreateContainerResponse container
                = dockerClient.createContainerCmd("ubuntu")
                .withName("mongo-ubuntu").exec();






        // from Dockerfile

//        File appFile = new File("src/test/resources/docker/postgres case/docker-compose.yml");
//
//        ImageFromDockerfile image = new ImageFromDockerfile()
//                .withDockerfileFromBuilder(builder -> builder.from("payara/micro:5.193")
//                        .cmd("--deploymentDir", "/opt/payara/deployments", "--noCluster")
//                        .add(appName, "/opt/payara/deployments")
//                        .build())
//                .withFileFromFile(appName, appFile);

    }


}
