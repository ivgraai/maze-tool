package hu.ivgraai.maze;

import hu.ivgraai.maze.Algorithm.TraverseResult;
import static hu.ivgraai.maze.Utility.convertIdentifier;
import static hu.ivgraai.maze.Utility.parseInput;
import static hu.ivgraai.maze.Utility.parseOutput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Gergo IVAN
 * @since 31 Oct, 2018
 */
public class Solution {

    public static void main(String[] args) {
        PrintStream ps = System.out; // TODO

        try {

            Input i = readFromFile(args[0]);
            Graph g = parseInput(i);
            TraverseResult val = Algorithm.isReachable(
                    g, convertIdentifier(i.getStart().getY(), i.getStart().getX()), convertIdentifier(i.getEnd().getY(), i.getEnd().getX())
                );
            List<List<Character>> o = parseOutput(i, val);
            writeIntoStream(o, ps);

        } catch (FileNotFoundException e) {
            ps.println("exited code with 1");
        } catch (Exception e) {
            ps.println("exited code with 2");
        }

        // out.println("Hey, how are you doing today?");
    }

    private static Input readFromFile(String name) throws FileNotFoundException {
        Input inp = new Input();

        File f = new File(name);
        try (Scanner sc = new Scanner(f)) {
            int temp = sc.nextInt();
            inp.setWidth(temp);
            temp = sc.nextInt();
            inp.setHeight(temp);
            inp.setStart(sc.nextInt(), sc.nextInt());
            inp.setEnd(sc.nextInt(), sc.nextInt());

            for (int i = 0; i < inp.getHeight(); ++i) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < inp.getWidth(); ++j) {
                    row.add(sc.nextInt());
                }
                inp.addValues(row);
            }
        }

        return inp;
    }

    private static void writeIntoStream(List<List<Character>> output, PrintStream stream) {
        for (int i = 0; i < output.size(); ++i) {
            for (int j = 0; j < output.get(i).size(); ++j) {
                stream.print(output.get(i).get(j));
            }
            stream.println();
        }
    }

}
