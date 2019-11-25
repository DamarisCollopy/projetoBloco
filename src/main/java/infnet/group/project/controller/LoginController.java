package infnet.group.project.controller;

import infnet.group.project.interceptor.ClientSession;
import infnet.group.project.repository.Client;
import infnet.group.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ClientSession clientSession;

    @GetMapping (value = "doLogin")
    public String loginPage() {
        return "login/doLogin";
    }

    @PostMapping(value = "doLogin")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password,
                        Map<String, Object> model) {
        Client client = clientRepository.findByEmailAndPassword(email,password);
        if (client != null && client.getPassword().equals(password) && client.getEmail().equals((email))) {
            clientSession.addLoggedUser(client);
            return "redirect:/secure";
        } else {
            model.put("message", "Login not valid");
            return null;
        }
    }
}

