package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) {
        //part1();
        part2();
    }

    public static void part1() {
        long count = 0;
        int end;
        long first;
        long last;
        int line;
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
                    code = code.substring(end + 1);
                    line = range.indexOf("-");
                    first = Long.parseLong(range.substring(0, line));
                    last = Long.parseLong(range.substring(line + 1, end));
                    for (long i = first; i <= last; i++) {
                        String check = Long.toString(i);
                        if (check.length() % 2 == 0) {
                            if (check.substring(0, ((check.length() / 2)))
                                    .equals(check.substring((check.length() / 2)))) {
                                count += i;
                            }
                        }
                    }
                }
                line = code.indexOf("-");
                first = Long.parseLong(code.substring(0, line));
                last = Long.parseLong(code.substring(line + 1));
                for (long i = first; i <= last; i++) {
                    String check = Long.toString(i);
                    if (check.length() % 2 == 0) {
                        if (check.substring(0, ((check.length() / 2)))
                                .equals(check.substring((check.length() / 2)))) {
                            count += i;
                        }
                    }
                }
                System.out.println(count);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void part2() {
        long count = 0;
        int end;
        long first;
        long last;
        int line;
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
                    code = code.substring(end + 1);
                    line = range.indexOf("-");
                    first = Long.parseLong(range.substring(0, line));
                    last = Long.parseLong(range.substring(line + 1, end));
                    for (long i = first; i <= last; i++) {
                        count += helper(i);
                    }
                }
                line = code.indexOf("-");
                first = Long.parseLong(code.substring(0, line));
                last = Long.parseLong(code.substring(line + 1));
                for (long i = first; i <= last; i++) {
                    count += helper(i);
                }
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

        public static long helper (long first){
        boolean check2 = true;
                String check = Long.toString(first);
                if (check.length()==1){
                    return 0;
                }
                if (check.length() % 2 == 0 && check.length() != 2) {
                    if (check.substring(0, ((check.length()/2)))
                            .equals(check.substring((check.length()/2)))) {
                        System.out.println(first);
                        return first;
                    }
                    for (int j = 0; j < check.length(); j++) {
                        if (j % 2 == 0) {
                            if (check.charAt(0) != check.charAt(j)) {
                                check2 = false;
                            }
                        } else {
                            if (check.charAt(1) != check.charAt(j)) {
                                check2 = false;
                            }
                        }
                    }
                    if (check2) {
                        System.out.println(first);
                        return first;
                }

                } if (check.length() == 9) {
                    if (check.substring(0,3).equals(check.substring(3,6)) &&
                            check.substring(3,6).equals(check.substring(6,9))){
                        return first;
                    }
                }
                    check2 = true;
                    for (int j = 1; j < check.length(); j++) {
                        if (check.charAt(0) != check.charAt(j)) {
                            check2 = false;
                        }
                    }
                    if (check2) {
                        System.out.println(first);
                        return first;
                    }

            return 0;
        }
    }



