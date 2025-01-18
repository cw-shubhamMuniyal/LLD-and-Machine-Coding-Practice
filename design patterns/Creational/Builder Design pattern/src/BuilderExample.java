public class BuilderExample {
    public static void main(String[] args) {

        System.out.println("Learning Builder design pattern using creation of Car example!");
        System.out.println("______________________________________________________________");

        Director director = new Director() ;
        Car electricCar = director.getCar("electric");
        Car petrolCar = director.getCar("petrol");

        System.out.println(electricCar.toString());
        System.out.println(petrolCar.toString());

    }
}