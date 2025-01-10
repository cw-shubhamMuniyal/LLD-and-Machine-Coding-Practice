public class WhippedCream extends IngredientDecorator{

    Beverage beverage;

    WhippedCream(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    String getName() {
       return beverage.getName() + " Whipped Cream ";
    }

    @Override
    Integer getCost() {
        return beverage.getCost() + 10;
    }
    
    
}
