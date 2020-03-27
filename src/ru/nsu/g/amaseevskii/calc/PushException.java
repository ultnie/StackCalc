package ru.nsu.g.amaseevskii.calc;

class PushException extends MyException {
    PushException(String message, int num) {
        this.message = message;
        this.num = num;
    }
}
