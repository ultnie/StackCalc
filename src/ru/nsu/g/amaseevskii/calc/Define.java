package ru.nsu.g.amaseevskii.calc;

import static ru.nsu.g.amaseevskii.calc.IsNumeric.isNumeric;
import static ru.nsu.g.amaseevskii.calc.MyLogger.myLogger;

class Define implements Operation {
    @Override
    public void operation(Context context) throws DefineException {
        myLogger.info("Starting Define.operation\n");
        if (context.splitline.size() < context.counter+3){
            throw new DefineException("Not enough arguments for define operation", 8);
        }
        if (isNumeric(context.splitline.get(++context.counter))) {
            context.counter++;
            throw new DefineException("Can you not try to redefine numbers in a calculator? Would appreciate it.", 2);
        }
        if (!isNumeric(context.splitline.get(context.counter + 1))) {
            context.counter++;
            throw new DefineException("Second argument in define supposed to be a number", 3);
        } else
            context.vars.variables.put(context.splitline.get(context.counter), Double.parseDouble(context.splitline.get(++context.counter)));
        myLogger.info(context.splitline.get(context.counter - 1) + " is now defined as " + context.splitline.get(context.counter) + "\n");
    }
}
