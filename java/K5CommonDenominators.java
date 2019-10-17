public class K5CommonDenominators {
    // Find greatest common divisor
    private static long gcd(long a, long b) {
        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

    // Find lowest common multiple of 2 numbers
    private static long lcm(long a, long b) {
        if (a == 0 || b == 0)
            return 0;

        return (a * b) / gcd(a, b);
    }

    // Find lowest common multiple of an array of numbers
    private static long lcmArray(long[] arr) {
        long lowestMulti = 1;
        for (long ele : arr) {
            lowestMulti = lcm(lowestMulti, ele);
        }

        return lowestMulti;
    }

    private static String pairToString(long[] pair) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(pair[0]).append(",").append(pair[1]);
        sb.append(")");
        return sb.toString();
    }

    public static String convertFrac(long[][] lst) {
        long[] denoms = new long[lst.length];
        for (int i = 0; i < lst.length; i++) {
            long[] pair = lst[i];
            long greaterDenom = gcd(pair[0], pair[1]);
            pair[0] /= greaterDenom;
            pair[1] /= greaterDenom;
            denoms[i] = pair[1];
        }

        long lowestMulti = lcmArray(denoms);
        for (long[] pair : lst) {
            pair[0] = lowestMulti / pair[1] * pair[0];
            pair[1] = lowestMulti;
        }

        StringBuilder sb = new StringBuilder();
        for (long[] pair : lst) {
            sb.append(pairToString(pair));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String res = convertFrac(new long[][] { { 69, 130 } });
        System.out.println(res);
    }
}