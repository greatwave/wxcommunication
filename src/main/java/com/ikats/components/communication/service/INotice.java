package com.ikats.components.communication.service;

/**
 * 消息提醒服务
 * @author lixinhai
 */
public interface INotice {

    /**
     * 向指定账号发送消息
     * @param reception
     * @param title
     * @param message
     */
    void sendNotice(String reception, String title, String message);
}
