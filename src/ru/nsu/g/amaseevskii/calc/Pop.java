package ru.nsu.g.amaseevskii.calc;

import static ru.nsu.g.amaseevskii.calc.MyLogger.myLogger;

class Pop implements Operation {

    @Override
    public void operation(Context context) throws MyEmptyStackException {
        myLogger.info("Starting Pop.operation\n");
        if (context.numbers.numberStack.empty())
            throw new MyEmptyStackException();
        double temp = context.numbers.numberStack.pop();
        myLogger.info(temp + " successfully pulled out of stack.\n");
    }
}
