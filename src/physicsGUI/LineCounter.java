package physicsGUI;

import java.io.*;

/**
 * United OS Line Counting Tool
 *
 * Counts the total number of lines in Java files under the {@code src}
 * directory. The application invokes this utility from its administration
 * menu.
 *
 * @author Harshil Shah
 */
public class LineCounter {

    private static long totalLines = 0;

    /**
     * Counts Java source lines under {@code src} and returns a display string.
     *
     * @param args command-line arguments; currently unused
     * @return the count, or a message when the source directory is unavailable
     */
    public static String main(String[] args) {
        File directory = new File("src");

        if (directory.exists() && directory.isDirectory()) {
            countLinesInDirectory(directory);
            
            System.out.println("Total lines in project: " + totalLines);
            return "Total lines in project: " + totalLines;
        } else {
            System.out.println("Invalid directory");
            return "Invalid directory";
        }
    }

    /**
     * Recursively traverses the specified directory to count lines in all
     * `.java` files.
     *
     * @param dir The directory to search.
     */
    private static void countLinesInDirectory(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                countLinesInDirectory(file); // Recurse into subdirectory
            } else if (file.getName().endsWith(".java")) {
                countLinesInFile(file);
            }
        }
    }

    /**
     * Counts the number of lines in a single Java source file.
     *
     * @param file The `.java` file to read.
     */
    private static void countLinesInFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.readLine() != null) {
                totalLines++;
            }
        } catch (IOException e) {
            System.out.println("Failed to read file: " + file.getName());
        }
    }
}
