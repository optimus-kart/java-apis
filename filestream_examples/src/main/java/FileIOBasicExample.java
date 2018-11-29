
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileIOBasicExample {

    public static void main(String[] args) throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream("file.txt");
        InputStream inputStream = new FileInputStream("file.txt");
        byte arr_byte[] = {65, 66, 67};
        try {
            outputStream.write(arr_byte);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        try {
            int read_bytes = inputStream.read();
            char[] read_chars = new char[3];
            int i = 0;
            while (read_bytes != -1) {
                read_chars[i++] = (char) read_bytes;
                read_bytes = inputStream.read();
            }
            System.out.println(new String(read_chars));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
