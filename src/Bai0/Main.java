package Bai0;

import java.io.File;

public class Main {
    public static void main(String[] args){
        FileManager file = new FileManager();
        File fileSource = new File("C:\\Users\\Vu\\Desktop\\GitHub\\Java2\\src\\Hello.txt");
        try {
            file.readFile(fileSource);
            int count = file.countWord(fileSource, "c");
            if (count > 0) {
                System.out.println("Tìm thấy " + count + " kí tự");
            }
        } catch (Exception e) {
            System.out.println("Có lỗi rồi bạn ơi");
        }

        file.getFile("C:\\Users\\Vu\\Desktop\\GitHub\\Java2\\src");
    }
}