package org.acme.restclient;


import java.io.Serializable;


/**
 * The superclass of all outgoing messages.
 */
public class MyMessage implements Serializable {
    private static final long serialVersionUID = -5958829164103569292L;

    protected String chatId;

    protected Boolean disableNotification;

    protected Long replyToMessageId;

    public MyMessage() {
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public Boolean getDisableNotification() {
        return disableNotification;
    }

    public void setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
    }

    public Long getReplyToMessageId() {
        return replyToMessageId;
    }

    public void setReplyToMessageId(Long replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OutgoingMessage{");
        sb.append("chatId='").append(chatId).append('\'');
        sb.append(", disableNotification=").append(disableNotification);
        sb.append(", replyToMessageId=").append(replyToMessageId);
        sb.append('}');
        return sb.toString();
    }
}
