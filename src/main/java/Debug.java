import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static Lesson_4.helper.FileHelper.readFile;
import static Lesson_4.helper.FileHelper.writeToFile;

public class Debug {



    public static void main(String[] args) {
        String filePath = "C:\\Users\\artem\\IdeaProjects\\" +
                "ATAM_G3_MAVEN\\src\\main\\resources\\data\\app-data.txt";
        File appData = new File(filePath);

        try {
            System.out.println(Files.readAllBytes(Paths.get(filePath)).length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> lines =  readFile(filePath);

        writeToFile(filePath,
                lines.stream()
                        .map(test -> test + ": " + new Date())
                        .collect(Collectors.toList()));

    }

}
