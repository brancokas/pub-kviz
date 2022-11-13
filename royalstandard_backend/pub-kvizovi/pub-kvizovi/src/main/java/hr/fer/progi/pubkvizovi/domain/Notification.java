package hr.fer.progi.pubkvizovi.domain;

import javax.persistence.*;

@Entity
@Table(name = "Obavijest")
public class Notification {
    @Id
    @GeneratedValue
    @Column(name = "obavijest_id")
    private Long id;

    @Column(name = "tekst", nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "korisnik_id")
    private User user;


    public Notification() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", user=" + user +
                '}';
    }
}
