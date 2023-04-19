package Bai0;

import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {
    public String readFile(File filesource) throws Exception{
        try {
            FileInputStream file = new FileInputStream(filesource);
            int available = file.available();
            byte[] content = new byte[available];
            file.read(content);
            return new String(content);


        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public void getFile(String fileSource) {
        File file = new File(fileSource);
        File[] files = file.listFiles();

        for (File listFile : Objects.requireNonNull(files)) {
            if (listFile.getName().endsWith("txt")) {
                System.out.println(listFile.getAbsoluteFile());
            }
        }
    }

    public int countWord(File filSource, String word) throws Exception {
        int count = 0;
        try {
            String content = this.readFile(filSource);
            Pattern pattern = Pattern.compile(word);
            Matcher matcher = pattern.matcher(content);

            while (matcher.find()) {
                count++;
            }

        } catch (Exception e) {
            throw new Exception(e);
        }
        return count;
    }
}
