package my.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpassport")
    private int idPassport;

    @Column(name = "serialnumber")
    private String serialNumber;

    @Column(name = "activedate")
    private String activeDate;

//    @Column(name = "fk_personId")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_personid", referencedColumnName = "id")
    private Person person;


    public Passport() {
    }


    public int getIdPassport() {
        return idPassport;
    }

    public void setIdPassport(int idPassport) {
        this.idPassport = idPassport;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(String activeDate) {
        this.activeDate = activeDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

