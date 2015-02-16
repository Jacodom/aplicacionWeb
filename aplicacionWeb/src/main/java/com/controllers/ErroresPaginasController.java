package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jacobo on 16/02/2015.
 */

@Controller
public class ErroresPaginasController {

    String path = "/error";

    @RequestMapping(value = "/404")
    public String error404(){
        return path+"/404";
    }

    @RequestMapping(value = "/500")
    public String error500(){
        return path+"/500";
    }

}
