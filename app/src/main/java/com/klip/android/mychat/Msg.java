package com.klip.android.mychat;

/**
 * Created by park
 * on 2017/11/22.
 */

public class Msg {

    public static final Integer RECEIVE = 0;
    public static final Integer SEND = 1;

    private String content;
    private Integer type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
