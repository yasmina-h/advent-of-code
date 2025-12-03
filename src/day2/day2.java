package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) {
        long count = 0;
        int end = 0;
        File puzzle = new File("day-2-puzzle-input.txt");
        try (Scanner reader = new Scanner(puzzle)) {
            {
                String code = "";
                while (reader.hasNextLine()) {
                    code = reader.nextLine();
                }
                while (code.contains(",")) {
                    end = code.indexOf(",");
                    String range = code.substring(0, end);
                    code = code.substring(end+1);
                    int line = range.indexOf("-");
                    long first = Long.parseLong(range.substring(0, line));
                    long last = Long.parseLong(range.substring(line + 1,end));
                    for (long i = first; i <= last; i++) {
                        String check = Long.toString(i);
                        if (check.length() % 2 == 0) {
                            if (check.length() == 2) {
                                if (i % 11 == 0) {
                                    count +=  i;
                                }
                            }
                            else if (check.substring(0, ((check.length() / 2))).equals(check.substring((check.length()/2)))) {
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
