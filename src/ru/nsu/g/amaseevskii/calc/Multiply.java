package ru.nsu.g.amaseevskii.calc;

import static ru.nsu.g.amaseevskii.calc.MyLogger.myLogger;

class Multiply implements Operation {
    @Override
    public void operation(Context context) throws MyEmptyStackException {
        myLogger.info("Starting Multiply.operation\n");
        if (context.numbers.numberStack.empty())
            throw new MyEmptyStackException();
        Double a = context.numbers.numberStack.pop();
        if (context.numbers.numberStack.empty()) {
            context.numbers.numberStack.push(a);
            throw new MyEmptyStackException();
        }
        Double b = context.numbers.numberStack.pop();
        Double mul = b * a;
        context.numbers.numberStack.push(mul);
        myLogger.info(b + "*" + a +" operation completed successfully. "+mul+" pushed to stack.\n");
    }
}
