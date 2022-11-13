package hr.fer.progi.pubkvizovi.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Korisnik")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "korisnik_id")
    private Long id;

    @Column(name = "ime", nullable = false)
    private String firstName;

    @Column(name = "prezime", nullable = false)
    private String lastName;

    @Column(name = "email_adresa", nullable = false)
    private String email;

    @Column(name = "lozinka", nullable = false)
    private String password;

    @Column(name = "slika")
    private String image;

    @Column(name = "broj_telefona")
    private String phoneNumber;

    @Column(name = "podrucja_znanja")
    private String knowledgeAreas;

    @Column(name = "nadimak", unique = true, nullable = false)
    private String nickname;

    @Column(name = "blokiran", nullable = false)
    private boolean blocked;

    @ManyToOne
    @JoinColumn(name = "ekipa_id")
    private Team myTeam;

    @JoinTable(
        name = "korisnik_uloga",
        joinColumns = @JoinColumn(
                name = "korisnik_id",
                referencedColumnName = "korisnik_id"
        ),
        inverseJoinColumns =  @JoinColumn(
                name = "uloga_id",
                referencedColumnName = "uloga_id"
        )
    )
    @ManyToMany
    private Set<Role> roles;

//    @OneToMany
//    @JoinColumn(name = "korisnik_id")
//    private Set<Notification> notifications;

    public User() {}

    public User(String firstName, String lastName, String email, String image, String phoneNumber, String nickname) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.nickname = nickname;
        this.blocked = false;
        this.roles = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getKnowledgeAreas() {
        return knowledgeAreas;
    }

    public void setKnowledgeArea(String knowledgeAreas) {
        this.knowledgeAreas = knowledgeAreas;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public Team getMyTeam() {
        return myTeam;
    }

    public void setMyTeam(Team myTeam) {
        this.myTeam = myTeam;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    //    public Set<Notification> getNotifications() {
//        return notifications;
//    }
//
//    public void setNotifications(Set<Notification> notifications) {
//        this.notifications = notifications;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", knowledgeAreas='" + knowledgeAreas + '\'' +
                ", nickname='" + nickname + '\'' +
                ", blocked=" + blocked +
                ", myTeam=" + myTeam +
                //", notifications=" + notifications +
                '}';
    }
}
