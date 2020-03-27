package ru.nsu.g.amaseevskii.calc;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.*;

class OperationsTests {

    @Test
    void addTest() {
        Context context = new Context();
        context.numbers.numberStack.push(5.0);
        context.numbers.numberStack.push(8.0);
        Add testAdd = new Add();
        try {
            testAdd.operation(context);
        } catch (MyEmptyStackException e) {
            e.printStackTrace();
        }
        assertEquals(5 + 8, context.numbers.numberStack.pop());

    }

    @Test
    void defineTest() {
        Context context = new Context();
        context.splitline.add("define");
        context.splitline.add("a");
        context.splitline.add("8");
        Define testDefine = new Define();
        try {
            testDefine.operation(context);
        } catch (DefineException e) {
            e.printStackTrace();
        }
        assertEquals(8, context.vars.variables.get("a"));
    }

    @Test
    void divideTest() {
        Context context = new Context();
        context.numbers.numberStack.push(5.0);
        context.numbers.numberStack.push(8.0);
        Divide testDivide = new Divide();
        try {
            testDivide.operation(context);
        } catch (DivideException | MyEmptyStackException e) {
            e.printStackTrace();
        }
        assertEquals(5 / 8.0, context.numbers.numberStack.pop());
    }

    @Test
    void commentTest() {
        Context context = new Context();
        context.splitline.add("#");
        context.splitline.add("Just");
        context.splitline.add("some");
        context.splitline.add("random");
        context.splitline.add("text");
        Comment testComment = new Comment();
        testComment.operation(context);
        assertEquals(0, context.splitline.size());
        assertTrue(context.numbers.numberStack.empty());
        assertEquals(0, context.vars.variables.size());
        assertEquals(0, context.counter);
    }

    @Test
    void multiplyTest() {
        Context context = new Context();
        context.numbers.numberStack.push(5.0);
        context.numbers.numberStack.push(8.0);
        Multiply testMultiply = new Multiply();
        try {
            testMultiply.operation(context);
        } catch (MyEmptyStackException e) {
            e.printStackTrace();
        }
        assertEquals(5 * 8, context.numbers.numberStack.pop());
    }

    @Test
    void popTest() {
        Context context = new Context();
        context.numbers.numberStack.push(5.0);
        context.numbers.numberStack.push(8.0);
        Pop testPop = new Pop();
        try {
            testPop.operation(context);
        } catch (MyEmptyStackException e) {
            e.printStackTrace();
        }
        assertEquals(1, context.numbers.numberStack.size());
    }

    @Test
    void printTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalout = System.out;
        System.setOut(new PrintStream(out));
        Context context = new Context();
        context.numbers.numberStack.push(5.0);
        Print testPrint = new Print();
        try {
            testPrint.operation(context);
        } catch (MyEmptyStackException e) {
            e.printStackTrace();
        }
        assertEquals("5.0\n", out.toString());
        assertEquals(1, context.numbers.numberStack.size());
        assertEquals(5.0, context.numbers.numberStack.pop());
        System.setOut(originalout);
    }

    @Test
    void pushTest() {
        Context context = new Context();
        context.splitline.add("push");
        context.splitline.add("5");
        context.vars.variables.put("a", 15.0);
        context.splitline.add("push");
        context.splitline.add("a");
        Push testPush = new Push();
        try {
            testPush.operation(context);
            context.counter++;              //имитируется увеличение счётчика в фабрике,
            //когда несколько команд передаются в одной строке
            testPush.operation(context);
        } catch (PushException e) {
            e.printStackTrace();
        }
        assertEquals(15, context.numbers.numberStack.pop());
        assertEquals(5, context.numbers.numberStack.pop());
    }

    @Test
    void sqrtTest() {
        Context context = new Context();
        context.numbers.numberStack.push(9.0);
        Sqrt testSqrt = new Sqrt();
        try {
            testSqrt.operation(context);
        } catch (SqrtException | MyEmptyStackException e) {
            e.printStackTrace();
        }
        assertEquals(sqrt(9.0), context.numbers.numberStack.pop());
    }

    @Test
    void subtractTest() {
        Context context = new Context();
        context.numbers.numberStack.push(5.0);
        context.numbers.numberStack.push(8.0);
        Subtract testSubtract = new Subtract();
        try {
            testSubtract.operation(context);
        } catch (MyEmptyStackException e) {
            e.printStackTrace();
        }
        assertEquals(5 - 8, context.numbers.numberStack.pop());
    }
}