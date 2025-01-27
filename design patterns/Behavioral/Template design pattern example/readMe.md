## Definition of Command design pattern:

It's a behavioral design pattern that defines the skeleton of an algorithm in a base class, 
allowing subclasses to override specific steps within that algorithm without changing its overall structure.

## Benefits of Command pattern:

- **Code Reusability:** Common steps are implemented in the base class, avoiding duplication. </br>

- **Flexibility:** Subclasses can customize specific steps without changing the overall algorithm.</br>

- **Maintainability:** Changes to the common behavior are localized in the base class.

## Example from head first design pattern book (Making Beverages (Tea and Coffee) ):

```java
// Abstract Class
abstract class Beverage {
    // Template method (defines the algorithm)
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // Common step
    private void boilWater() {
        System.out.println("Boiling water");
    }

    // Common step
    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Abstract steps to be customized by subclasses
    protected abstract void brew();
    protected abstract void addCondiments();
}

// Concrete Subclass: Tea
class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}

// Concrete Subclass: Coffee
class Coffee extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

// Client
public class TemplateMethodExample {
    public static void main(String[] args) {
        System.out.println("Making tea:");
        Beverage tea = new Tea();
        tea.prepareRecipe();

        System.out.println("\nMaking coffee:");
        Beverage coffee = new Coffee();
        coffee.prepareRecipe();
    }
}
