package hr.fer.progi.pubkvizovi.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Uloga")
public class Role {
    @Id
    @Column(name = "uloga_id")
    private Long id;

    @Column(name = "uloga_ime", nullable = false)
    private String name;

//    @JoinTable(
//            name = "korisnik_uloga",
//            joinColumns = @JoinColumn(
//                    name = "uloga_id",
//                    referencedColumnName = "uloga_id"
//            ),
//            inverseJoinColumns =  @JoinColumn(
//                    name = "korisnik_id",
//                    referencedColumnName = "korisnik_id"
//            )
//    )
//    @ManyToMany
//    private Set<User> users;


    public Role() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", users=" + users +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) && Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
