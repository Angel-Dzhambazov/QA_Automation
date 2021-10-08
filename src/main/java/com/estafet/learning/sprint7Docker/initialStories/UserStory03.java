package com.estafet.learning.sprint7Docker.initialStories;

import com.estafet.learning.sprint7Docker.BasicDocker;

import java.io.IOException;

public class UserStory03 extends BasicDocker {
    public static void main(String[] args) throws IOException {
        String filepathSelenium = "E:\\Estafet\\QA_Automation\\src\\main\\resources\\seleniumGrid\\docker-compose.yml";
        String seleniumGridCommand = "docker-compose -f " + filepathSelenium + " up -d";

        System.out.println(seleniumGridCommand);

        sendCommand(seleniumGridCommand);
    }
}
