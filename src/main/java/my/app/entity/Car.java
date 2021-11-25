package my.app.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "car_name")
    private  String carName;

    @Column
    private int age;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Insurance> insuranceList;

    public Car(int id, List<Insurance> insuranceList) {
        this.id = id;
        this.insuranceList = insuranceList;
    }

    public List<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public void setInsuranceList(List<Insurance> insuranceList) {
        this.insuranceList = insuranceList;
    }

    public Car() {
    }

    public Car(String carName, int age) {
        this.carName = carName;
        this.age = age;
    }

    public Car(int id, String carName, int age) {
        this.id = id;
        this.carName = carName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
