package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) {
        int count = 0;
        int end = 0;
        File puzzle = new File("day-2-puzzle-input.txt");
        try (Scanner reader = new Scanner(puzzle)) {
            {
                String code = "";
                while (reader.hasNextLine()) {
                    code = reader.nextLine();
                }
                while (end < code.length()) {
                    end = code.indexOf(",");
                    code = code.substring(end+1, code.length());
                    String range = code.substring(0, end);
                    int line = range.indexOf("-");
                    int first = Integer.parseInt(range.substring(0, line));
                    int last = Integer.parseInt(range.substring(line + 1, end));
                    for (int i = first; i <= last; i++) {
                        String check = Integer.toString(i);
                        if (check.length() % 2 == 0) {
                            if (check.length() == 2) {
                                if (i % 11 == 0) {
                                    count += i;
                                }
                            }
                            if (check.substring(0, ((check.length() / 2) - 1)).equals(check.substring((check.length() / 2), (check.length()) - 1))) {
                                count += i;
                            }
                        }
                    }
                }
            }
        System.out.println(count);
    }
        catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
