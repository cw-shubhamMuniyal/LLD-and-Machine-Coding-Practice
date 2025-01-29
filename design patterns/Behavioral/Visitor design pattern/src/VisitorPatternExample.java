public class VisitorPatternExample {
    public static void main(String[] args) {

        System.out.println("Learning Visitor design pattern with example!");
        System.out.println("_____________________________________________");

        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room deluxeRoom = new DeluxeRoom();

        RoomVisitor roomPricingVisitor = new RoomPricingVisitor();
        RoomVisitor roomMaintenanceVisitor = new RoomMaintenanceVisitor();

        singleRoom.accept(roomPricingVisitor);
        System.out.println("price for single room " + singleRoom.getPrice());
        singleRoom.accept(roomMaintenanceVisitor);

        System.out.println();

        doubleRoom.accept(roomPricingVisitor);
        System.out.println("price for double room " + doubleRoom.getPrice());
        doubleRoom.accept(roomMaintenanceVisitor);

        System.out.println();

        deluxeRoom.accept(roomPricingVisitor);
        System.out.println("price for deluxe room " + deluxeRoom.getPrice());
        deluxeRoom.accept(roomMaintenanceVisitor);

        System.out.println();

    }
}