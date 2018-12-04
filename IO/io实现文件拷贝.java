package www.IO;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) throws Exception{
            File sourseFile = new File("C:"+File.separator+"Users"+File.separator
                    +"Administrator"+File.separator+"Desktop"+File.separator+"io.jpg");
            File targetFile = new File("C:"+File.separator+"Users"+File.separator
                    +"Administrator"+File.separator+"Desktop"+File.separator+"io1.jpg");

            InputStream inputStream = new FileInputStream(sourseFile);
            OutputStream out  = new FileOutputStream(targetFile);

            long start = System.currentTimeMillis();

            int len = 0;
            byte[] data = new byte[1024];
            while ((len = inputStream.read(data)) != -1){
                out.write(data,0,len);
            }
            inputStream.close();
            out.close();
            long end = System.currentTimeMillis();
            System.out.println("共耗时"+(end-start)+"毫秒");
    }
}
