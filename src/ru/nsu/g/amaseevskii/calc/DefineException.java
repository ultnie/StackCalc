package ru.nsu.g.amaseevskii.calc;

class DefineException extends MyException {
    DefineException(String message, int num) {
        this.message = message;
        this.num = num;
    }
}
