package infnet.group.project.interceptor;

import infnet.group.project.repository.Client;
import infnet.group.project.repository.ClientRepository;
import infnet.group.project.security.CryptWithMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientSession {

    Client client;

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CryptWithMD5 cryptWithMD5;

    public void addLoggedUser(Client c) {
        this.client = c;
    }

    public Client getLoggedUser() {
        return client;
    }

    public void removeLoggedUser() {
        this.client = null;
    }

    public Client findUserByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

}
