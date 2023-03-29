import java.util.Scanner;

public class Scheduler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String string_num = input.nextLine(); // number of shifts needed
        int num = Integer.parseInt(string_num);

        String[] nurses = new String[num]; // to store input data about nurses

        for (int i = 0; i < num; i++) {
            nurses[i] = input.nextLine().replaceAll("\\s", "") + input.nextLine().replaceAll("\\s", "");
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
         */
        solve(num, nurses);
    }

    public static String solve(int a, String[] i) {
        return "";
    }
}

/*
solve(Nurses)
  Check if all nurses are assigned a shift, if so, then
    return success
  Let N be a nurse without a shift
  for each shift s
    if N can do s, and no one else is assigned s, then
      Assign N to s
      if solve(Nurses) is success then return success
  return "impossible"
 */
