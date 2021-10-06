package com.estafet.learning.docker.testing;

import com.github.dockerjava.api.command.BuildImageResultCallback;

import java.io.File;

public class BuildImage  extends  Docker{

    public static void main(String[] args) {
        String imageId = dockerClient.buildImageCmd()
                .withDockerfile(new File("E:\\Estafet\\QA_Automation\\src\\test\\resources\\docker\\postgres case\\Dockerfile"))
                .withPull(true)
                .withNoCache(true)
                .exec(new BuildImageResultCallback())
                .awaitImageId();
    }
}
