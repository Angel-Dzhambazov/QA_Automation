package com.estafet.learning.docker.testing;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;

import java.util.List;

public class ListContainers  extends  Docker{
    public static void main(String[] args) {

        // docker container ps -a
        List<Container> containerList = dockerClient.listContainersCmd().withShowAll(true).exec();

        // docker container ps
        List<Container> containers = dockerClient.listContainersCmd().exec();


        System.out.println("listContainersCmd().withShowAll(true)");
        for (Container container : containerList) {
            System.out.println(container.getImage() + " " + container.getStatus());
        }

        System.out.println("");
        System.out.println("listContainersCmd()");
        for (Container container : containers) {
            System.out.println(container.getImage() + " " + container.getStatus());
        }
    }
}
