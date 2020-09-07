package com.atguigu.atguigu_code.eventbus.event;

// 1创建一个粘性事件类
public class StickyEvent {
    public String msg;

    public StickyEvent(String msg) {
        this.msg = msg;
    }
}
