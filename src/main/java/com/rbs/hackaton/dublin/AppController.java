package com.rbs.hackaton.dublin;

import com.rbs.hackaton.dublin.model.Customer;
import com.rbs.hackaton.dublin.service.BlueBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
    @Autowired
    private BlueBankService service;

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

    @RequestMapping(value = "/step6", method = RequestMethod.GET)
    public String step6(@CookieValue("jwt") String token, ModelMap modelMap) {
        Customer customer = service.getCustomer(token);
        modelMap.addAttribute("customer", customer);
        return "step6";
    }

    @RequestMapping(value = "/final", method = RequestMethod.GET)
    public String finalStep() {
        return "final";
    }


}
