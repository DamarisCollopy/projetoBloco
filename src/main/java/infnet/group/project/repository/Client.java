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
    @NotEmpty(message = "*Please provide your name")
    private String name;
    @Column
    @NotEmpty(message = "*Please provide your last name")
    private String surname;
    @Column
    private String phone;
    @Column
    private String cpf;
    @Column
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;
    @Column
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private Address address;

}
