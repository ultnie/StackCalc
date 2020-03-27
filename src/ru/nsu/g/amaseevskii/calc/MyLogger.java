package ru.nsu.g.amaseevskii.calc;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


class MyLogger {
    static Logger myLogger = Logger.getLogger(MyLogger.class.getName());
    static FileHandler fh;

    static void setLogger() {
        try {
            fh = new FileHandler("CalcLog.txt");
            myLogger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}