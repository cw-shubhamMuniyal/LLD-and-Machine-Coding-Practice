public class MilkAddon extends IngredientDecorator{

    Beverage beverage;

    MilkAddon(Beverage beverage) {
        this.beverage = beverage;
    }
    
    String getName() {
        return beverage.getName() + " Milk ";
    }

    Integer getCost() {
        return beverage.getCost() + 5;
    }
}
