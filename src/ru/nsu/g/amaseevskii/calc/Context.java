package ru.nsu.g.amaseevskii.calc;

import java.util.LinkedList;
import java.util.List;

class Context {
    List<String> splitline = new LinkedList<>();
    NumberStack numbers = new NumberStack();
    DefinedVariables vars= new DefinedVariables();
    int counter = 0;
}
