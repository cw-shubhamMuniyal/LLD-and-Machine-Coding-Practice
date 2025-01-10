public class Espresso extends Beverage {

    Espresso() {
        super.setName(getName());
    }

    @Override
    public Integer getCost() {
        return 10;
    }

    public String getName() {
        return "Espresso";
    }
    
}
