package ru.nsu.g.amaseevskii.calc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionsTests {
    @Test
    void emptyStackException() {
        Context context = new Context();
        Pop popEmptyStackExceptionTest = new Pop();
        Add addEmptyStackExceptionTest = new Add();
        Divide divideEmptyStackExceptionTest = new Divide();
        Multiply multiplyEmptyStackExceptionTest = new Multiply();
        Sqrt sqrtEmptyStackExceptionTest = new Sqrt();
        Subtract subtractEmptyStackExceptionTest = new Subtract();
        Print printEmptyStackExceptionTest = new Print();
        assertThrows(MyEmptyStackException.class, () -> popEmptyStackExceptionTest.operation(context));
        assertThrows(MyEmptyStackException.class, () -> addEmptyStackExceptionTest.operation(context));
        assertThrows(MyEmptyStackException.class, () -> divideEmptyStackExceptionTest.operation(context));
        assertThrows(MyEmptyStackException.class, () -> multiplyEmptyStackExceptionTest.operation(context));
        assertThrows(MyEmptyStackException.class, () -> sqrtEmptyStackExceptionTest.operation(context));
        assertThrows(MyEmptyStackException.class, () -> subtractEmptyStackExceptionTest.operation(context));
        assertThrows(MyEmptyStackException.class, () -> printEmptyStackExceptionTest.operation(context));
        context.numbers.numberStack.add(26.0);
        assertThrows(MyEmptyStackException.class, () -> addEmptyStackExceptionTest.operation(context));
        assertThrows(MyEmptyStackException.class, () -> divideEmptyStackExceptionTest.operation(context));
        assertThrows(MyEmptyStackException.class, () -> multiplyEmptyStackExceptionTest.operation(context));
        assertThrows(MyEmptyStackException.class, () -> subtractEmptyStackExceptionTest.operation(context));
    }

    @Test
    void defineException() {
        Context context = new Context();
        Define defineExceptionTest = new Define();
        context.splitline.add("define");
        context.splitline.add("5");
        context.splitline.add("17");
        assertThrows(DefineException.class, () -> defineExceptionTest.operation(context));

        context.splitline.clear();
        context.splitline.add("define");
        context.splitline.add("A");
        context.splitline.add("B");
        context.counter = 0;
        assertThrows(DefineException.class, () -> defineExceptionTest.operation(context));

        context.splitline.clear();
        context.splitline.add("define");
        context.counter = 0;
        assertThrows(DefineException.class, () -> defineExceptionTest.operation(context));

        context.splitline.clear();
        context.splitline.add("define");
        context.splitline.add("One argument");
        context.counter = 0;
        assertThrows(DefineException.class, () -> defineExceptionTest.operation(context));
    }

    @Test
    void divideException() {
        Context context = new Context();
        context.numbers.numberStack.add(34.63);
        context.numbers.numberStack.add(0.0);
        Divide divideExceptionTest = new Divide();
        assertThrows(DivideException.class, () -> divideExceptionTest.operation(context));
    }

    @Test
    void noSuchOperationException() {
        OperationFactory factory = new OperationFactory();
        Context context = new Context();
        context.splitline.add("some random junk");
        assertThrows(NoSuchOpeartionException.class, () -> factory.getOperation(context));
    }

    @Test
    void pushException() {
        Push pushExceptionTest = new Push();
        Context context = new Context();
        context.splitline.add("push");
        assertThrows(PushException.class, () -> pushExceptionTest.operation(context));
        context.counter = 0;
        context.splitline.add("some random junk");
        assertThrows(PushException.class, () -> pushExceptionTest.operation(context));
    }

    @Test
    void sqrtExceptionTest() {
        Sqrt sqrtExceptionTest = new Sqrt();
        Context context = new Context();
        context.numbers.numberStack.add(-5.0);
        assertThrows(SqrtException.class, () -> sqrtExceptionTest.operation(context));
    }
}