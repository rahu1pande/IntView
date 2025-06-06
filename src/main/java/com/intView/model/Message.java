package com.intView.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private InterviewSession session;

    private String sender;
    private String content;
    private LocalDateTime timestamp;
    private boolean isUser;

    public Message(String content, boolean isUser) {
        this.content = content;
        this.isUser = isUser;
        this.timestamp = LocalDateTime.now();
        this.sender = isUser ? "User" : "AI";
    }

    public String getContent() {
        return content;
    }

    public boolean getIsUser() {
        return isUser;
    }
}
