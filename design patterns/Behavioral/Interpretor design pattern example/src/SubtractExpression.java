public class SubtractExpression implements Expression {

    Expression leftExpression;

    public SubtractExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    Expression rightExpression;

    @Override
    public Double interpret(Context context) {
        return leftExpression.interpret(context) - rightExpression.interpret(context);
    }
}
