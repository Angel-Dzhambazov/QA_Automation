package com.estafet.learning.docker.testing;

import com.github.dockerjava.api.DockerClient;


import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;


import java.io.File;
import java.time.Duration;


public class Docker {

    static DockerClientConfig standard = DefaultDockerClientConfig.createDefaultConfigBuilder().build();

    static DefaultDockerClientConfig clientConfig = DefaultDockerClientConfig.createDefaultConfigBuilder().withDockerHost("tcp://localhost:2375").build();
    static DockerClient dockerClient = DockerClientBuilder.getInstance(clientConfig).build();

    public static void main(String[] args) {


        DockerHttpClient httpClient = new ApacheDockerHttpClient.Builder()
                .dockerHost(clientConfig.getDockerHost())
                .sslConfig(clientConfig.getSSLConfig())
                .maxConnections(100)
                .connectionTimeout(Duration.ofSeconds(30))
                .responseTimeout(Duration.ofSeconds(45))
                .build();

        /*
        String imageId = dockerClient.buildImageCmd()
                .withDockerfile(new File("E:\\Estafet\\QA_Automation\\src\\test\\resources\\docker\\postgres case\\Dockerfile"))
                .withPull(true)
                .withNoCache(true)
                .exec(new BuildImageResultCallback())
                .awaitImageId();


        dockerClient.createContainerCmd(imageId)
                .withName("my-stupid-automated-postgres-container") // --name=alabala works
                .withCmd("-p 5432:5432")
                .exec();


         */


    }
}