package com.dudream.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by dudream on 2016/12/27.
 */
@Controller
@RequestMapping(path = "/web")
public class WebController {

    @RequestMapping(path = "/index")
    public String index(Map<String, String> model) {

        model.put("message", "Hello FreeMarker.");

        return "index";
    }

}
