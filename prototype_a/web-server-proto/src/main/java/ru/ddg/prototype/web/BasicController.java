package ru.ddg.prototype.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Natal on 12.04.2016.
 */
@Controller
@RequestMapping(path = "/")
public class BasicController {

    @RequestMapping("/test")
    @ResponseBody
    String home(@RequestParam("test")TestEntity test) {
        return test.toString();
    }
}
