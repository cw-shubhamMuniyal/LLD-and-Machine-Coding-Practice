public class ArithmeticExpressionEvaluator {
    public static void main(String[] args) {
        System.out.println("Learning Interpreter design pattern with example!");
        System.out.println("_________________________________________________");

//        (a + b) - (c -d) = (5 + 15) - (25 - 55) = 50

        Context context = new Context();
        context.assign("a", 5.0);
        context.assign("b", 15.0);
        context.assign("c", 25.0);
        context.assign("d", 55.0);

// (a+b)
        Expression addition = new AddExpression(
                new VariableExpression("a"),
                new VariableExpression("b")
        );
// (c-d)
        Expression subtraction = new SubtractExpression(
                new VariableExpression("c"),
                new VariableExpression("d")
        );

//  (a + b) - (c - d)
        Expression expression = new SubtractExpression(
                addition,
                subtraction
        );

        Double result = expression.interpret(context);
        System.out.println(result);
    }
}