package infnet.group.project.controller;

import infnet.group.project.repository.Client;
import infnet.group.project.repository.ClientRepository;
import infnet.group.project.security.CryptWithMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@Controller
@RequestMapping ("client")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CryptWithMD5 cryptWithMD5 ;

    @GetMapping(value = "create")
    public String createPage(Map<String, Object> model) {
        model.put("message",null);
        model.put("success",false);
        return "/client/create";
    }
    
    public String passwordCript(String password) {

        String passwordCript;
        passwordCript = cryptWithMD5.cryptWithMD5(password);
        return passwordCript;
    }
    
    @PostMapping(value = "create")
    public void save(@RequestParam("name") String name,
                     @RequestParam("surname") String surname,
                     @RequestParam("address") String address,
                     @RequestParam("phone") String phone,
                     @RequestParam("cpf") String cpf,
                     @RequestParam("email") String email,
                     @RequestParam("password") String password,
                     Map<String,Object> model) {
        password = passwordCript(password);
        if(StringUtils.hasText(name) && StringUtils.hasText(surname) && StringUtils.hasText(address)&& StringUtils.hasText(phone)
                && StringUtils.hasText(cpf)&& StringUtils.hasText(email)&& StringUtils.hasText(password)) {
            Client client = new Client(name,surname,address,phone,cpf,email,password);
            clientRepository.save(client);
            model.put("message", "Your account has been created");
            model.put("success", true);
        } else {
            model.put("message", "Ops! Please, fill all inputs");
            model.put("success", false);
        }
    }

    @GetMapping
    public Iterable<Client> findAll(){
        return clientRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Long id){
        Client record = clientRepository.findOne(id);
       if(record != null)
        return  ResponseEntity.ok().body(record);
       else
           return ResponseEntity.notFound().build();
    }

    @PostMapping(value="/{id}")
    public Client update(@RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("address") String address,
            @RequestParam("phone") String phone,
            @RequestParam("cpf") String cpf,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
                         @RequestParam("id") Long id) {
        Client client = clientRepository.findOne(id);
        client.setName(name);
        client.setSurname(surname);
        client.setAddress(address);
        client.setCpf(cpf);
        client.setEmail(email);
        client.setPassword(password);
        Client saveClient = clientRepository.save(client);
        return  saveClient;
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        clientRepository.delete(id);
        return ResponseEntity.ok().build();
    }
}
