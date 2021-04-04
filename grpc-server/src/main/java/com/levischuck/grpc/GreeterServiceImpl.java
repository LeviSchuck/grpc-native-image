package com.levischuck.grpc;

import com.levischuck.grpc.schema.GreeterGrpc;
import com.levischuck.grpc.schema.HelloReply;
import com.levischuck.grpc.schema.HelloRequest;
import io.grpc.stub.StreamObserver;

import java.util.Locale;

public class GreeterServiceImpl extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        responseObserver.onNext(HelloReply.newBuilder()
                .setMessage("Hello " + request.getName().toUpperCase(Locale.ROOT))
                .build());
        responseObserver.onCompleted();
    }
}
