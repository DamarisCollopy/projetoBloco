package infnet.group.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {
    Client findByEmailAndPassword(String email, String password);
    Client findByEmail(String email);
}
