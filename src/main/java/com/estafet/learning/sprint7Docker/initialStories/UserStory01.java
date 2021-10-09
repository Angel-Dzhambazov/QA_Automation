package com.estafet.learning.sprint7Docker.initialStories;

import com.estafet.learning.sprint7Docker.BasicDocker;
import com.github.dockerjava.api.command.BuildImageResultCallback;
import com.github.dockerjava.api.command.CreateContainerResponse;

import java.io.File;

public class UserStory01 extends BasicDocker {
    public static void main(String[] args) throws InterruptedException {

        //subTask 01 Pull an image with dynamic parameter

        System.out.println("Downloading image with just image name...");
        pullImage("ubuntu");

        System.out.println("Downloading image with image name and tag 14");
        pullImage("ubuntu", "14.04");

        //subTask 02 Create docker container

        String customUbuntuImageId = dockerClient.buildImageCmd()
                .withDockerfile(new File("src/main/resources/ubuntuBaseDockerfile/Dockerfile"))
                .withPull(true)
                .withNoCache(true)
                .exec(new BuildImageResultCallback())
                .awaitImageId();

        String containerName = "automated--container-from-docker-file-333";
        CreateContainerResponse container
                = dockerClient.createContainerCmd(customUbuntuImageId)
                .withName(containerName)
                .exec();

        //subTask 03 start / stop / kill container
        dockerClient.startContainerCmd(containerName).exec();

        System.out.println("Container: " + containerName + " successfully started!");
        System.out.println("Sleeping for 2 seconds!");
        Thread.sleep(1000*2);

        dockerClient.stopContainerCmd(containerName).exec();

        System.out.println("Container: " + containerName + " successfully stopped!");
        System.out.println("Sleeping for 2 seconds!");
        Thread.sleep(1000*2);

        dockerClient.removeContainerCmd(containerName).exec();

        System.out.println("Container: " + containerName + " successfully deleted!");
        System.out.println("Sleeping for 2 seconds!");
        Thread.sleep(1000*2);

        // subtask 04 create network
        String networkName = "my-automated-network";

        dockerClient.createNetworkCmd()
                .withName(networkName)
                .exec();

        System.out.println("Network: " + networkName + " successfully created!");
        System.out.println("Sleeping for 2 seconds!");
        Thread.sleep(1000*2);

        // subTask 05 create image from docker file - done in 02

        // subTask 06 remove containers - done in 03

        // subTask 07 remove image

        dockerClient.removeImageCmd(customUbuntuImageId).exec();
        System.out.println("Imate: " + customUbuntuImageId + " successfully deleted!");
        System.out.println("Sleeping for 30 seconds!");
        Thread.sleep(1000*2);

        // also "docker system prune" can be used to delete all images, containers,
        //                                              volumes and networks not connected to any containers
    }
}


// *docker pull images with dynamic parameter
//         -Docker create a container
//         - run containers with dynamic parameters
//         -Start, Stop, Kill
//         *docker create a network
//         *build image from dockerfile
//         *removing containers
//         *removing images