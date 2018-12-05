package www.IO;

import java.io.File;

public class TravelSpeDiret {
    public static void main(String[] args) {
        //遍历桌面
        File file = new File("C:"+File.separator+"Users"+File.separator
                +"Administrator"+File.separator+"Desktop");
        long start = System.currentTimeMillis();
        listAllFile(file);
        long end = System.currentTimeMillis();
        System.out.println("遍历结束"+(end-start));
    }

    public static void listAllFile(File file){
        if(file.exists() && file.isFile()){
            System.out.println(file);
        }else{
            File files[] = file.listFiles();
            if(files != null){
                for(File file1 : files){
                    listAllFile(file1);
                }
            }
        }
    }

    /**
     * 遍历结果
     * C:\Users\Administrator\Desktop\Centos-7.repo
     * C:\Users\Administrator\Desktop\desktop.ini
     * C:\Users\Administrator\Desktop\IO\内存流实现字母转换.java
     * C:\Users\Administrator\Desktop\io.jpg
     * C:\Users\Administrator\Desktop\output.txt
     * C:\Users\Administrator\Desktop\python.txt
     * C:\Users\Administrator\Desktop\Test.txt
     * C:\Users\Administrator\Desktop\数据库操作.txt
     * C:\Users\Administrator\Desktop\新建文本文档.txt
     * C:\Users\Administrator\Desktop\爬虫.txt
     * 遍历结束5
     */
}



