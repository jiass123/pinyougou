package com.asiainfo.singlethreadloacl;

public class ThreadLoaclInstance {

    private static final ThreadLocal<ThreadLoaclInstance> t = new ThreadLocal<ThreadLoaclInstance>(){
        @Override
        protected ThreadLoaclInstance initialValue() {
            return new ThreadLoaclInstance();
        }
    };

    public static ThreadLoaclInstance getInstance(){
        return t.get();
    }

}
