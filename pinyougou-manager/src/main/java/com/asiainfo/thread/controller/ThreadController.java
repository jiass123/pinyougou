package com.asiainfo.thread.controller;

import com.asiainfo.thread.api.IThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thread")
public class ThreadController {

    @Autowired
    private IThreadService threadService;

    @RequestMapping("/test1")
    public void test(){
        threadService.test();
    }
}
