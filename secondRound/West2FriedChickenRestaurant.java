package WestTwo2020.secondRound;

import java.util.ArrayList;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant {
    private double balance;
    private ArrayList<Beer> beerBox;
    private ArrayList<Juice> juiceBox;
    private static ArrayList<SetMeal> setMealList;

    public West2FriedChickenRestaurant() {
        this.balance = 0;
        this.beerBox = new ArrayList<>();
        this.juiceBox = new ArrayList<>();

    }

    public ArrayList<Beer> getBeerBox() {
        return beerBox;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Juice> getJuiceBox() {
        return juiceBox;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void setMealList(ArrayList<SetMeal> setMealList) {
        West2FriedChickenRestaurant.setMealList = setMealList;
    }

    public static ArrayList<SetMeal> getsetMealList() {
        return setMealList;
    }

    private void use(Juice juice) {
        String name = juice.getName();
        boolean isFind = false;
        for (int i = 0; i < juiceBox.size(); i++) {
            Juice juice1 = juiceBox.get(i);
            if (juice1.isPastDue() == true) {
                juiceBox.remove(juice1);
                continue;
            }
            if (juice1.getName().equalsIgnoreCase(name) && !isFind) {
                juiceBox.remove(juice1);//移除对应果汁
                isFind = true;
                break;
            }
        }
        if (!isFind) throw new IngredientSortOutException("顾客们，" + juice.getName() + "售空了");

    }


    private void use(Beer beer) {
        String name = beer.getName();
        boolean isFind = false;
        for (int i = 0; i < beerBox.size(); i++) {
            Beer beer1 = beerBox.get(i);
            if (beer1.isPastDue() == true) {
                beerBox.remove(beer1);
                continue;
            }
            if (beer1.getName().equalsIgnoreCase(name) && !isFind) {
                beerBox.remove(beer1);//移除对应啤酒
                isFind = true;
                break;
            }
        }
        if (!isFind) throw new IngredientSortOutException("顾客们，" + beer.getName() + "售空了");
    }

    @Override
    public void sellSetMeal(Drinks drinks) {
        if (drinks instanceof Juice) {
            Juice juice = (Juice) drinks;
            use(juice);
        } else {
            Beer beer = (Beer) drinks;
            use(beer);
        }
        System.out.println("顾客，您的套餐整好了");
    }

    @Override
    public void stock(Drinks drinks, int numberOfStock) {
        if (drinks instanceof Juice) {//果汁进货
            //判断余额是否足够进货果汁
            if (this.balance < drinks.getCost()) {
                throw new OverdraftBalanceException("老板，余额不足以买这种果汁了,还差 " + (drinks.getCost() - this.balance) + " 元");
            } else {
                int i = 0;
                while (i < numberOfStock) {
                    juiceBox.add(new Juice(drinks.getName(), drinks.getCost(), drinks.dateInProduced));
                    this.setBalance(this.balance - drinks.cost);
                    i++;
                }
            }
        } else {//啤酒进货
            //判断余额是否足够进货啤酒
            if (this.balance < drinks.getCost()) {
                throw new OverdraftBalanceException("老板，余额不足以买啤酒了,还差 " + (drinks.getCost() - this.balance) + " 元");
            } else {
                Beer beer = (Beer) drinks;
                int i = 0;
                while (i < numberOfStock) {
                    beerBox.add(new Beer(drinks.getName(), drinks.getCost(), drinks.dateInProduced, beer.getAlcoholContent()));
                    this.setBalance(this.balance - drinks.cost);
                    i++;
                }
            }
        }
    }
}