package infnet.group.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {
 //   List<Client>findByTitleContainingOrContentContaining(String text, String textAgain);
}
