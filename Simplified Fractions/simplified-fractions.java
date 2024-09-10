import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> listOfFractions = new ArrayList<>();
        for (int denominator = 2; denominator <= n; denominator++) {
            for (int numerator = 1; numerator < denominator; numerator++) {
                if (areCoprime(numerator, denominator)) {
                    listOfFractions.add(formatFraction(numerator, denominator));
                }
            }
        }
        return listOfFractions;
    }

    private boolean areCoprime(int a, int b) {
        return gcd(a, b) == 1;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private String formatFraction(int numerator, int denominator) {
        return numerator + "/" + denominator;
    }
}