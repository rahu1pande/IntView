package com.intView.config;

import com.theokanning.openai.service.OpenAiService;

import io.github.cdimascio.dotenv.Dotenv;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfig {

    @Value("${openai.api-key}")
    private String apiKey;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.temperature}")
    private Double temperature;

    @Value("${openai.max-tokens}")
    private Integer maxTokens;

    @Bean
    public Dotenv dotenv() {
        return Dotenv.configure().ignoreIfMissing().load();
    }

    @Bean
    public OpenAiService openAiService() {
        return new OpenAiService(apiKey);
    }

    @Bean
    public String model() {
        return model;
    }

    @Bean
    public Double temperature() {
        return temperature;
    }

    @Bean
    public Integer maxTokens() {
        return maxTokens;
    }
} 