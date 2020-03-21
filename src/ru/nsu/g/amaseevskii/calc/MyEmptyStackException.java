package ru.nsu.g.amaseevskii.calc;

import static ru.nsu.g.amaseevskii.calc.MyLogger.myLogger;

class MyEmptyStackException extends MyException{

    MyEmptyStackException(){
        myLogger.severe(message+"\n"+"Error code: "+num+"\n");
        this.message="Not enough elements in stack for operation";
        this.num=1;
    }
}
