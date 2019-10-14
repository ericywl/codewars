import java.util.Arrays;

public class K4ConwayGameOfLife {
    private static int[][] directions = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 },
            { 1, -1 }, { 0, -1 } };

    private static boolean checkLife(int[][] cells, int x, int y) {
        int numNeighbors = 0;
        for (int[] dir : directions) {
            int dx = x + dir[0];
            int dy = y + dir[1];
            if (dy >= 0 && dy < cells.length) {
                if (dx >= 0 && dx < cells[y].length) {
                    numNeighbors += cells[dy][dx];
                }
            }
        }

        if (cells[y][x] == 1 && (numNeighbors == 2 || numNeighbors == 3))
            return true;

        if (cells[y][x] == 0 && numNeighbors == 3)
            return true;

        return false;
    }

    private static int[][] expandCopyMatrix(int[][] cells) {
        int[][] temp = new int[cells.length + 2][cells[0].length + 2];
        for (int[] row : temp)
            Arrays.fill(row, 0);

        for (int j = 1; j < temp.length - 1; j++) {
            for (int i = 1; i < temp[j].length - 1; i++) {
                temp[j][i] = cells[j - 1][i - 1];
            }
        }

        return temp;
    }

    private static int[][] trimMatrix(int[][] cells) {
        int xMin = cells[0].length, yMin = cells.length;
        int xMax = -1, yMax = -1;

        for (int y = 0; y < cells.length; y++) {
            for (int x = 0; x < cells[y].length; x++) {
                if (cells[y][x] != 0) {
                    if (xMin > x)
                        xMin = x;
                    if (xMax < x)
                        xMax = x;
                    if (yMin > y)
                        yMin = y;
                    if (yMax < y)
                        yMax = y;
                }
            }
        }

        if (xMin == cells.length)
            return new int[][] { {} };

        int[][] res = new int[yMax - yMin + 1][];
        for (int i = yMin, j = 0; i <= yMax; i++, j++) {
            res[j] = Arrays.copyOfRange(cells[i], xMin, xMax + 1);
        }

        return res;
    }

    public static int[][] getGeneration(int[][] cells, int generations) {
        for (int g = 0; g < generations; g++) {
            int[][] temp = expandCopyMatrix(cells);
            cells = new int[temp.length][temp[0].length];

            for (int j = 0; j < temp.length; j++) {
                for (int i = 0; i < temp[j].length; i++) {
                    cells[j][i] = checkLife(temp, i, j) ? 1 : 0;
                }
            }

            cells = trimMatrix(cells);
            temp = cells;
        }

        return cells;
    }

    public static void main(String[] args) {
        int[][] temp = { { 0, 0, 0, 0 }, { 0, 6, 7, 8 }, { 0, 10, 11, 12 } };
        int[][] res = trimMatrix(temp);
        System.out.println(Arrays.deepToString(res));
    }
}