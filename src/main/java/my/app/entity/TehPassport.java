package my.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "tehpassport")
public class TehPassport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtehpassport")
    private int idtehPassport;

    @Column(name = "serialnumber")
    private String serialNumber;

    @Column(name = "createdate")
    private String createDate;

    //    @Column(name = "fk_carId")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_carId", referencedColumnName = "id")
    private Car car;

    public TehPassport(){

    }

    public int getIdtehPassport() {
        return idtehPassport;
    }

    public void setIdtehPassport(int idtehPassport) {
        this.idtehPassport = idtehPassport;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}




