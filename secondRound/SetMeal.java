package WestTwo2020.secondRound;

public class SetMeal {
    private String name;
    private double price;
    private String chickenName;
    private Drinks drinks;
    private static int juiceCounter = 1;
    private static int beerCounter = 1;

    //套餐的构造方法

    public SetMeal() {
        this.name = "";
        this.price = 0;
        this.chickenName = "";
    }

    public SetMeal(double price, String chickenName, Drinks drinks) {
        this.price = price;
        this.chickenName = chickenName;
        //多态
        if (drinks instanceof Juice) {
            Juice juice = (Juice) drinks;
            this.drinks = juice;
            this.name = "setMealJuice" + juiceCounter;
            juiceCounter++;
        } else {
            Beer beer = (Beer) drinks;
            this.drinks = beer;
            this.name = "setMealBeer" + beerCounter;
            beerCounter++;
        }


    }

    public String getName() {
        return name;
    }

    public Drinks getDrinks() {
        return drinks;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  "SetMealName = " + name + ' ' +
                "price = " + price + ' ' +
                "chickenName = " + chickenName + ' ' +
                "drinks = " + drinks;
    }
}
