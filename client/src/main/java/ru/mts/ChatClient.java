package ru.mts;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import ru.mts.entity.User;
import ru.mts.grpc.ChatGrpc;
import ru.mts.grpc.ChatMessage;
import ru.mts.grpc.ChatMessageFromServer;
import ru.mts.grpc.Person;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class ChatClient {
    private static final Logger LOGGER = Logger.getLogger(ChatClient.class.getName());

    private final ManagedChannel channel;
    private ChatGrpc.ChatBlockingStub chatBlockingStub;
    private ChatGrpc.ChatStub chatStub;

    public ChatClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build());
    }

    ChatClient(ManagedChannel channel) {
        this.channel = channel;
        chatBlockingStub =
                ChatGrpc.newBlockingStub(channel);
        chatStub = ChatGrpc.newStub(channel);

    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }


    public void join(User user) {
        Person person = Person.newBuilder().setName(user.getName()).build();
        LOGGER.info("client sending =" + person);

        ChatMessageFromServer greeting =
                chatBlockingStub.join(person);

        LOGGER.info("client received =" + greeting);


    }

    public void send(ChatMessage message) {

        StreamObserver<ChatMessage> chat = chatStub.send(new StreamObserver<ChatMessageFromServer>() {
            @Override
            public void onNext(ChatMessageFromServer value) {
                LOGGER.info("message recive");
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
                System.out.println("Disconnected");
            }

            @Override
            public void onCompleted() {
                System.out.println("Disconnected");
            }
        });
        chat.onNext(message);

    }


    public static void main(String[] args) throws Exception {
        ChatClient client = new ChatClient("localhost", 6565);
        try {
            String var = "do it";
            System.out.println("Hello! What's your name?");
            Scanner in = new Scanner(System.in);
            User user = User.builder().name(in.nextLine()).build();
            client.join(user);


            do {
                System.out.println("write a message or stop by send: stop chat");
                String mess = in.next();
                ChatMessage chatMessage = ChatMessage.newBuilder().setFrom(user.getName()).setMessage(mess).build();
                client.send(chatMessage);

                var = mess;
            } while (var.equals("stop chat"));

        } finally {
            client.shutdown();
        }
    }
}