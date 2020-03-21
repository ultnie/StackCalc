package ru.nsu.g.amaseevskii.calc;

import java.io.BufferedReader;
import java.io.IOException;

import static ru.nsu.g.amaseevskii.calc.OpenReader.openReader;
import static ru.nsu.g.amaseevskii.calc.ReadLine.readLine;

public class Main {
    public static void main(String[] args) {
        MyLogger.setLogger();
        Context context = new Context();
        BufferedReader br = openReader(args);
        OperationFactory factory = new OperationFactory();
        for (; ; ) {
            context.splitline = readLine(br);
            if (context.splitline.size() == 0)
                break;
            factory.getOperation(context);
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
