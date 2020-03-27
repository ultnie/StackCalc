package ru.nsu.g.amaseevskii.calc;

class SqrtException extends MyException {
    private double negNum;

    SqrtException(String message, int num, double a) {
        this.message = message;
        this.num = num;
        this.negNum = a;
    }
}