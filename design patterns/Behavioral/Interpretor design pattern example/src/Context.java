import java.util.HashMap;
import java.util.Map;

public class Context {

    Map<String, Double> variables = new HashMap<>();

    public void assign(String var, Double value) {
        variables.put(var, value);
    }

    public Double getValue(String var) {
        return variables.get(var);
    }
}
