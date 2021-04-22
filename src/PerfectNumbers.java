import java.util.stream.IntStream;

public class PerfectNumbers {

    public static void main (String[] args){
        PerfectNumbers perfectNumbers = new PerfectNumbers();

        int current = (int) System.currentTimeMillis();
        perfectNumbers.checkPerfectNumbers(0, 1000000);

        int elapsed = ((int) System.currentTimeMillis()) - current;
        System.out.println(elapsed + " seconds have passed.");
    }

    private int sumDivisors(int numberToTest){
        return IntStream.range(1, numberToTest) //exclusive
                .filter(num -> numberToTest % num == 0)
                .sum();
    }

    private void checkPerfectNumbers(int min, int max){
        IntStream.rangeClosed(min, max + 1) //inclusivo
                .filter(num -> num == sumDivisors(num))
                .forEach(System.out::println);
    }
}