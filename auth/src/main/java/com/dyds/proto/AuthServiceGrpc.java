package com.dyds.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.59.0)",
    comments = "Source: auth.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AuthServiceGrpc {

  private AuthServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "auth.AuthService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.dyds.proto.AuthProto.DeliverTokenReq,
      com.dyds.proto.AuthProto.DeliveryResp> getDeliverTokenByRPCMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeliverTokenByRPC",
      requestType = com.dyds.proto.AuthProto.DeliverTokenReq.class,
      responseType = com.dyds.proto.AuthProto.DeliveryResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dyds.proto.AuthProto.DeliverTokenReq,
      com.dyds.proto.AuthProto.DeliveryResp> getDeliverTokenByRPCMethod() {
    io.grpc.MethodDescriptor<com.dyds.proto.AuthProto.DeliverTokenReq, com.dyds.proto.AuthProto.DeliveryResp> getDeliverTokenByRPCMethod;
    if ((getDeliverTokenByRPCMethod = AuthServiceGrpc.getDeliverTokenByRPCMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getDeliverTokenByRPCMethod = AuthServiceGrpc.getDeliverTokenByRPCMethod) == null) {
          AuthServiceGrpc.getDeliverTokenByRPCMethod = getDeliverTokenByRPCMethod =
              io.grpc.MethodDescriptor.<com.dyds.proto.AuthProto.DeliverTokenReq, com.dyds.proto.AuthProto.DeliveryResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeliverTokenByRPC"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dyds.proto.AuthProto.DeliverTokenReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dyds.proto.AuthProto.DeliveryResp.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("DeliverTokenByRPC"))
              .build();
        }
      }
    }
    return getDeliverTokenByRPCMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dyds.proto.AuthProto.VerifyTokenReq,
      com.dyds.proto.AuthProto.VerifyResp> getVerifyTokenByRPCMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VerifyTokenByRPC",
      requestType = com.dyds.proto.AuthProto.VerifyTokenReq.class,
      responseType = com.dyds.proto.AuthProto.VerifyResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dyds.proto.AuthProto.VerifyTokenReq,
      com.dyds.proto.AuthProto.VerifyResp> getVerifyTokenByRPCMethod() {
    io.grpc.MethodDescriptor<com.dyds.proto.AuthProto.VerifyTokenReq, com.dyds.proto.AuthProto.VerifyResp> getVerifyTokenByRPCMethod;
    if ((getVerifyTokenByRPCMethod = AuthServiceGrpc.getVerifyTokenByRPCMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getVerifyTokenByRPCMethod = AuthServiceGrpc.getVerifyTokenByRPCMethod) == null) {
          AuthServiceGrpc.getVerifyTokenByRPCMethod = getVerifyTokenByRPCMethod =
              io.grpc.MethodDescriptor.<com.dyds.proto.AuthProto.VerifyTokenReq, com.dyds.proto.AuthProto.VerifyResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "VerifyTokenByRPC"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dyds.proto.AuthProto.VerifyTokenReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dyds.proto.AuthProto.VerifyResp.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("VerifyTokenByRPC"))
              .build();
        }
      }
    }
    return getVerifyTokenByRPCMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthServiceStub>() {
        @java.lang.Override
        public AuthServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthServiceStub(channel, callOptions);
        }
      };
    return AuthServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthServiceBlockingStub>() {
        @java.lang.Override
        public AuthServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthServiceBlockingStub(channel, callOptions);
        }
      };
    return AuthServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthServiceFutureStub>() {
        @java.lang.Override
        public AuthServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthServiceFutureStub(channel, callOptions);
        }
      };
    return AuthServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void deliverTokenByRPC(com.dyds.proto.AuthProto.DeliverTokenReq request,
                                   io.grpc.stub.StreamObserver<com.dyds.proto.AuthProto.DeliveryResp> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeliverTokenByRPCMethod(), responseObserver);
    }

    /**
     */
    default void verifyTokenByRPC(com.dyds.proto.AuthProto.VerifyTokenReq request,
                                  io.grpc.stub.StreamObserver<com.dyds.proto.AuthProto.VerifyResp> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getVerifyTokenByRPCMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AuthService.
   */
  public static abstract class AuthServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AuthServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AuthService.
   */
  public static final class AuthServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AuthServiceStub> {
    private AuthServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthServiceStub(channel, callOptions);
    }

    /**
     */
    public void deliverTokenByRPC(com.dyds.proto.AuthProto.DeliverTokenReq request,
                                  io.grpc.stub.StreamObserver<com.dyds.proto.AuthProto.DeliveryResp> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeliverTokenByRPCMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void verifyTokenByRPC(com.dyds.proto.AuthProto.VerifyTokenReq request,
                                 io.grpc.stub.StreamObserver<com.dyds.proto.AuthProto.VerifyResp> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerifyTokenByRPCMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AuthService.
   */
  public static final class AuthServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AuthServiceBlockingStub> {
    private AuthServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.dyds.proto.AuthProto.DeliveryResp deliverTokenByRPC(com.dyds.proto.AuthProto.DeliverTokenReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeliverTokenByRPCMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.dyds.proto.AuthProto.VerifyResp verifyTokenByRPC(com.dyds.proto.AuthProto.VerifyTokenReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerifyTokenByRPCMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AuthService.
   */
  public static final class AuthServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AuthServiceFutureStub> {
    private AuthServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dyds.proto.AuthProto.DeliveryResp> deliverTokenByRPC(
        com.dyds.proto.AuthProto.DeliverTokenReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeliverTokenByRPCMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dyds.proto.AuthProto.VerifyResp> verifyTokenByRPC(
        com.dyds.proto.AuthProto.VerifyTokenReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerifyTokenByRPCMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DELIVER_TOKEN_BY_RPC = 0;
  private static final int METHODID_VERIFY_TOKEN_BY_RPC = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DELIVER_TOKEN_BY_RPC:
          serviceImpl.deliverTokenByRPC((com.dyds.proto.AuthProto.DeliverTokenReq) request,
              (io.grpc.stub.StreamObserver<com.dyds.proto.AuthProto.DeliveryResp>) responseObserver);
          break;
        case METHODID_VERIFY_TOKEN_BY_RPC:
          serviceImpl.verifyTokenByRPC((com.dyds.proto.AuthProto.VerifyTokenReq) request,
              (io.grpc.stub.StreamObserver<com.dyds.proto.AuthProto.VerifyResp>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getDeliverTokenByRPCMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.dyds.proto.AuthProto.DeliverTokenReq,
              com.dyds.proto.AuthProto.DeliveryResp>(
                service, METHODID_DELIVER_TOKEN_BY_RPC)))
        .addMethod(
          getVerifyTokenByRPCMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.dyds.proto.AuthProto.VerifyTokenReq,
              com.dyds.proto.AuthProto.VerifyResp>(
                service, METHODID_VERIFY_TOKEN_BY_RPC)))
        .build();
  }

  private static abstract class AuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dyds.proto.AuthProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AuthService");
    }
  }

  private static final class AuthServiceFileDescriptorSupplier
      extends AuthServiceBaseDescriptorSupplier {
    AuthServiceFileDescriptorSupplier() {}
  }

  private static final class AuthServiceMethodDescriptorSupplier
      extends AuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AuthServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuthServiceFileDescriptorSupplier())
              .addMethod(getDeliverTokenByRPCMethod())
              .addMethod(getVerifyTokenByRPCMethod())
              .build();
        }
      }
    }
    return result;
  }
}
