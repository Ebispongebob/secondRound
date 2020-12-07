package WestTwo2020.secondRound;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Juice extends Drinks {
    public Juice(String name, double cost, LocalDate dateInProduced) {
        //使用super()函数
        super(name, cost, dateInProduced, 2);
    }

    //重写Drinks类的判断是否过期的方法
    @Override
    public boolean isPastDue() {
        LocalDate localDate = LocalDate.now();
        int datePastDue = (int) this.dateInProduced.until(localDate, ChronoUnit.DAYS);
        if (datePastDue > this.date) return true;
        return false;
    }

    @Override
    public String toString() {
        return "Juice{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", localDate=" + dateInProduced +
                ", date=" + date +
                '}';
    }

}
