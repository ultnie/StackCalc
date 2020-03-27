package ru.nsu.g.amaseevskii.calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import static ru.nsu.g.amaseevskii.calc.MyLogger.myLogger;

class OperationFactory {
    private HashMap<String, String> confmap = confmap();

    private HashMap<String, String> confmap() {
        InputStream conf = OperationFactory.class.getResourceAsStream("conf");
        BufferedReader br = new BufferedReader(new InputStreamReader(conf));
        String line = null;
        HashMap<String, String> confmap = new HashMap<>();
        try {
            while ((line = br.readLine()) != null) {
                String[] splitop = line.split(" ");
                confmap.put(splitop[0], splitop[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        myLogger.info("Config file read\n");
        return confmap;
    }

    Object getOperation(Context context) throws MyException {
        Object operation = null;
        try {
            operation = Class.forName(confmap.get(context.splitline.get(context.counter).toLowerCase())).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | NullPointerException e) {
            throw new NoSuchOpeartionException("There's no " + context.splitline.get(context.counter) + " operation", 7);
        }
        return operation;
    }
}