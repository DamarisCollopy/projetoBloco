package infnet.group.project.controller;

import infnet.group.project.repository.Client;
import infnet.group.project.repository.ClientRepository;
import infnet.group.project.security.CryptWithMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage(Map<String, Object> model) {
        model.put("message",null);
        model.put("success",false);
        return "/client/create";
    }
    
    public String passwordCript() {
        Client client = null;
        CryptWithMD5 cryptWithMD5 = null;
        
        String passwordCript;
        String pass = client.getPassword();
        passwordCript = cryptWithMD5.cryptWithMD5(pass);
        return passwordCript;
    }
    
    @RequestMapping(value = "create", method =  RequestMethod.POST)
    public void save(@RequestParam("name") String name,
                     @RequestParam("surname") String surname,
                     @RequestParam("address") String address,
                     @RequestParam("phone") String phone,
                     @RequestParam("cpf") String cpf,
                     @RequestParam("email") String email,
                     Map<String,Object> model) {
        String password = passwordCript();
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
    public List findAll(){
        return clientRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Integer id){
        return clientRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") Integer id,
                                 @RequestBody Client client) {
        return clientRepository.findById(id)
                .map(record -> {
                    record.setName(client.getName());
                    record.setName(client.getSurname());
                    record.setName(client.getAddress());
                    record.setPhone(client.getPhone());
                    record.setEmail(client.getEmail());
                    Client updated = clientRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return clientRepository.findById(id)
                .map(record -> {
                    clientRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
