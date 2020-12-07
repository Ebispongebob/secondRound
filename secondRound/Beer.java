package WestTwo2020.secondRound;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Beer extends Drinks {

    private float alcoholContent;

    //构造方法
    public Beer(String name, double cost, LocalDate dateInProduced, float alcoholContent) {
        //使用super()函数
        super(name, cost, dateInProduced, 30);
        this.alcoholContent = alcoholContent;
    }

    public float getAlcoholContent() {
        return alcoholContent;
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
        return "Beer{" +
                "alcoholContent=" + alcoholContent +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", localDate=" + dateInProduced +
                ", date=" + date +
                '}';
    }
}
