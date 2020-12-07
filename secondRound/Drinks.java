package WestTwo2020.secondRound;

import java.time.LocalDate;

public abstract class Drinks {
    //成员变量
    protected String name;
    protected double cost;
    protected LocalDate dateInProduced;
    protected int date;

    //构造方法
    public Drinks(String name, double cost, LocalDate dateInProduced, int date) {
        this.name = name;
        this.cost = cost;
        this.dateInProduced = dateInProduced;
        this.date = date;
    }

    public String getName() {
        return name;
    }
    public double getCost(){
        return cost;
    }

    //判断是否过期的方法
    public abstract boolean isPastDue();

    //重写toString
    @Override
    public abstract String toString();
}
