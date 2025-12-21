package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day3 {
    public static void main(String[] args) {
        //part1();
        part2();
    }

    public static void part1() {
        int index = 0;
        int firstNum = 0;
        int secondNum = 0;
        boolean secondFound = false;
        int jolt = 0;
        int count = 0;
        File puzzle = new File("day-3-puzzle-input.txt");
        try (Scanner reader = new Scanner(puzzle)) {
            while (reader.hasNextLine()) {
                String code = reader.nextLine();
                for (int i = 9; i >= 0; i--) {
                    index = code.indexOf("" + i);
                    if (index != -1 && index != code.length() - 1) {
                        firstNum = i;
                        code = code.substring(index + 1);
                        break;
                    }
                }
                for (int k = 9; k >= 0; k--) {
                    index = code.indexOf("" + k);
                    if (index != -1) {
                        secondNum = k;
                        break;
                    }
                }
                jolt = firstNum * 10 + secondNum;
                System.out.println(jolt);
                count += jolt;
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(count);
    }

    public static void part2() {
        int index = 0;
        long jolt = 0;
        long count = 0;
        File puzzle = new File("day-3-puzzle-input.txt");
        try (Scanner reader = new Scanner(puzzle)) {
            while (reader.hasNextLine()) {
                String code = reader.nextLine();
                StringBuilder sb = new StringBuilder();
                for (int i = 11; i >= 0; i--) {
                    for (int j = 9; j >= 0; j--) {
                        index = code.indexOf("" + j);
                        if (index != -1 && index < code.length() - i) {
                            sb.append(j);
                            code = code.substring(index + 1);
                            break;
                        }
                    }
                }

                jolt = Long.parseLong(sb.toString());
                count += jolt;
                }

            }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(count);
    }
}

