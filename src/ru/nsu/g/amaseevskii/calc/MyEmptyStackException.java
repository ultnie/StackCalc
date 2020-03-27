package ru.nsu.g.amaseevskii.calc;

class MyEmptyStackException extends MyException {

    MyEmptyStackException() {
        this.message = "Not enough elements in stack for operation";
        this.num = 1;
    }
}
