import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import static java.nio.file.Files.isDirectory;

public class Solution {
    public static void main(String[] args) throws IOException {
        String nameIn = args[0];
        int countLines = 0, countWords = 0;
        ArrayList<String> lines = new ArrayList<>();
        if (!isDirectory(Paths.get(nameIn))) {
            try {
                File file = new File(nameIn);
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                String line = reader.readLine();


                while (line != null) {
                    lines.add(line);
                    line = reader.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (String s: lines) {
                countLines++;
                String[] strings = s.split(" ");
                countWords += strings.length;
            }
        } else {
            File folder = new File(nameIn);
            File[] listOfFiles = folder.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {

                try {
                    File file = new File(listOfFiles[i].getAbsolutePath());
                    FileReader fr = new FileReader(file);
                    BufferedReader reader = new BufferedReader(fr);
                    String line = reader.readLine();

                    while (line != null) {
                        lines.add(line);
                        line = reader.readLine();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                    for (String s: lines) {
                        countLines ++;
                        String[] strings = s.split(" ");
                        countWords += strings.length;
                    }
                System.out.println(listOfFiles[i].getName()); //проверка наличия файлов
            }
        }
        System.out.println("Строк " + countLines + "\nСлов " + countWords);
    }
}

