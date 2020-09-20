package com.jovica.webcalculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculatorController {
    @RequestMapping(path = "/calculator", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String calculate(@RequestParam int i1, @RequestParam int i2, @RequestParam String operator) {
        if (operator.equals("add")) {
            return "The addition of the two numbers is " + (i1 + i2);
        } else if (operator.equals("sub")) {
            return "The subtraction of the two numbers is " + (i1 - i2);
        } else {
            return "no such operator";
        }
    }
}
