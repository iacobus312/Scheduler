import java.util.Scanner;


public class Scheduler2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String string_num = input.nextLine(); // number of shifts needed
        int num = Integer.parseInt(string_num);
        String[] nurses = new String[num]; // to store input data about nurses
        String[] shifts = new String[num]; // to track shifts

        for (int i = 0; i < num; i++) {
            shifts[i] = Character.toString(input.nextLine().charAt(0));
            nurses[i] = input.nextLine();
        }

        String result = solve(num, nurses, shifts);
        System.out.print(result);
    }

    public static String solve(int num_shifts, String[] nurses, String[] schedule) {
        boolean status = true;
        for (int i = 0; i < num_shifts; i++) {
            if (schedule[i].length() == 1) {
                status = false;
                break;
            }
        }

        if (status) { // stop condition
            System.out.println("Success condition met!");
            // print all the values in schedule
            for (String shift : schedule) {
                System.out.println(shift);
            }
            return "success!";
        } else {
            System.out.println();
            System.out.println("Current Schedule: ");
            for (String i : schedule) {
                System.out.print(i);
            }
            // Combines all the nurses currents assignment into one string
            // This will make it easier to see if a shift has been assigned
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < num_shifts; i++) {
                sb.append(schedule[i]);
            }
            System.out.println();
            System.out.println("Stringbuilder: " + sb);

            for (int i = 0; i < num_shifts; i++) {
                // running through each nurse's schedule
                if (schedule[i].length() == 1) {
                    // if the nurse is not assigned a shift
                    for (String Shift_num : nurses[i].split(" ")) {
                        System.out.println("Shift_num: " + Shift_num);
                        // running through every possible shift for that nurse
                        if (sb.toString().contains(Shift_num)) { // if shift has not already been assigned
                            System.out.println("Shift already assigned!");
                        } else {
                            System.out.println("Before Schedule[i]: " + schedule[i]);
                            String old_schedule = schedule[i];
                            schedule[i] = schedule[i] + " " + Shift_num; // add shift to the nurse
                            System.out.println("After Schedule[i]: " + schedule[i]);
                            String result = solve(num_shifts, nurses, schedule); // run with updated schedule
                            if (result.equals("success!")) {
                                return ("success!");
                            } else {
                                schedule[i] = old_schedule;
                            }
                        }
                    }
                }
            }
        }
        return "impossible!";
    }
}

/*
Test cases:

Input:
2
A 2
0 1
B 1
0

Intended Output:
A 1
B 0

Input2:
2
A 1
0
B 1
0

IntendedOutput2:
impossible

Input3:
3
A 1
1
B 2
1 2
C 2
0 2

IntendedOutput3:
A 1
B 2
C 0

Input4:
8
A 2
0 4
B 4
0 2 5 7
C 3
1 4 6
D 3
1 2 4
E 2
4 6
F 2
2 7
G 1
0
H 3
1 3 5

IntendedOutput4:
A 4
B 5
C 1
D 2
E 6
F 7
G 0
H 3


*/
