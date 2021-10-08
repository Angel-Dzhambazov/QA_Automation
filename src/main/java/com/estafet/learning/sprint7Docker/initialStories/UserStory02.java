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

        /*
        //create and populate MySQL container with DB and data
        String mysqlContainerName = "automated-mysql-container";
        String mysqlDockerfileLocation = "src/main/resources/mysqlimageDockerfile/Dockerfile";

        Integer defaultMySQLPort = 3306;
        Integer hostMySqlPort = 3307;
        createAndPopulateDB(mysqlContainerName, mysqlDockerfileLocation, defaultMySQLPort, hostMySqlPort);
         */


        //Create and populate PostgreSQL container with DB and data
        String postgresContainerName = "automated-postgres-container";
        String postgresDockerfileLocation = "src/main/resources/postgresImageDockerfile/Dockerfile";

        Integer defaultPostgresPort = 5432;
        Integer hostPostgresPort = 5432;
        createAndPopulateDB(postgresContainerName, postgresDockerfileLocation, defaultPostgresPort, hostPostgresPort);

    }

    private static void createAndPopulateDB(String containerName, String dockerfileLocation, Integer defaultPort, Integer hostPort){
        // subTask 01 create postgres and mysql dockerfile
        String customPostgresImage = dockerClient.buildImageCmd()
                .withDockerfile(new File(dockerfileLocation))
                .withPull(true)
                .withNoCache(true)
                .exec(new BuildImageResultCallback())
                .awaitImageId();


//        ExposedPort tcp5432 = ExposedPort.tcp(5432);
        Ports portBindings = new Ports();
        portBindings.bind(ExposedPort.tcp(defaultPort), Ports.Binding.bindPort(hostPort));


        CreateContainerResponse container
                = dockerClient.createContainerCmd(customPostgresImage)
                .withExposedPorts(ExposedPort.tcp(defaultPort))
                .withHostConfig(newHostConfig().withPortBindings(portBindings))
                .withName(containerName)
                .exec();

        //subTask 03 start / stop / kill container
        dockerClient.startContainerCmd(containerName).exec();
    }
}