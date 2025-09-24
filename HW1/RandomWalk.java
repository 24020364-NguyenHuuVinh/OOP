import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
public class RandomWalk {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(-n - 0.5, n + 0.5);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();
        int x = 0, y = 0;
        int steps = 0;
        int [][] moves = { {1,0}, {0, 1}, {-1, 0}, {0, -1}};
        int movesIndex = 0;
        int index = 0;
        int stepslen = 1;
        boolean resizelen = false;
        while (Math.abs(x) < n && Math.abs(y) < n) {
            for (int i = 0; i < stepslen; i++) {
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.filledSquare(x, y, 0.45);
                x += moves[movesIndex][0];
                y += moves[movesIndex][1];
                steps++;
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.filledSquare(x, y, 0.45);
                StdDraw.show();
                StdDraw.pause(200);
            }
            movesIndex = (movesIndex + 1) % 4;
            if (resizelen) stepslen++;
            resizelen = !resizelen;
        }
        StdOut.println("Total steps = " + steps);
    }
}
