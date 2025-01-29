public class RoomMaintenanceVisitor implements RoomVisitor{

    @Override
    public void visit(SingleRoom room) {
        System.out.println("Adding maintenance logic for single room");
    }

    @Override
    public void visit(DoubleRoom room) {
        System.out.println("Adding maintenance logic for Double room");
    }

    @Override
    public void visit(DeluxeRoom room) {
        System.out.println("Adding maintenance logic for Deluxe room");
    }
}
