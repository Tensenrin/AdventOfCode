package exercises;

public class QuadraticSolutions {
    public static void main(String[] args) {
        System.out.println(quadraticSolver(1, 0, -1));
    }

    static int quadraticSolver(int a, int b, int c) {
        double formula = (Math.sqrt(b) - (4 * (a * c)));
        if (formula > 0) {
            return 2;
        } else if (formula == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}