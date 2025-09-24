public class Permutation {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int []a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int r = (int) (Math.random() * (i + 1));
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i  = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i] == j) System.out.print("* ");
                else System.out.print(". ");
            }
            System.out.println();
        }
    }
}
