package infnet.group.project.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Component
@Table (name = "client")
public class Client {

    public Client(String name, String surname, Address address, String phone, String cpf, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String phone;
    @Column
    private String cpf;
    @Column(nullable = false, unique = true)
    private String email;
    @Column
    private String password;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_address")
    private Address address;

}
