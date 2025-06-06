package com.intView.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.intView.service.OpenAIService;

import java.util.Map;

@Controller
@RequestMapping("/interview")
public class InterviewSessionController {

    private final OpenAIService openAIService;

    @Autowired
    public InterviewSessionController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping("/question")
    public ResponseEntity<String> getQuestion(@RequestBody String topic) {
        try {
            String question = openAIService.generateText(topic);
            return ResponseEntity.ok(question);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error generating question: " + e.getMessage());
        }
    }

    @PostMapping("/answer")
    public ResponseEntity<String> getAnswer(@RequestBody Map<String, String> request) {
        try {
            String question = request.get("question");
            String answer = openAIService.generateAnswer(question);
            return ResponseEntity.ok(answer);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error generating answer: " + e.getMessage());
        }
    }

    // @PostMapping("/generate-with-context")
    // public ResponseEntity<String> generateTextWithContext(
    //         @RequestParam String prompt,
    //         @RequestParam String context) {
    //     try {
    //         String response = openAIService.generateTextWithContext(prompt, context);
    //         return ResponseEntity.ok(response);
    //     } catch (Exception e) {
    //         return ResponseEntity.internalServerError().body("Error generating text: " + e.getMessage());
    //     }
    // }

    // @PostMapping("/explain")
    // @ResponseBody
    // public ResponseEntity<?> getTopicExplanation(@RequestBody Map<String, String> request) {
    //     try {
    //         String topic = request.get("topic");
    //         String explanation = openAIService.getTopicExplanation(topic);
    //         return ResponseEntity.ok(Map.of("explanation", explanation));
    //     } catch (Exception e) {
    //         return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
    //     }
    // }
} 