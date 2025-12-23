package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day5 {
    public static void main(String[] args) {
        part2(part1());
    }

    public static List<String> part1() {
        List<String> ranges = new ArrayList<>();
        List<String> ingredients = new ArrayList<>();
        long first;
        long last;
        long ing;
        int count = 0;
        boolean switchy = false;
        boolean found = false;
        File puzzle = new File("testday5");
        try (Scanner reader = new Scanner(puzzle)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.isEmpty()) {
                    switchy = true;
                }
                if (!switchy) {
                    ranges.add(line);
                } else if (switchy) {
                    ingredients.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        ingredients.removeFirst();
        for (int i = 0; i < ingredients.size(); i++) {
            for (int j = 0; j < ranges.size(); j++) {
                first = Long.parseLong(ranges.get(j).substring(0, ranges.get(j).indexOf("-")));
                last = Long.parseLong(ranges.get(j).substring(ranges.get(j).indexOf("-") + 1));
                ing = Long.parseLong(ingredients.get(i));
                if (ing >= first && ing <= last) {
                    found = true;
                    count++;
                }
                if (found) {
                    found = false;
                    break;
                }
            }
        }
        return ranges;
    }

    public static void part2(List<String> ranges) {
        //unfinished, skipping and circling back some other time
        long first;
        long last;
        long bigFirst = 0;
        long bigLast = 0;
        long count = 0;
        List<String> pastRanges = new ArrayList<>();
        for (int i = 0; i < ranges.size(); i++) {
            first = Long.parseLong(ranges.get(i).substring(0, ranges.get(i).indexOf("-")));
            last = Long.parseLong(ranges.get(i).substring(ranges.get(i).indexOf("-") + 1));
            if (i == 0){
                bigFirst = first;
                bigLast = last;
                count += (last - first) + 1;
            }
            if (first < bigFirst && last > bigLast) {
                count += bigFirst - first;
                count+= last - bigLast;
                bigFirst = first;
                bigLast = last;
            }
            else if (first <= bigLast && last > bigLast) {
                count+= last - bigLast;
                bigLast = last;
            }
            else if (last == bigFirst){
                count+= bigFirst - first;
                bigFirst = first;
            } else if (first >= bigFirst && last <= bigLast) {
                break;
            } else {
                count += (last - first) + 1;
                pastRanges.add(ranges.get(i));
            }

        }
        System.out.println(count);
    }
}

