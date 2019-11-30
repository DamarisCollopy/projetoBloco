package infnet.group.project.controller;

import infnet.group.project.repository.Address;
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
    @Autowired
    Address ad;
    @Autowired
    Client client;

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
                     @RequestParam("phone") String phone,
                     @RequestParam("cpf") String cpf,
                     @RequestParam("email") String email,
                     @RequestParam("password") String password,
                     @RequestParam("street") String street,
                     @RequestParam("number") String number,
                     @RequestParam("complement") String complement,
                     @RequestParam("zip") String zip,
                     @RequestParam("neighborhood") String neighborhood,
                     @RequestParam("city") String city,
                     @RequestParam("country") String country,
                     Map<String,Object> model) {
        password = passwordCript(password);
        if(clientRepository.findByEmail(email)!= null) {
            model.put("client",client);
            model.put(" message", "Email already exists");
            model.put("success",false);
            return;
        }
        if(StringUtils.hasText(name) && StringUtils.hasText(surname) && StringUtils.hasText(phone)
                && StringUtils.hasText(cpf)&& StringUtils.hasText(email)&& StringUtils.hasText(password)&&
                StringUtils.hasText(street) &&  StringUtils.hasText(number)  &&  StringUtils.hasText(zip) &&  StringUtils.hasText(neighborhood) &&  StringUtils.hasText(city) &&
         StringUtils.hasText(country)) {
            Address address = new Address(street,number,complement,zip,neighborhood,city,country);
            Client client = new Client(name,surname,address, phone,cpf,email,password);
            clientRepository.save(client);
            model.put("message", "Your account has been created");
            model.put("success", true);
        } else {
            model.put("message", "Ops! Please, fill all inputs");
            //model.put("success", false);
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
                         @RequestParam("street") String street,
                         @RequestParam("number") String number,
                         @RequestParam("complement") String complement,
                         @RequestParam("zip") String zip,
                         @RequestParam("neighborhood") String neighborhood,
                         @RequestParam("city") String city,
                         @RequestParam("country") String country,
                         @RequestParam("id") Long id) {
        password = passwordCript(password);
        ad.setStreet(street);
        ad.setNumber(number);
        ad.setComplement(complement);
        ad.setZip(zip);
        ad.setNeighborhood(neighborhood);
        ad.setCity(city);
        ad.setCountry(country);
        Client client = clientRepository.findOne(id);
        client.setName(name);
        client.setSurname(surname);
        client.setAddress(ad);
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
