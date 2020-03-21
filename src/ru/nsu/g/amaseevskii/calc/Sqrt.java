package ru.nsu.g.amaseevskii.calc;

import static java.lang.Math.sqrt;
import static ru.nsu.g.amaseevskii.calc.MyLogger.myLogger;

class Sqrt implements Operation {
    @Override
    public void operation(Context context) throws SqrtException, MyEmptyStackException {
        myLogger.info("Starting Sqrt.operation\n");
        if (context.numbers.numberStack.empty())
            throw new MyEmptyStackException();
        Double a = context.numbers.numberStack.pop();
        if (a < 0) {
            context.numbers.numberStack.push(a);
            throw new SqrtException("Square root of negative number", 6);
        }
        Double root = sqrt(a);
        context.numbers.numberStack.push(root);
        myLogger.info("sqrt("+a+") "+" completed successfully. "+root+" pushed to stack.\n");
    }
}
