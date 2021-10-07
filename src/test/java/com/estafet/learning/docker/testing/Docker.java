package com.estafet.learning.docker.testing;

import com.github.dockerjava.api.DockerClient;


import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;


public class Docker {

    static DockerClientConfig standard = DefaultDockerClientConfig.createDefaultConfigBuilder().build();

    static DefaultDockerClientConfig clientConfig = DefaultDockerClientConfig.createDefaultConfigBuilder().withDockerHost("tcp://localhost:2375").build();
    static DockerClient dockerClient = DockerClientBuilder.getInstance(clientConfig).build();



    public static void sendCommand(String commandSequence) throws IOException {
        Process process = Runtime.getRuntime().exec(commandSequence);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}