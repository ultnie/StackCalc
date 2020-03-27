package ru.nsu.g.amaseevskii.calc;

class DivideException extends MyException {
    DivideException(String message, int num) {
        this.message = message;
        this.num = num;
    }
}
