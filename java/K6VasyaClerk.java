public class K6VasyaClerk {
    public static String Tickets(int[] peopleInLine) {
        int num25 = 0;
        int num50 = 0;
        int total = 0;

        for (int payment : peopleInLine) {
            if (payment == 25) {
                num25++;
            } else if (payment == 50) {
                if (num25 < 1) return "NO";
                num25--;
                num50++;
            } else if (payment == 100) {
                if (total < 75) return "NO";
                if (num25 < 1) return "NO";
                if (num50 > 0) {
                    num50--;
                    num25--;
                } else if (num25 > 2) {
                    num25 -= 3;
                } else {
                    return "NO";
                }
            } else {
                return "NO";
            }

            total += 25;
        }

        return "YES";
    }
}