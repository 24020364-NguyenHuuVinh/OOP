public class Birthday {
    public static void main(String[] args) {
        int days = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int totalPeople = 0;
        for (int i = 0; i < trials; i++) {
            boolean []hasBirthDay = new boolean[days];
            int people = 0;
            while (true) {
                people ++;
                int d = (int) (days * Math.random());
                int prev = (d - 1 + days) % days;
                int next = (d + days) % days;
                if (hasBirthDay[prev] || hasBirthDay[next]) {
                    break;
                }
                hasBirthDay[d] = true;
            }
            totalPeople += people;
        }
        int avg = totalPeople / trials;
        System.out.println(avg);
    }
}
