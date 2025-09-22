import java.util.Scanner;

public class Sudoku {
    public static boolean check (int [][] a) {
        // check row
        for (int i = 0; i < 9; i++) {
            boolean[] checkrow = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (checkrow[a[i][j]]) return false;
                checkrow[a[i][j]] = true;
            }
        }
        // check col
        for (int i = 0; i < 9; i++) {
            boolean[] checkcol = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (checkcol[a[j][i]]) return false;
                checkcol[a[j][i]] = true;
            }
        }
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j++) {
                boolean[] checkblock = new boolean[10];
                for (int n = 0; n < 3; n++) {
                    for (int m = 0; m < 3; m++) {
                        int value = a[i * 3 + n][j *3 + m];
                        if(checkblock[value]) return false;
                        checkblock[value] = true;
                    }
                }
            }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] a = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println(check(a));
    }
}
