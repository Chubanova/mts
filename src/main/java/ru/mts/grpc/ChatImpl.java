package ru.mts.grpc;

import io.grpc.stub.StreamObserver;
import ru.mts.ChatGrpc;


import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import ru.mts.entity.*;

@GRpcService
public class ChatImpl
        extends ChatGrpc.ChatImplBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChatImpl.class);
    List<User> users = new ArrayList<>();
    private static Set<StreamObserver<ru.mts.grpc.ChatMessageFromServer>> observers = ConcurrentHashMap.newKeySet();

    public StreamObserver<ru.mts.grpc.ChatMessage> send(StreamObserver<ru.mts.grpc.ChatMessageFromServer> responseObserver) {
        observers.add(responseObserver);

        return new StreamObserver<ru.mts.grpc.ChatMessage>() {
            @Override
            public void onNext(ru.mts.grpc.ChatMessage value) {
                System.out.println(value);
                ru.mts.grpc.ChatMessageFromServer message = ru.mts.grpc.ChatMessageFromServer.newBuilder()
                        .setMessage(value)
                        .build();

                for (StreamObserver<ru.mts.grpc.ChatMessageFromServer> observer : observers) {
                    observer.onNext(message);

                }
            }

            @Override
            public void onError(Throwable t) {
                // do something;
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();

                observers.remove(responseObserver);
            }
        };
    }



    public void join(ru.mts.grpc.Person request, StreamObserver<ru.mts.grpc.ChatMessageFromServer> responseObserver) {
        LOGGER.info("server received {}", request);
        User user = User.builder().name(request.getName()).build();
        users.add(user);
        String message =  request.getName() + " join to chat";
        ru.mts.grpc.ChatMessage chatMessage = ru.mts.grpc.ChatMessage.newBuilder().setMessage(message).setFrom("Server").build();
        ru.mts.grpc.ChatMessageFromServer message1 = ru.mts.grpc.ChatMessageFromServer.newBuilder().setMessage(chatMessage).build();

        LOGGER.info("server responded {}", message1);

        for (User u: users) {
            LOGGER.info("server send message {}", message1+u.getName());
        }
        responseObserver.onNext(message1);
        responseObserver.onCompleted();

    }

}