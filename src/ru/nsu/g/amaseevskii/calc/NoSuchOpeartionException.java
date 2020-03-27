package ru.nsu.g.amaseevskii.calc;

class NoSuchOpeartionException extends MyException {
    NoSuchOpeartionException(String message, int num) {
        this.message = message;
        this.num = num;
    }
}
