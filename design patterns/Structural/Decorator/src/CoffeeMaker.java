public class CoffeeMaker {
    public static void main(String[] args) throws Exception {

        System.out.println("Learning Decorator Pattern with Coffee Maker example!");
        System.out.println("_____________________________________________________");

        Beverage coffee = new WhippedCream(
                new WhippedCream(
                        new MilkAddon(
                                new Cappuccino())));

        System.out.println(coffee.getName());
        System.out.println(coffee.getCost());

    }
}
