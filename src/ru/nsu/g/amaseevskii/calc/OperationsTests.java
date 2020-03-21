package ru.nsu.g.amaseevskii.calc;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.*;

class OperationsTests {

    @Test
    void AddTest() {
        Context context = new Context();
        context.numbers.numberStack.push(5.0);
        context.numbers.numberStack.push(8.0);
        Add testadd = new Add();
        try {
            testadd.operation(context);
        } catch (MyEmptyStackException e) {
            e.printStackTrace();
        }
        assertEquals(5 + 8, context.numbers.numberStack.pop());

    }

    @Test
    void DefineTest() {
        Context context = new Context();
        context.splitline.add("define");
        context.splitline.add("a");
        context.splitline.add("8");
        Define testdefine = new Define();
        try {
            testdefine.operation(context);
        } catch (DefineException e) {
            e.printStackTrace();
        }
        assertEquals(8, context.vars.variables.get("a"));
    }

    @Test
    void DivideTest() {
        Context context = new Context();
        context.numbers.numberStack.push(5.0);
        context.numbers.numberStack.push(8.0);
        Divide testdivide = new Divide();
        try {
            testdivide.operation(context);
        } catch (DivideException | MyEmptyStackException e) {
            e.printStackTrace();
        }
        assertEquals(5 / 8.0, context.numbers.numberStack.pop());
    }

    @Test
    void CommentTest() {
        Context context = new Context();
        context.splitline.add("#");
        context.splitline.add("Just");
        context.splitline.add("some");
        context.splitline.add("random");
        context.splitline.add("text");
        Comment testcomment = new Comment();
        testcomment.operation(context);
        assertEquals(0, context.splitline.size());
        assertTrue(context.numbers.numberStack.empty());
        assertEquals(0, context.vars.variables.size());
        assertEquals(0, context.counter);
    }

    @Test
    void MultiplyTest() {
        Context context = new Context();
        context.numbers.numberStack.push(5.0);
        context.numbers.numberStack.push(8.0);
        Multiply testmultiply = new Multiply();
        try {
            testmultiply.operation(context);
        } catch (MyEmptyStackException e) {
            e.printStackTrace();
        }
        assertEquals(5 * 8, context.numbers.numberStack.pop());
    }

    @Test
    void PopTest() {
        Context context = new Context();
        context.numbers.numberStack.push(5.0);
        context.numbers.numberStack.push(8.0);
        Pop testpop = new Pop();
        try {
            testpop.operation(context);
        } catch (MyEmptyStackException e) {
            e.printStackTrace();
        }
        assertEquals(1, context.numbers.numberStack.size());
    }

    @Test
    void PrintTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalout = System.out;
        System.setOut(new PrintStream(out));
        Context context = new Context();
        context.numbers.numberStack.push(5.0);
        Print testprint = new Print();
        try {
            testprint.operation(context);
        } catch (MyEmptyStackException e) {
            e.printStackTrace();
        }
        assertEquals("5.0\n", out.toString());
        assertEquals(1, context.numbers.numberStack.size());
        assertEquals(5.0, context.numbers.numberStack.pop());
        System.setOut(originalout);
    }

    @Test
    void PushTest() {
        Context context = new Context();
        context.splitline.add("push");
        context.splitline.add("5");
        context.vars.variables.put("a", 15.0);
        context.splitline.add("push");
        context.splitline.add("a");
        Push testpush = new Push();
        try {
            testpush.operation(context);
            context.counter++;              //имитируется увеличение счётчика в фабрике,
                                            //когда несколько команд передаются в одной строке
            testpush.operation(context);
        } catch (PushException e) {
            e.printStackTrace();
        }
        assertEquals(15, context.numbers.numberStack.pop());
        assertEquals(5, context.numbers.numberStack.pop());
    }

    @Test
    void SqrtTest () {
        Context context = new Context();
        context.numbers.numberStack.push(9.0);
        Sqrt testsqrt = new Sqrt();
        try {
            testsqrt.operation(context);
        } catch (SqrtException | MyEmptyStackException e) {
            e.printStackTrace();
        }
        assertEquals(sqrt(9.0), context.numbers.numberStack.pop());
    }

    @Test
    void SubtractTest() {
        Context context = new Context();
        context.numbers.numberStack.push(5.0);
        context.numbers.numberStack.push(8.0);
        Subtract testsubtract = new Subtract();
        try {
            testsubtract.operation(context);
        } catch (MyEmptyStackException e) {
            e.printStackTrace();
        }
        assertEquals(5-8, context.numbers.numberStack.pop());
    }
}