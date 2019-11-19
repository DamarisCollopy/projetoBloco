package infnet.group.project.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
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
    @Column
    private String email;
    @Column
    private String password;
    @OneToOne
    @JoinColumn
    private Address address;

}
