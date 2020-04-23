import java.io.*;
import java.nio.file.Paths;
import static java.nio.file.Files.isDirectory;

public class LineAndWordsInFile {
    public static void main(String[] args) {
        String nameIn = args[0];
        int countLines = 0;
        int countWords = 0;
        if (!isDirectory(Paths.get(nameIn))) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(nameIn));
                String line = "";
                while((line = reader.readLine()) != null) {
                    countLines++;
                    String[] strings = line.split(" ");
                    countWords += strings.length;
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("File doesn't exist!");
            }
        } else {
            File folder = new File(nameIn);
            File[] listOfFiles = folder.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(listOfFiles[i].getAbsolutePath()));
                    String line = "";
                    while((line = reader.readLine()) != null) {
                        countLines++;
                        String[] strings = line.split(" ");
                        countWords += strings.length;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Folder doesn't exist!");
                }
                System.out.println(listOfFiles[i].getName());
            }
        }
        System.out.println("Строк " + countLines + "\nСлов " + countWords);
    }
}

