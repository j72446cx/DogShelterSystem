package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long messageId;

    private String title;
    private String type;
    private String body;
    private Long senderId;
    private Long receiverId;
    private LocalDateTime date;
    private Integer status;

    public Message(){

    }

    public Message(long messageId, String title, String type, String body, Long senderId, Long receiverId, LocalDateTime date, Integer status) {
        this.messageId = messageId;
        this.title = title;
        this.type = type;
        this.body = body;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.date = date;
        this.status = status;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

