package com.rbs.hackaton.dublin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {


    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String ping() {
        return "pong";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/step1", method = RequestMethod.GET)
    public String step1() {
        return "step1";
    }

    @RequestMapping(value = "/step2", method = RequestMethod.GET)
    public String step2() {
        return "step2";
    }

    @RequestMapping(value = "/bankofapis", method = RequestMethod.GET)
    public String bankofapis() {        return "bankofapis";    }

    @RequestMapping(value = "/statements", method = RequestMethod.GET)
    public String statements() {        return "statements";    }

    @RequestMapping(value = "/step3", method = RequestMethod.GET)
    public String step3() {
        return "step3";
    }

    @RequestMapping(value = "/step4", method = RequestMethod.GET)
    public String step4() {
        return "step4";
    }

    @RequestMapping(value = "/step5", method = RequestMethod.GET)
    public String step5() {
        return "step5";
    }


}
