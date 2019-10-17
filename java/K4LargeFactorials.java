import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class K4LargeFactorials {
    // Each element in the list is a single digit
    // The list represents a number in reversed order
    // ie. 2738 is stored as {8, 3, 7, 2}
    private static List<Integer> Multiply(List<Integer> numList, int mult) {
        int carry = 0;
        List<Integer> result = new ArrayList<Integer>();

        for (int num : numList) {
            int temp = num * mult + carry;
            result.add(temp % 10);
            carry = temp / 10;
        }
        
        while (carry != 0) {
            result.add(carry % 10);
            carry /= 10;
        }

        return result;
    }

    public static String Factorial(int n) {
        List<Integer> result = Arrays.asList(new Integer[] { 1 });
        while (n > 1) {
            result = Multiply(result, n);
            n--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = result.size() - 1; i >= 0; i--) {
            sb.append(result.get(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Factorial(20));
    }
}