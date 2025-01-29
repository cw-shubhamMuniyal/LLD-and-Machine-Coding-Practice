public class DeluxeRoom implements Room {

    private Double price;

    @Override
    public void accept(RoomVisitor roomVisitor) {
        roomVisitor.visit(this);
    }

    @Override
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
