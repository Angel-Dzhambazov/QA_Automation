package com.estafet.learning.sprint7Docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.PullImageResultCallback;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public abstract class BasicDocker {
    private static final String DEFAULT_LOCAL_DOCKER_HOST = "tcp://localhost:2375";

    private static final DefaultDockerClientConfig clientConfig =
            DefaultDockerClientConfig.createDefaultConfigBuilder().withDockerHost(DEFAULT_LOCAL_DOCKER_HOST).build();
    public static DockerClient dockerClient = DockerClientBuilder.getInstance(clientConfig).build();

    public static void sendCommand(String commandSequence) throws IOException {
        Process process = Runtime.getRuntime().exec(commandSequence);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void pullImage(String imageName, String tag) {
        System.out.println("Downloading image " + imageName + ":" + tag);
        try {
            dockerClient.pullImageCmd(imageName)
                    .withTag(tag)
                    .exec(new PullImageResultCallback())
                    .awaitCompletion(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void pullImage(String imageName) {
        System.out.println("Downloading latest version!");
        pullImage(imageName, "latest");
    }

}
