package ru.nsu.g.amaseevskii.calc;

import static ru.nsu.g.amaseevskii.calc.MyLogger.myLogger;

class Comment implements Operation {
    @Override
    public void operation(Context context) {
        myLogger.info("Starting Comment.operation\n");
        StringBuilder sb = new StringBuilder();
        for (int i = context.counter; i < context.splitline.size(); i++)
            sb.append(context.splitline.get(i) + " ");
        myLogger.info(sb.toString() + "\n");
        context.splitline.clear();
    }
}
