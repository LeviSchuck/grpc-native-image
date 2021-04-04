package com.levischuck.grpc;

import io.grpc.ServerBuilder;
import lombok.val;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        val server = ServerBuilder.forPort(8000)
                .addService(new GreeterServiceImpl())
                .build();

        server.start();
        server.awaitTermination();
    }
}
