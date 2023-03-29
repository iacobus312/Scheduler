import java.util.Scanner;

public class Scheduler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String string_num = input.nextLine(); // number of shifts needed
        int num = Integer.parseInt(string_num);
        int shift_counter = 0;
        int nurse_counter = 0;
        String[] nurses = new String[num]; // to store input data about nurses
        String[] shifts = new String[num]; // to track shifts

        for (int i = 0; i < num; i++) {
            nurses[i] = input.nextLine() + input.nextLine();
            nurses[i] = nurses[i].replaceAll("\\s", "");
            shifts[i] = Character.toString(nurses[i].charAt(0));
            nurses[i] = nurses[i].substring(2);
        }

        /*
        for (String i : nurses) {
            System.out.println(i);
        }

        Example Input:
        3
        A 1
        1
        B 2
        1 2
        C 2
        0 2

        Output:
        1
        12
        02

        Indexes of i are already sorted per nurse, aka i[0] = A, i[1] = B, etc. Numbers dicate which shifts
        the nurses can fulfill
        nurses will just keep track of the names
         */
        String result = solve(num, shift_counter, nurse_counter, nurses, shifts);
        System.out.print(result);
    }

    public static String solve(int num_shifts, int shiftc, int nursec, String[] nurses, String[] schedule) {
        /*
        shifts_requested:
        1
        12
        02

        schedule:
        A
        B
        C
         */
        if (shiftc == num_shifts) {
            // print all the values in schedule
            for (String shift : schedule) {
                System.out.println(shift);
            }
            return "success!";
        } else {
            String str_shiftc = Integer.toString(shiftc);
            if (nurses[nursec].contains(str_shiftc) && !schedule[nursec].contains(str_shiftc)) {
                schedule[shiftc] = schedule[shiftc] + " " + str_shiftc;
                String return_value = solve(num_shifts, shiftc++, nursec, nurses, schedule);
                if (return_value.equals("impossible!")) {
                    solve(num_shifts, shiftc, nursec++, nurses, schedule);
                }
            }
            return "impossible!";
        }
    }
}
