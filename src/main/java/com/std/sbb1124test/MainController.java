package com.std.sbb1124test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class MainController {
    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
}
