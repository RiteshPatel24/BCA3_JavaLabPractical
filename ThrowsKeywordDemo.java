import java.io.IOException;

public class ThrowsKeywordDemo {
    public static void main(String[] args) {

        // Case 1: Valid file name
        System.out.println("----- Case 1: Valid File -----");
        try {
            readFile("data.txt");
        } catch (IOException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }

        // Case 2: Invalid file name (triggers exception)
        System.out.println("\n----- Case 2: Invalid File -----");
        try {
            readFile("");
        } catch (IOException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
    }

    // 'throws' declares that this method might throw an IOException,
    // passing the responsibility of handling it to the caller.
    static void readFile(String fileName) throws IOException {
        System.out.println("Attempting to read file: \"" + fileName + "\"");

        if (fileName.isEmpty()) {
            throw new IOException("File name cannot be empty.");
        }

        System.out.println("File \"" + fileName + "\" read successfully.");
    }
}

