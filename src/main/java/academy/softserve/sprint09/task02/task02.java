package academy.softserve.sprint09.task02;

/*
*Suppose, you have class from task #1 ParallelCalculator that is able to
* execute an operation in separate thread. It uses an implementation of Runnable interface for this.

You need to create Accountant class with a static sum(...) method that takes
* two parameters of type int and returns their sum. Use ParallelCalculator for
* this. The sum(...) method doesn't throw any checked exceptions.

The sum must be evaluated in a separate thread  (please, do not call run()
* method of ParallelCalculator. Use start() method on object of type Thread).
Using Thread.sleep() method is unwelcomed in this task.

* class Accountant {
    public static int sum(int x, int y) {

        // Write your code here

    }
}


*
* */



import java.util.function.BinaryOperator;

// write your code here
class ParallelCalculator implements Runnable {
    int result;
    ParallelCalculator(BinaryOperator<Integer> operation, int operand1, int operand2){
        result = operation.apply(operand1, operand2);
    }

    @Override
    public void run() {

    }
}

class Accountant {
    public static int sum(int x, int y) {

        // Write your code here
        ParallelCalculator parallelCalculator =
                new ParallelCalculator(Integer::sum, x, y);
        Thread thread = new Thread(parallelCalculator);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return parallelCalculator.result;
    }
}

public class task02 {
}
