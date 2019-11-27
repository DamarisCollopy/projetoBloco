package infnet.group.project.controller;

import infnet.group.project.interceptor.ClientSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("secure")
public class SecureController {

    @Autowired
    ClientSession clientSession;

    @GetMapping String main(Map<String,Object> model) {
        model.put("client", clientSession.getLoggedUser());
        return "secure/mainPage";
    }
}
