package com.estafet.learning.sprint7Docker.initialStories;

import com.estafet.learning.sprint7Docker.BasicDocker;
import com.github.dockerjava.api.command.BuildImageResultCallback;
import com.github.dockerjava.api.command.CreateContainerResponse;

import java.io.File;

public class UserStory01 extends BasicDocker {
    public static void main(String[] args) {

        //subTask 01 Pull an image with dynamic parameter

        /*
        System.out.println("Downloading image with just image name...");
        pullImage("ubuntu");

        System.out.println("Downloading image with image name and tag 14");
        pullImage("ubuntu", "14.04");
        */

        //subTask 02 Create docker container


        String imageId = dockerClient.buildImageCmd()
                .withDockerfile(new File("src/main/resources/ubuntuBaseDockerfile/Dockerfile"))
                .withPull(true)
                .withNoCache(true)
                .exec(new BuildImageResultCallback())
                .awaitImageId();

        CreateContainerResponse container
                = dockerClient.createContainerCmd(imageId)
                .withName("automated-container-from-docker-file")
                .exec();

        dockerClient.startContainerCmd("automated-container-from-docker-file").exec();




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
