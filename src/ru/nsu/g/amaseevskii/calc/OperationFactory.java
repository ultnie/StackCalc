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

    void getOperation(Context context) {

        for (context.counter = 0; context.counter < context.splitline.size(); context.counter++)
            if (confmap.containsKey(context.splitline.get(context.counter).toLowerCase())) {
                try {
                    ((Operation) Class.forName(confmap.get(context.splitline.get(context.counter).toLowerCase())).newInstance()).operation(context);
                } catch (MyException e) {
                    System.out.println(e.message);
                    System.out.println("Error code: " + e.num);
                } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else myLogger.severe("There's no "+ context.splitline.get(context.counter).toLowerCase() +" operation\n");
        context.splitline.clear();
    }
}