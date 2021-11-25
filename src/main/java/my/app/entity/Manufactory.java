package my.app.entity;

public class Manufactory {
    private int id;
    private  String name;
    private int profit;

    public Manufactory() {
    }

    public Manufactory(String name, int profit) {
        this.name = name;
        this.profit = profit;
    }

    public Manufactory(int id, String name, int profit) {
        this.id = id;
        this.name = name;
        this.profit = profit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }
}
