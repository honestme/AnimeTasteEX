package com.honestme.animetasteex;

/**
 * Created by Administrator on 2015/11/29 0029.
 */
public interface BaseState {

    public void registerForEvents(Object receiver);
    public void unRegisterForEvents(Object receiver);
}
