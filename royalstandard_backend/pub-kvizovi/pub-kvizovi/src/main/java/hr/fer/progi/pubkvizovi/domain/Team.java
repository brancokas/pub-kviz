package hr.fer.progi.pubkvizovi.domain;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Ekipa")
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "ekipa_id")
    private Long id;

    @Column(name = "broj_clanova", nullable = false)
    private Integer numOfMembers;

    @Column(name = "naziv_ekipe", unique = true, nullable = false)
    private String name;

//    @OneToMany
//    @JoinColumn(name = "ekipa_id")
//    private Set<User> members;


    public Team() {}

    public Team(String name) {
        Assert.hasText(name, "Team name must have text");
        this.numOfMembers = 1;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumOfMembers() {
        return numOfMembers;
    }

    public void setNumOfMembers(Integer numOfMembers) {
        this.numOfMembers = numOfMembers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<User> getMembers() {
//        return members;
//    }
//
//    public void setMembers(Set<User> members) {
//        this.members = members;
//    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", numOfMembers=" + numOfMembers +
                ", name='" + name + '\'' +
                //", members=" + members +
                '}';
    }
}
