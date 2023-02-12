import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File[] catalogs = {
                new File("D://Games/src"),
                new File("D://Games/src/main"),
                new File("D://Games/src/test"),
                new File("D://Games/res"),
                new File("D://Games/res/drawables"),
                new File("D://Games/res/vectors"),
                new File("D://Games/res/icons"),
                new File("D://Games/savegames"),
                new File("D://Games/temp")};
        File[] files = {
                new File("D://Games/src/main/Main.java"),
                new File("D://Games/src/main/Utils.java"),
                new File("D://Games/temp/temp.txt")};
        StringBuilder sb = new StringBuilder();
        for (File catalog : catalogs) {
            if (catalog.mkdir())
                sb.append("Каталог ").append(catalog.getName()).append(" создан");
            sb.append("\n");
        }
        for (File file : files) {
            try {
                if (file.createNewFile())
                    sb.append("Файл ").append(file.getName()).append(" создан");
                sb.append("\n");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        String text = sb.toString();
        try (FileWriter writer = new FileWriter("D://Games/temp/temp.txt")) {
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}