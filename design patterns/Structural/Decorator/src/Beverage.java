public abstract class Beverage {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    abstract Integer getCost();
}