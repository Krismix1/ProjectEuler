package Problem27.AnotherSolution;

import java.util.ArrayList;

/**
 * Created by Chris on 08-Feb-17.
 */
public class Problem27 {
    public static void main(String[] args) {
        long start = System.nanoTime();
        int numberOfPrimes = 0;
        int temp;
        ArrayList<Integer> primes = createPrimes();
        for (int a = -999; a < 1000; a++) {
            for (int b = -999; b < 1000; b++) {
                if (primes.contains(b) || primes.contains(b*-1)){
                    if ((temp = findConsPrimes(a, b, primes)) > numberOfPrimes) {
                        numberOfPrimes = temp;
                        System.out.println("x^2+" + a + "x+" + b + " produziert " + numberOfPrimes
                                + " Primzahlen");
                    }
                }
            }
        }
        long time = System.nanoTime() - start;
        System.out.println("Solution found in " + time / 1000000000.0 + " sec");
    }
    public static ArrayList<Integer> createPrimes() {
        int[] numbers = new int[1000];
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 1; i < 1000; i++) { //Feld initialisieren
            numbers[i] = i;
        }
        for (int i = 2; i < 1000; i++) { //aussieben
            if (numbers[i] != 0){
                for (int j = numbers[i]*2; j < 1000; j += numbers[i]){
                    numbers[j] = 0;
                }
            }
        }
        for (int i = 0; i < 1000; i++) {
            if (numbers[i] != 0){
                primes.add(numbers[i]);
            }
        }
        return primes;
    }
    public static int findConsPrimes(int a, int b, ArrayList<Integer> primes){
        int numberOfPrimes = 0;
        for (int x = 1; ;x++) {
            if (!primes.contains((int) Math.pow(x, 2) + a * x + b)){
                return numberOfPrimes;
            }
            numberOfPrimes++;
        }
    }
}
