package ru.nsu.g.amaseevskii.calc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

class OpenReader {
    static BufferedReader openReader(String[] args){
        BufferedReader br = null;
        if (args.length!=0){
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        return br;
    }
}
