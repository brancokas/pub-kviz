package hr.fer.progi.pubkvizovi.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table (
        name= "Kviz",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"kviz_id", "vrijeme_odrzavanja"})}
)
public class Quiz {
    @Id
    @GeneratedValue
    @Column(name = "kviz_id")
    private Long id;

    @Column(name = "kratki_opis", nullable = false)
    private String description;

    @Column(name = "ime_kafica", nullable = false)
    private String cafeBarName;

    @Column(name = "vrijeme_odrzavanja", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "lokacija", nullable = false)
    private String location;

    @Column(name = "maks_broj_ekipa", nullable = false)
    private Integer capacity;

    @Column(name = "kotizacija", nullable = false)
    private Float entryFee;

    @Column(name = "nagrade", nullable = false)
    private String prizes;

    @Column(name = "vrsta", nullable = false)
    private QuizType type;

    @Column(name = "naziv_kviza", unique = true, nullable = false)
    private String name;

    @Column(name = "aktivan", nullable = false)
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "korisnik_id")
    private User quizMaster;

    @JoinTable(
            name = "sudjeluje_u",
            joinColumns = @JoinColumn(
                    name = "kviz_id",
                    referencedColumnName = "kviz_id"
            ),
            inverseJoinColumns =  @JoinColumn(
                    name = "ekipa_id",
                    referencedColumnName = "ekipa_id"
            )
    )
    @ManyToMany
    private Set<Team> teams;


    public Quiz() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCafeBarName() {
        return cafeBarName;
    }

    public void setCafeBarName(String cafeBarName) {
        this.cafeBarName = cafeBarName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Float getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(Float entryFee) {
        this.entryFee = entryFee;
    }

    public String getPrizes() {
        return prizes;
    }

    public void setPrizes(String prizes) {
        this.prizes = prizes;
    }

    public QuizType getType() {
        return type;
    }

    public void setType(QuizType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User getQuizMaster() {
        return quizMaster;
    }

    public void setQuizMaster(User quizMaster) {
        this.quizMaster = quizMaster;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", cafeBarName='" + cafeBarName + '\'' +
                ", dateTime=" + dateTime +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                ", entryFee=" + entryFee +
                ", prizes='" + prizes + '\'' +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", korisnik=" + quizMaster +
                ", teams=" + teams +
                '}';
    }
}
