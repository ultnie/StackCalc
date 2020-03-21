package ru.nsu.g.amaseevskii.calc;

import static ru.nsu.g.amaseevskii.calc.MyLogger.myLogger;

class SqrtException extends MyException {
    SqrtException (String message, int num){
        myLogger.severe(message+"\nError code: "+num+"\n");
        this.message=message;
        this.num=num;
    }
}
