import java.io.*;

public class FileIOWithMarkExample {

    public static void main(String[] args) throws IOException {

        BufferedInputStream bfStream = null;
        try {
            bfStream = new BufferedInputStream(new FileInputStream("file2.txt"));
            System.out.println((char) bfStream.read()); // Prints 'h'
            bfStream.mark(10); // Mark the current position i.e, 'e is marked'
            System.out.println((char) bfStream.read()); // Prints 'e'
            System.out.println((char) bfStream.read()); // Prints 'l'
            bfStream.reset();
            System.out.println((char) bfStream.read()); //Print 'e'
            bfStream.skip(2); // Skips two bytes of data after e. i.e, 'l' and 'l'
            System.out.println((char) bfStream.read()); //Print 'o'


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bfStream.close();
        }
    }
}
