package infnet.group.project.interceptor;


import infnet.group.project.repository.Client;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value = "session", proxyMode= ScopedProxyMode.TARGET_CLASS)
@Component
public class ClientSession {

    Client client;

    public void addLoggedUser(Client c) {
        this.client = c;
    }

    public Client getLoggedUser() {
        return client;
    }

    public void removeLoggedUser() {
        this.client = null;
    }
}
