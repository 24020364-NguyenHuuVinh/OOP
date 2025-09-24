public class QueenChecker {
    private static boolean check(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i - a[i] == j - a[j]) return false;
                if (i + a[i] == j + a[j]) return false;
            }
        }
        return  true;
    }
    public static void main(String[] args) {
        int n = args.length;
        int []a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(args[i]);
        }
        if (check(a)) {
            System.out.println("valid");
        }
        else {
            System.out.println("Invalid");
        }

    }
}
