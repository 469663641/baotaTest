package com.example.kafka.basic;

/**
 * Created by baota on 2018/2/7.
 */
public class Basic {
    private String messageId;
    private String messageContent;

    public Basic(String messageId, String messageContent){
        this.messageId = messageId;
        this.messageContent = messageContent;
    }

    public String toString(){
        return String.format("%s:%s", messageId, messageContent);
    }
}
