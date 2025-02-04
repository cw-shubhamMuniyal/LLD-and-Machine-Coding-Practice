import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CountryCollectionIterator {
    public static void main(String[] args) {
        System.out.println("Learning Iterator design pattern with example!");
        System.out.println("_________________________________________________");

        List<State> states = Arrays.asList(
                new State("Maharashtra"),
                new State("Karnataka")
        );

        Country country = new StateAggregator(states);
        Iterator<State> iterator = country.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}