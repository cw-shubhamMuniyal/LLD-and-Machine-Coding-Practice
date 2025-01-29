## Definition of Visitor design pattern:

The Visitor Pattern is a behavioral design pattern that lets you add new operations to existing object structures without modifying their classes. 
Instead of adding methods to the objects themselves, you define a separate visitor class that performs operations on the elements.

## When to use Visitor design pattern:

- When you need to perform multiple operations on a complex object structure.
- When you want to avoid modifying existing classes while adding new behavior.
- When an object structure rarely changes, but new operations are frequently added.

## Example from head first design pattern book:

```java
// Visitor Interface
interface Visitor {
double visit(Liquor liquor);
double visit(Tobacco tobacco);
double visit(Necessity necessity);
}

// Element Interface
interface Visitable {
double accept(Visitor visitor);
}

// Concrete Element: Liquor
class Liquor implements Visitable {
private double price;

    public Liquor(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

// Concrete Element: Tobacco
class Tobacco implements Visitable {
private double price;

    public Tobacco(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

// Concrete Element: Necessity
class Necessity implements Visitable {
private double price;

    public Necessity(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

// Concrete Visitor: Tax Calculator
class TaxVisitor implements Visitor {
@Override
public double visit(Liquor liquor) {
return liquor.getPrice() * 1.10; // 10% tax
}

    @Override
    public double visit(Tobacco tobacco) {
        return tobacco.getPrice() * 1.30; // 30% tax
    }

    @Override
    public double visit(Necessity necessity) {
        return necessity.getPrice(); // No tax
    }
}

// VisitorPatternExample Class to Test Visitor Pattern
public class VisitorPatternDemo {
public static void main(String[] args) {
Visitor taxVisitor = new TaxVisitor();

        Visitable liquor = new Liquor(100.0);
        Visitable tobacco = new Tobacco(50.0);
        Visitable milk = new Necessity(20.0);

        System.out.println("Liquor Price with Tax: $" + liquor.accept(taxVisitor));
        System.out.println("Tobacco Price with Tax: $" + tobacco.accept(taxVisitor));
        System.out.println("Necessity Price (No Tax): $" + milk.accept(taxVisitor));
    }
}
```

## Benefits of using Visitor design pattern:

✅ Extensibility – New operations can be added without modifying existing elements. </br>
✅ Separation of Concerns – Business logic (visitor operations) is separated from data (elements). </br>
✅ Simplifies Complex Structures – Works well with hierarchical structures like file systems, ASTs, etc. </br>