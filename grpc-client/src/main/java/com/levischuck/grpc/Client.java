package com.levischuck.grpc;

import com.levischuck.grpc.schema.GreeterGrpc;
import com.levischuck.grpc.schema.HelloRequest;
import io.grpc.ManagedChannelBuilder;
import lombok.val;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        val channel = ManagedChannelBuilder.forAddress("localhost", 8000)
                .usePlaintext()
                .build();
        val stub = GreeterGrpc.newBlockingStub(channel);

        // Warm it up
        stub.sayHello(HelloRequest.newBuilder()
                .setName(String.join(" ", args))
                .build());

        val before = Instant.now();
        for (int i = 0; i < 10; i++) {
            stub.sayHello(HelloRequest.newBuilder()
                    .setName(String.join(" ", args))
                    .build());
        }
        val after = Instant.now();
        val millis = TimeUnit.MILLISECONDS.convert(Duration.between(before, after).getNano(), TimeUnit.NANOSECONDS);
        System.out.println("10 calls took " + millis + " ms");
        Thread.sleep(60000);
    }
}
