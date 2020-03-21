package ru.nsu.g.amaseevskii.calc;

import static ru.nsu.g.amaseevskii.calc.MyLogger.myLogger;

class Print implements Operation {
    @Override
    public void operation(Context context) throws MyEmptyStackException {
        myLogger.info("Starting Print.operation\n");
        if (context.numbers.numberStack.empty())
            throw new MyEmptyStackException();
        Double a = context.numbers.numberStack.peek();
        System.out.println(a);
        myLogger.info(a+ " printed to console\n");
    }
}
