import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static java.nio.file.Files.isDirectory;

public class Solution {
    public static void main(String[] args) throws IOException {
        String nameIn = args[0];
        int countLines = 0, countWords = 0;

        if (!isDirectory(Paths.get(nameIn))) {
            List<String> lines = Files.readAllLines(Paths.get(nameIn), Charset.defaultCharset());

            for (String s: lines) {
                countLines++;
                String [] strings = s.split(" ");
                countWords += strings.length;
            }
        } else {
            File folder = new File(nameIn);
            File[] listOfFiles = folder.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                    List<String> lines = Files.readAllLines(Paths.get(nameIn+"\\"+listOfFiles[i].getName()), Charset.defaultCharset());

                    for (String s: lines) {
                        countLines ++;
                        String [] strings = s.split(" ");
                        countWords += strings.length;
                    }
                System.out.println(listOfFiles[i].getName()); //проверка наличия файлов
            }
        }
        System.out.println("Строк " + countLines + "\nСлов " + countWords);
    }
}

