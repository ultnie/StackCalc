package ru.nsu.g.amaseevskii.calc;

import static ru.nsu.g.amaseevskii.calc.MyLogger.myLogger;

class Add implements Operation {
    @Override
    public void operation(Context context) throws MyEmptyStackException {
        myLogger.info("Starting Add.operation\n");
        if (context.numbers.numberStack.empty())
            throw new MyEmptyStackException();
        Double a = context.numbers.numberStack.pop();
        if (context.numbers.numberStack.empty()) {
            context.numbers.numberStack.push(a);
            throw new MyEmptyStackException();
        }
        Double b = context.numbers.numberStack.pop();
        Double sum = b + a;
        myLogger.info(b + " + " + a + " operation completed successfully. " + sum + " pushed to stack.\n");
        context.numbers.numberStack.push(sum);
    }
}