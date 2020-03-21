package ru.nsu.g.amaseevskii.calc;

import static ru.nsu.g.amaseevskii.calc.MyLogger.myLogger;

class Divide implements Operation {
    @Override
    public void operation(Context context) throws DivideException, MyEmptyStackException {
        myLogger.info("Starting Divide.operation\n");
        if (context.numbers.numberStack.empty())
            throw new MyEmptyStackException();
        Double a = context.numbers.numberStack.pop();
        if (a == 0) {
            context.numbers.numberStack.push(a);
            throw new DivideException("Division by zero", 4);
        }
        if (context.numbers.numberStack.empty()) {
            context.numbers.numberStack.push(a);
            throw new MyEmptyStackException();
        }
        Double b = context.numbers.numberStack.pop();
        Double div = b / a;
        context.numbers.numberStack.push(div);
        myLogger.info(b + "/" + a + " operation is completed successfully. "+div+" pushed to stack.\n");
    }
}