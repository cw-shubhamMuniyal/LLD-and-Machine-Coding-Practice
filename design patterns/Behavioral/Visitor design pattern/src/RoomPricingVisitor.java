public class RoomPricingVisitor implements RoomVisitor{

    @Override
    public void visit(SingleRoom room) {
        room.setPrice(100.0);
        System.out.println("Adding pricing logic for single room");
    }

    @Override
    public void visit(DoubleRoom room) {
        room.setPrice(200.0);
        System.out.println("Adding pricing logic for Double room");
    }

    @Override
    public void visit(DeluxeRoom room) {
        room.setPrice(300.0);
        System.out.println("Adding pricing logic for Deluxe room");
    }
}
