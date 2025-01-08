public class Cappuccino extends Beverage {

    Cappuccino() {
        super.setName(getName());
    }

    @Override
    public Integer getCost() {
        return 20;
    }

    public String getName() {
        return "Cappuccino";
    }
    
}
