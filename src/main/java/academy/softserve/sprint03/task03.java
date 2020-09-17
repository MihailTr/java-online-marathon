package academy.softserve.sprint03;

/**
 * Suppose we have execute method with next signature:
 * <p>
 * execute method
 * <p>
 * where the Strategy is the next interface :
 * <p>
 * Strategy interface
 * <p>
 * Using anonymous classes concept, call the execute method 4 times with different strategy (override method doOperation from Strategy interface):
 * <p>
 * Add a to b   \\   (a + b)
 * Subtract b from a   \\   (a - b)
 * Multiply a by b   \\   (a * b)
 * Divide a by b   \\   (a / b)
 */

public class task03 {

    public static void execute(int a, int b, Strategy strategy) {
        double result = strategy.doOperation(a, b);
        System.out.println(result);
    }

    public static void addAtoB(int a, int b) {
        // Write your code here
        Strategy strategy = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a + b;
            }
        };
        execute(a, b, strategy);
    }

    public static void subtractBfromA(int a, int b) {
        // Write your code here
        Strategy strategy = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a - b;
            }
        };
        execute(a, b, strategy);
    }

    public static void multiplyAbyB(int a, int b) {
        // Write your code here
        Strategy strategy = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a * b;
            }
        };
        execute(a, b, strategy);
    }

    public static void divideAbyB(int a, int b) {
        // Write your code here
        Strategy strategy = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return (double) a / b;
            }
        };
        execute(a, b, strategy);
    }

    public static void main(String[] args) {
        addAtoB(3, 2);
        subtractBfromA(3, 2);
        multiplyAbyB(3, 2);
        divideAbyB(3, 2);
    }
}

interface Strategy {
    double doOperation(int a, int b);
}