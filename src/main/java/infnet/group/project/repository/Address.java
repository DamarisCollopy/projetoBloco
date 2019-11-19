package infnet.group.project.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Immutable
@Table(name = "address")
public class Address {

    public Address(String street, String number, String complement, String zip, String neighborhood, String city, String country) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.zip = zip;
        this.neighborhood = neighborhood;
        this.city = city;
        this.country = country;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "cadastro")
    private Long id;

    @Column
    private String street;
    @Column
    private String number;
    @Column
    private String complement;
    @Column
    private String zip;
    @Column
    private String neighborhood;
    @Column
    private String city;
    @Column
    private String country;



}
