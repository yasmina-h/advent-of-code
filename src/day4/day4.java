package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day4 {
    public static void main(String[] args) {
        //part1();
        part2(part1(),0);
    }

    public static List<String> part1 () {
        char roll = '@';
        int lines = 0;
        boolean noNext = false;
        boolean noPrev = true;
        String prev = "";
        String next = "";
        int k;
        int f;
        int count = 0;
        int tmpCount = 0;
        List<String> input = new ArrayList<>();
        File puzzle = new File("day-4-puzzle-input.txt");
        try (Scanner reader = new Scanner(puzzle)) {
            while (reader.hasNextLine()) {
                input.add(reader.nextLine());
                lines++;
            }
                for (int i = 0; i < lines; i++) {
                    if (i == lines-1){
                        noNext = true;
                    } else next = input.get(i+1);
                    if (!noPrev) {
                        prev = input.get(i - 1);
                    }
                    for (int j = 0; j < input.get(i).length(); j++) {
                        if (input.get(i).charAt(j) == roll){
                            if(j == 0){
                                k = 0;
                                f = 2;
                            } else if (j == input.get(i).length()-1){
                                k = -1;
                                f = 1;
                            }
                            else {
                                k = -1;
                                f = 2;
                            }

                            for ( ; k < f; k++) {
                                if (!noPrev){
                                    if (prev.charAt(j+k) == roll){
                                        tmpCount++;
                                    }
                                }
                                if (!noNext) {
                                    if (next.charAt(j+k) == roll) {
                                        tmpCount++;
                                    }
                                }
                                if (input.get(i).charAt(j+k) == roll){
                                    tmpCount++;
                                }

                            }
                            if (tmpCount < 5){
                                count++;
                            }
                            tmpCount = 0;
                        }
                    }
                    noPrev = false;
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            }
        return input;
        }

        public static int part2(List<String> input, int count){
            char roll = '@';
            int lines = input.size();
            int origCount = count;
            boolean noNext = false;
            boolean noPrev = true;
            String prev = "";
            String next = "";
            String origString;
            String inputString;
            int k;
            int f;
            int tmpCount = 0;
            List<String> result = new ArrayList<>();
                for (int i = 0; i < lines; i++) {
                    if (i == lines-1){
                        noNext = true;
                    } else next = input.get(i+1);
                    if (!noPrev) {
                        prev = input.get(i - 1);
                    }
                    origString = input.get(i);
                    inputString = origString;
                    for (int j = 0; j < input.get(i).length(); j++) {
                        if (input.get(i).charAt(j) == roll){
                            if(j == 0){
                                k = 0;
                                f = 2;
                            } else if (j == input.get(i).length()-1){
                                k = -1;
                                f = 1;
                            }
                            else {
                                k = -1;
                                f = 2;
                            }

                            for ( ; k < f; k++) {
                                if (!noPrev){
                                    if (prev.charAt(j+k) == roll){
                                        tmpCount++;
                                    }
                                }
                                if (!noNext) {
                                    if (next.charAt(j+k) == roll) {
                                        tmpCount++;
                                    }
                                }
                                if (input.get(i).charAt(j+k) == roll){
                                    tmpCount++;
                                }

                            }
                            if (tmpCount < 5){
                                count++;
                                inputString = inputString.substring(0,j) + 'x' + inputString.substring(j+1);
                            }

                            tmpCount = 0;
                        }
                    }
                    result.add(inputString);
                    noPrev = false;
                }
            if (count == origCount){
                return count;
            } else return part2(result,count);
        }
    }
