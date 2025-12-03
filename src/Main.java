import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File puzzle = new File("day-1-puzzle-input.txt");
        int dial = 50;
        int count = 0;
        int prevDial = 0;
        try (Scanner reader = new Scanner(puzzle)) {
            while (reader.hasNextLine()) {
                String code = reader.nextLine();
                if (code.indexOf("R") == 0) {
                    dial += Integer.parseInt(code.substring(1));
                    if (dial > 99) {
                        while (dial > 99) {
                            dial = dial - 100;
                            count++;
                        }
                    }
                } else if (code.indexOf("L") == 0) {
                    prevDial = dial;
                    dial -= Integer.parseInt(code.substring(1));
                    if (dial == 0){
                        count++;
                    }
                    if (dial < 0 && prevDial != 0) {
                        while (dial < 0) {
                            dial = dial + 100;
                            count++;
                        }
                    } else if (-100 < dial && dial < 0) {
                        while (dial < 0) {
                            dial = dial + 100;
                        }
                    } else if (dial < -99) {
                        while (dial < 0) {
                            dial = dial + 100;
                            count++;
                        }

                    }
                }
            }
            } catch(FileNotFoundException e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            System.out.println(count);
        }
    }
