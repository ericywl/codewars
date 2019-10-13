public class K6MexicanWave {
    public static String[] wave(String str) {
        String newStr = str.replace(" ", "");
        String[] results = new String[newStr.length()];
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                results[j] = str.substring(0, i) + str.substring(i, i + 1).toUpperCase() + str.substring(i + 1);
                j++;
            }
        }

        return results;
    }

    public static void main(String[] args) {
        String[] res = wave("hello world");
        for (String str : res) {
            System.out.println(str);
        }
    }
}