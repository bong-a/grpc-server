package com.example.grpc;

import org.springframework.stereotype.Service;

import com.levi.yoon.proto.SampleRequest;
import com.levi.yoon.proto.SampleResponse;
import com.levi.yoon.proto.SampleServiceGrpc;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SampleService extends SampleServiceGrpc.SampleServiceImplBase {
    @Override
    public void sampleCall(SampleRequest request, StreamObserver<SampleResponse> responseObserver) {
        log.info("SampleServiceImpl#sampleCall - {}, {}", request.getUserId(), request.getMessage());
        SampleResponse sampleResponse = SampleResponse.newBuilder()
            .setMessage("grpc service response")
            .build();

        responseObserver.onNext(sampleResponse);
        responseObserver.onCompleted();
    }
}
