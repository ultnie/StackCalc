package ru.nsu.g.amaseevskii.calc;

class IsNumeric {
    static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
