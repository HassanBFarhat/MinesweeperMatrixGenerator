import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        final Scanner scanner = new Scanner(System.in);
        int rows;
        int cols;
        do {
            rows = scanner.nextInt();
            cols = scanner.nextInt();
            int percent = scanner.nextInt();
            MatrixGenerator mg = new MatrixGenerator(rows, cols, percent);
            mg.generateTheMineField();
        } while (rows != 0 && cols != 0);
    }
}