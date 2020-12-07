package WestTwo2020.secondRound;

//果汁或啤酒售完
public class IngredientSortOutException extends RuntimeException {
    public IngredientSortOutException(){}
    public IngredientSortOutException(String msg){
        super(msg);
    }
}
