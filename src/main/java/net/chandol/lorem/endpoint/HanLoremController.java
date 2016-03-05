package net.chandol.lorem.endpoint;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HanLoremController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
