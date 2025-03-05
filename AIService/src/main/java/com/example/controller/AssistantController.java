package com.example.controller;

import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatOptions;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

/**
 * @className: HelloWorldController
 * @author: bingjie_zou@163.com
 * @date: 2025/2/11 13:30
 * @version: 1.0
 * @description: helloworld
 */

@RestController
@RequestMapping("/assistant")
@CrossOrigin(value = "*")
public class AssistantController {

    private final ChatClient dashScopeChatClient;

	// 初始化聊天模型客户端
    public AssistantController(ChatClient.Builder ChatClientBuilder) {
        this.dashScopeChatClient = ChatClientBuilder
				//defaultSystem负责指定每次对话系统携带的文本，类似于智能客服的服务宗旨 需要时时谨记
                .defaultSystem("""
                       您是添砖java商城的客户聊天支持代理。请以友好、乐于助人且愉快的方式来回复。
                       您正在通过在线聊天系统与客户互动。
                       您能够支持已下单商品的订单信息查询、模拟自动下单等操作，其余功能将在后续版本中添加，如果用户问的问题不支持请告知详情。
					   以下是您为客户提供支持时需要注意的事项：
					   1.在进行订单信息查询之前，您必须始终从用户处获取以下信息：订单号、用户ID、订单状态，其中订单状态有四个可选项，
					   你需要将用户传达的意图与这四个选项进行匹配，这四个选项分别是pending（待支付）, paid（已支付）, canceled（取消）, delivered（已发货），
					   另外，这订单号和用户姓名这两个参数你至少需要获取一个，订单状态可选可不选。
					   2.在帮助用户下单之前，你需要先获得用户的ID以及用户想要购买的商品的ID和数量，商品的ID和数量需要被封装好并放入一个列表中。这个列表将会作为
					   一个参数和用户ID一起被封装好传递给接口。在这个功能里，我所提到的三个参数都是必须的，不允许缺失。另外，在下单前，请将
					   用户的购买详情整理好展示给用户，以便用户进行确认，在用户确认后再调用接口执行下单操作。
					   3.在询问用户之前，请检查消息历史记录以获取订单号、客户姓名、订单状态还有商品ID、购买数量等信息，尽量避免重复询问给用户造成困扰。
					   在进行模拟自动下单之前，您必须确保条款允许这样做。
					   如果操作失败，请将错误信息以普通人能听懂的方式讲给用户听，以便用户知道如何调整自己的才做。
					   使用提供的功能进行订单信息查询、模拟自动下单等操作。
					   如果需要，您可以调用相应函数辅助完成。
					   请讲中文。
					   今天的日期是 {current_date}.""")
				//defaultAdvisors是默认的拦截器，这里为大模型添加了存储在内存的历史聊天记录，是模型具有记忆功能
                .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
				//这里添加了一个日志拦截器，用于记录日志，便于调试
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .defaultOptions(DashScopeChatOptions.builder().withTopP(0.7).build())
				//告诉大模型我们注册了一个函数，让大模型在对话的时候可以去调用
				.defaultFunctions("getOrderDetails", "simulationOrder")
                .build();
    }


	//produces指定了该接口与前端开启的是text/event_stream类型的对话，可以保持
	/**
	 *
	 * @param chatId 用于区别不同的用户，方便模型检索历史对话
	 * @param userMessage 用户的输入，用于模型生成回答
	 * @return Flux<String>是专门使用于流式对话的格式
	 */
    @GetMapping(value = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> simpleChat(String chatId, String userMessage) {
        return this.dashScopeChatClient
                .prompt()
                .user(userMessage)
				//用来动态填充defaultSystem中的日期参数
                .system(s -> s.param("current_date", LocalDate.now().toString()))
				//指定流式输出
                .stream()
				//生成Flux<String>格式的结果
                .content();
    }


}

