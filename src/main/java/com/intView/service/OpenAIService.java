package com.intView.service;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class OpenAIService {
    private final OpenAiService openAiService;
    private final String model;
    private final Double temperature;
    private final Integer maxTokens;

    public String generateText(String topic) {
        String prompt = "Generate an interview question about: " + topic;
        return generateContent(prompt);
    }

    public String generateAnswer(String question) {
        String prompt = "Provide a detailed answer to this interview question: " + question;
        return generateContent(prompt);
    }

    private String generateContent(String prompt) {
        ChatMessage message = new ChatMessage("user", prompt);
        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .model(model)
                .messages(List.of(message))
                .temperature(temperature)
                .maxTokens(maxTokens)
                .build();

        return openAiService.createChatCompletion(request)
                .getChoices().get(0).getMessage().getContent();
    }
} 