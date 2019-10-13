import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class K5DirectionsReduction {
    public static String[] dirReduc(String[] arr) {
        Map<String, String> opposites = new HashMap<String, String>();
        opposites.put("NORTH", "SOUTH");
        opposites.put("SOUTH", "NORTH");
        opposites.put("WEST", "EAST");
        opposites.put("EAST", "WEST");

        Stack<String> res = new Stack<String>();
        for (String dir : arr) {
            if (!res.empty() && res.peek().equals(opposites.get(dir))) {
                res.pop();
            } else {
                res.push(dir);
            }
        }
        
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] res = dirReduc(new String[]{"NORTH", "WEST", "SOUTH"});
        for (String s : res) {
            System.out.println(s);
        }
    }
}