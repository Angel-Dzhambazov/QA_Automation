package com.estafet.learning.docker.testing;

import com.github.dockerjava.api.model.Network;

import java.util.List;

public class Networks  extends  Docker{

    public static void main(String[] args) {
        List<Network> networks = dockerClient.listNetworksCmd().exec();

        for (Network network : networks) {
            System.out.println(network.getName());
        }
    }
}
