import java.util.ArrayList;
import java.util.List;

public class K6RectangleIntoSquares {
    public static List<Integer> sqInRect(int lng, int wdth) {
        if (lng == wdth || lng == 0 || wdth == 0) return null;
        int h = lng, w = wdth;
        List<Integer> res = new ArrayList<Integer>();
        while (h > 0 && w > 0) {
            if (h < w) {
                res.add(h);
                w -= h;
            } else {
                res.add(w);
                h -= w;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = sqInRect(5, 3);
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}