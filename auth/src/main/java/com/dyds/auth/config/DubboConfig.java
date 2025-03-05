package com.dyds.auth.config;

import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.ProviderConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig {
    
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(20880);
        protocol.setSerialization("protobuf");
        return protocol;
    }

    @Bean
    public ProviderConfig providerConfig() {
        ProviderConfig provider = new ProviderConfig();
        provider.setTimeout(5000);
        provider.setRetries(0);
        return provider;
    }
}