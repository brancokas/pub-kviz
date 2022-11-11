package hr.fer.progi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Korisnik {

    @Id
    @GeneratedValue
    private Long id;

    public Korisnik() {}

    public Long getId() {
        return id;
    }


    Korisnik(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private String firstName;

    private String lastName;

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
