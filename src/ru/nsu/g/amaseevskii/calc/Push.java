package ru.nsu.g.amaseevskii.calc;

import static ru.nsu.g.amaseevskii.calc.IsNumeric.isNumeric;
import static ru.nsu.g.amaseevskii.calc.MyLogger.myLogger;

class Push implements Operation {

    @Override
    public void operation(Context context) throws PushException {
        myLogger.info("Starting Push.operation\n");
        if (context.splitline.size() < context.counter + 2)
            throw new PushException("There's nothing to push", 9);
        if (context.vars.variables.containsKey(context.splitline.get(++context.counter)))
            context.numbers.numberStack.push(context.vars.variables.get(context.splitline.get(context.counter)));
        else {
            if (!isNumeric(context.splitline.get(context.counter)))
                throw new PushException("Push: Argument is not defined and not numeric", 5);
            context.numbers.numberStack.push(Double.parseDouble(context.splitline.get(context.counter)));
        }
        myLogger.info(context.numbers.numberStack.peek() + " successfully pushed to stack\n");
    }
}