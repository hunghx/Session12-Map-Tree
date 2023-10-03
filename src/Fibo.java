import java.util.Scanner;

public class Fibo {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Size bao nhiêu á fen: ");
        int n = scanner.nextInt();

        long t0 = System.currentTimeMillis();
        long F1 = fibo1(n);
        long t1 = System.currentTimeMillis();
        long F2 = fibo2(n);
        long t2 = System.currentTimeMillis();

        System.out.println("1: " + F1 + " time: " + (t1 - t0));
        System.out.println("2: " + F2 + " time: " + (t2 - t1));
    }

    public static long fibo1(int n) {
        if (n <= 1) return n;
        return fibo1(n - 1) + fibo1(n - 2);
    }

    public static long fibo2(int n) {
        long[] F = new long[n + 1];
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i <= n; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }
        return F[n];
    }


}
