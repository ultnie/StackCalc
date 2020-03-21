package ru.nsu.g.amaseevskii.calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.exit;

class ReadLine {
    static List<String> readLine(BufferedReader br) {
        char[] line = null;
        List<String> splitline = new LinkedList<>();
        StringBuilder temp = new StringBuilder();
        String tempstr;
        try {
            tempstr = br.readLine();
            if (tempstr != null)
                line = tempstr.toCharArray();
            else
                return splitline;
        } catch (IOException e) {
            exit(0);
        }

        for (char i : line) {
            if (i != " ".toCharArray()[0]) {
                if (i == "#".toCharArray()[0]) {
                    if (temp.length() != 0) {
                        splitline.add(temp.toString());
                        temp = new StringBuilder();
                    }
                    temp.append(i);
                    splitline.add(temp.toString());
                    temp = new StringBuilder();
                } else
                    temp.append(i);
            } else {
                splitline.add(temp.toString());
                temp = new StringBuilder();
            }
        }
        if(temp.length()!=0)
            splitline.add(temp.toString());
        return splitline;
    }
}
