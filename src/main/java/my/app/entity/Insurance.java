package my.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "insurance")
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    private String insuranceclass;

    @ManyToOne( targetEntity = Car.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id_fk", referencedColumnName = "id")
    private Car car;


    public Insurance() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInsuranceclass() {
        return insuranceclass;
    }

    public void setInsuranceclass(String insuranceclass) {
        this.insuranceclass = insuranceclass;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}

