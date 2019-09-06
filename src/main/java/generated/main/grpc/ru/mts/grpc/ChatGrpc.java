package ru.mts.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: Chat.proto")
public final class ChatGrpc {

  private ChatGrpc() {}

  public static final String SERVICE_NAME = "ru.mts.grpc.Chat";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ru.mts.grpc.Person,
      ru.mts.grpc.ChatMessageFromServer> getJoinMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "join",
      requestType = ru.mts.grpc.Person.class,
      responseType = ru.mts.grpc.ChatMessageFromServer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ru.mts.grpc.Person,
      ru.mts.grpc.ChatMessageFromServer> getJoinMethod() {
    io.grpc.MethodDescriptor<ru.mts.grpc.Person, ru.mts.grpc.ChatMessageFromServer> getJoinMethod;
    if ((getJoinMethod = ChatGrpc.getJoinMethod) == null) {
      synchronized (ChatGrpc.class) {
        if ((getJoinMethod = ChatGrpc.getJoinMethod) == null) {
          ChatGrpc.getJoinMethod = getJoinMethod = 
              io.grpc.MethodDescriptor.<ru.mts.grpc.Person, ru.mts.grpc.ChatMessageFromServer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ru.mts.grpc.Chat", "join"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.mts.grpc.Person.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.mts.grpc.ChatMessageFromServer.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatMethodDescriptorSupplier("join"))
                  .build();
          }
        }
     }
     return getJoinMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ru.mts.grpc.ChatMessage,
      ru.mts.grpc.ChatMessageFromServer> getSendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "send",
      requestType = ru.mts.grpc.ChatMessage.class,
      responseType = ru.mts.grpc.ChatMessageFromServer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ru.mts.grpc.ChatMessage,
      ru.mts.grpc.ChatMessageFromServer> getSendMethod() {
    io.grpc.MethodDescriptor<ru.mts.grpc.ChatMessage, ru.mts.grpc.ChatMessageFromServer> getSendMethod;
    if ((getSendMethod = ChatGrpc.getSendMethod) == null) {
      synchronized (ChatGrpc.class) {
        if ((getSendMethod = ChatGrpc.getSendMethod) == null) {
          ChatGrpc.getSendMethod = getSendMethod = 
              io.grpc.MethodDescriptor.<ru.mts.grpc.ChatMessage, ru.mts.grpc.ChatMessageFromServer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ru.mts.grpc.Chat", "send"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.mts.grpc.ChatMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.mts.grpc.ChatMessageFromServer.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatMethodDescriptorSupplier("send"))
                  .build();
          }
        }
     }
     return getSendMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChatStub newStub(io.grpc.Channel channel) {
    return new ChatStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChatBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChatFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChatFutureStub(channel);
  }

  /**
   */
  public static abstract class ChatImplBase implements io.grpc.BindableService {

    /**
     */
    public void join(ru.mts.grpc.Person request,
        io.grpc.stub.StreamObserver<ru.mts.grpc.ChatMessageFromServer> responseObserver) {
      asyncUnimplementedUnaryCall(getJoinMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ru.mts.grpc.ChatMessage> send(
        io.grpc.stub.StreamObserver<ru.mts.grpc.ChatMessageFromServer> responseObserver) {
      return asyncUnimplementedStreamingCall(getSendMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getJoinMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ru.mts.grpc.Person,
                ru.mts.grpc.ChatMessageFromServer>(
                  this, METHODID_JOIN)))
          .addMethod(
            getSendMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ru.mts.grpc.ChatMessage,
                ru.mts.grpc.ChatMessageFromServer>(
                  this, METHODID_SEND)))
          .build();
    }
  }

  /**
   */
  public static final class ChatStub extends io.grpc.stub.AbstractStub<ChatStub> {
    private ChatStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatStub(channel, callOptions);
    }

    /**
     */
    public void join(ru.mts.grpc.Person request,
        io.grpc.stub.StreamObserver<ru.mts.grpc.ChatMessageFromServer> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getJoinMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ru.mts.grpc.ChatMessage> send(
        io.grpc.stub.StreamObserver<ru.mts.grpc.ChatMessageFromServer> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ChatBlockingStub extends io.grpc.stub.AbstractStub<ChatBlockingStub> {
    private ChatBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatBlockingStub(channel, callOptions);
    }

    /**
     */
    public ru.mts.grpc.ChatMessageFromServer join(ru.mts.grpc.Person request) {
      return blockingUnaryCall(
          getChannel(), getJoinMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChatFutureStub extends io.grpc.stub.AbstractStub<ChatFutureStub> {
    private ChatFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ru.mts.grpc.ChatMessageFromServer> join(
        ru.mts.grpc.Person request) {
      return futureUnaryCall(
          getChannel().newCall(getJoinMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_JOIN = 0;
  private static final int METHODID_SEND = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChatImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChatImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_JOIN:
          serviceImpl.join((ru.mts.grpc.Person) request,
              (io.grpc.stub.StreamObserver<ru.mts.grpc.ChatMessageFromServer>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.send(
              (io.grpc.stub.StreamObserver<ru.mts.grpc.ChatMessageFromServer>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChatBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChatBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ru.mts.grpc.ChatOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Chat");
    }
  }

  private static final class ChatFileDescriptorSupplier
      extends ChatBaseDescriptorSupplier {
    ChatFileDescriptorSupplier() {}
  }

  private static final class ChatMethodDescriptorSupplier
      extends ChatBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChatMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChatGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChatFileDescriptorSupplier())
              .addMethod(getJoinMethod())
              .addMethod(getSendMethod())
              .build();
        }
      }
    }
    return result;
  }
}
