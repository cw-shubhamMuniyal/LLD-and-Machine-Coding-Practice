public class VariableExpression implements Expression {

    final String variable;

    public VariableExpression(String variable) {
        this.variable = variable;
    }

    @Override
    public Double interpret(Context context) {
        return context.getValue(variable);
    }
}
