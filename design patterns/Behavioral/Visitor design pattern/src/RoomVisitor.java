public interface RoomVisitor {

    void visit(SingleRoom room);
    void visit(DoubleRoom room);
    void visit(DeluxeRoom room);

}
