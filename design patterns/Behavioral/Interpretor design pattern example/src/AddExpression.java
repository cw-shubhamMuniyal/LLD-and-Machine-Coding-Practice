public class AddExpression implements Expression {

    Expression leftExpression;
    Expression rightExpression;

    public AddExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public Double interpret(Context context) {
        return leftExpression.interpret(context) + rightExpression.interpret(context);
    }
}
