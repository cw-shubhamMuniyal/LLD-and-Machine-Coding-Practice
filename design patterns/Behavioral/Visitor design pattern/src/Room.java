public interface Room {

    void accept(RoomVisitor roomVisitor);
    void setPrice(Double price);
    Double getPrice();
}
