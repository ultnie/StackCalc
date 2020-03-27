package ru.nsu.g.amaseevskii.calc;

import static ru.nsu.g.amaseevskii.calc.MyLogger.myLogger;

class Calc {
    private OperationFactory factory = new OperationFactory();

    void doNextOperation(Context context) {
        for (context.counter = 0; context.counter < context.splitline.size(); context.counter++) {
            try {
                ((Operation) factory.getOperation(context)).operation(context);
            } catch (MyException e) {
                myLogger.severe(e.getClass().getCanonicalName() + "\n" + e.message + "\n" + "Error code: " + e.num + "\n");
            }
        }
    }
}