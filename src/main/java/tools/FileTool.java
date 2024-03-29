package tools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileTool {

    public static void rename(String dir, int prefix) {

        try (Stream<Path> walk = Files.walk(Paths.get(dir))) {

            List<String> result = walk.filter(Files::isRegularFile)
                    .map(Path::toString).collect(Collectors.toList());

            for(String path : result){
                File file = new File(path);
                if (nameNotContains(file, "java") && nameNotContains(file, "py")
                        && nameNotContains(file, "jar") && nameNotContains(file, "h5")) {
                    String extension = file.getName().split("\\.")[1];
                    File newFile = new File(dir + "/" + prefix + "." + extension);
                    String oldName = file.getAbsolutePath();
                    file.renameTo(newFile);
                    System.out.println(oldName + " => " + newFile.getAbsolutePath());
                    prefix++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean nameNotContains(File f, String text) {
        return !f.getName().contains(text);
    }
}
