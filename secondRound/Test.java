package WestTwo2020.secondRound;

import java.time.LocalDate;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        West2FriedChickenRestaurant west2FriedChickenRestaurant = new West2FriedChickenRestaurant();

        //给5块，只能进一份芭乐汁
        west2FriedChickenRestaurant.setBalance(5);

        ArrayList<SetMeal> setMeals = new ArrayList();
        ArrayList<Juice> juices = new ArrayList();
        ArrayList<Beer> beers = new ArrayList();

        Juice Bale = new Juice("Bale", 5, LocalDate.now());
        Juice orangeJuice = new Juice("orangeJuice", 5, LocalDate.parse("2020-11-12"));
        Beer Budweiser = new Beer("Budweiser", 8, LocalDate.now(), 3f);
        Beer Corona = new Beer("Corona", 12, LocalDate.parse("2019-01-01"), 3f);

     System.out.println("\033[32;4m"+"------------------------------------------分------------------割-----------------线-------------------------------------------------------"+"\033[0m");
        //测试是否过期的方法(false,true,false,true)
        System.out.println("\033[34;4m"+Bale.isPastDue() + " " + orangeJuice.isPastDue() + " " + Budweiser.isPastDue() + " " + Corona.isPastDue()+"\033[0m");

        juices.add(orangeJuice);
        juices.add(Bale);
        beers.add(Budweiser);
        beers.add(Corona);
        setMeals.add(new SetMeal(12, "oneGeeBar", Bale));
        setMeals.add(new SetMeal(12, "funnyKneeMudPee", orangeJuice));
        setMeals.add(new SetMeal(15, "kneeMarsRe", Budweiser));
        setMeals.add(new SetMeal(18, "geeKneeTiMg", Corona));

        //初始化菜单
        west2FriedChickenRestaurant.setMealList(setMeals);

    System.out.println("\033[32;4m"+"------------------------------------------分------------------割-----------------线-------------------------------------------------------"+"\033[0m");

        System.out.println("菜单如下：");
        for (SetMeal setmeal : west2FriedChickenRestaurant.getsetMealList()) {
            System.out.println(setmeal.getName() + " 价格为：" +"\033[31;4m"+ setmeal.getPrice()+"\033[0m");
        }

    System.out.println("\033[32;4m"+"------------------------------------------分------------------割-----------------线-------------------------------------------------------"+"\033[0m");

        //进货
        west2FriedChickenRestaurant.stock(Bale, 1);
        //检查juiceBox列表是否存在新进的芭乐汁
        System.out.println("\033[39;4m"+west2FriedChickenRestaurant.getJuiceBox()+"\033[0m");
        //出售一份芭乐套餐
        west2FriedChickenRestaurant.sellSetMeal(Bale);
        /*
        检查juiceBox列表是否移除芭乐汁
        列表应为空
         */
        System.out.println("\033[39;4m"+west2FriedChickenRestaurant.getJuiceBox()+"\033[0m");

    System.out.println("\033[32;4m"+"------------------------------------------分------------------割-----------------线-------------------------------------------------------"+"\033[0m");
        /*
        进货余额不足，无法进货，抛出异常
        (防止程序终止，测试时选择取消下一行注释运行)
         */
//        west2FriedChickenRestaurant.stock(Bale,1);


        //加点钱来进货
        west2FriedChickenRestaurant.setBalance(west2FriedChickenRestaurant.getBalance() + 100);

        /*
        juiceBox原来的Bale被使用，juiceBox不存在Bale，抛出异常
        (防止程序终止，测试时选择取消下一行注释运行)
         */
//        west2FriedChickenRestaurant.sellSetMeal(Bale);


        /*
        检查use函数是否移除过期饮料
        由于orangeJuice过期，进的货物在use中被移除，orangeJuice不存在于juiceBox中
        (防止程序终止，测试时选择取消下两行注释运行)
        */
//        west2FriedChickenRestaurant.stock(orangeJuice, 1);
//        west2FriedChickenRestaurant.sellSetMeal(orangeJuice);

        Beer Budweiser2 = new Beer("Budweiser", 8, LocalDate.now().minusDays(3), 3f);
        west2FriedChickenRestaurant.stock(Budweiser,1);
        west2FriedChickenRestaurant.stock(Budweiser2,1);
        System.out.println(west2FriedChickenRestaurant.getBeerBox());

    System.out.println("\033[32;4m"+"------------------------------------------分------------------割-----------------线-------------------------------------------------------"+"\033[0m");

    }
}
