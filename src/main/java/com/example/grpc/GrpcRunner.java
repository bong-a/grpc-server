package com.example.grpc;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import io.grpc.Server;
import io.grpc.ServerBuilder;

@Component
public class GrpcRunner implements ApplicationRunner {

    private static final int PORT = 3030;
    private static final Server SERVER = ServerBuilder.forPort(PORT)
        .addService(new SampleService())
        .build();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        SERVER.start();
    }
}