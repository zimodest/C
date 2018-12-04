package www.IO;

import java.io.File;
import java.io.IOException;

public class MakeFile {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\Desktop\\javaIO");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
