package com.estafet.learning.docker;


import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;

import java.util.List;


public class Docker {
    public static void main(String[] args) {
        DockerClientConfig standard = DefaultDockerClientConfig.createDefaultConfigBuilder().build();

        DefaultDockerClientConfig clientConfig = DefaultDockerClientConfig.createDefaultConfigBuilder().withDockerHost("tcp://localhost:2375").build();
        DockerClient client = DockerClientBuilder.getInstance(clientConfig).build();


        List<Container> containerList = client.listContainersCmd().withShowAll(true).exec();

        for (Container container : containerList) {
            System.out.println(container.getImage() + " " + container.getStatus());
        }
    }
}