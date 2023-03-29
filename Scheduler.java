import java.util.Scanner;

public class Scheduler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String string_num = input.nextLine(); // number of shifts needed
        int num = Integer.parseInt(string_num);
        int shift_counter = 0;
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
        for (String shiftnum : shifts) {
            System.out.println(shiftnum);
        }
        solve(num, shift_counter, nurses, shifts);
    }

    public static String solve(int num_shifts, int shiftc, String[] shifts_requested, String[] schedule) {
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
            return "success!";
        } else {
            return "impossible!";
        }
        // pseudocode, 
        // run at first with shiftc = 0
        // run recursively until shiftc = num_shifts
        // basically for every possible nurse that can have a certain shift, give her that shift, and then run with shiftc+1
        // perhaps add a for loop that dictates when go up a tier
        // conditions is that nurse can have that shift and cannot already be placed into a shift
        // find a way to connect the recursive loop together
    }
}
