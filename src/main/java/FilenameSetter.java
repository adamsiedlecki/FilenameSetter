import org.apache.commons.lang3.math.NumberUtils;
import tools.FileTool;

public class FilenameSetter {

    public static void main(String[] args) {

        String dir = System.getProperty("user.dir");
        int prefixStart = 0;

        if (args.length > 0 && args[0] != null && NumberUtils.isDigits(args[0])) {
            prefixStart = Integer.parseInt(args[0]);
        }
        if (args.length > 1 && args[1] != null && NumberUtils.isDigits(args[1])) {
            dir = args[1];
        }

        System.out.println("==================");
        System.out.println("FilenameSetter");
        System.out.println("==================");

        FileTool.rename(dir, prefixStart);
    }
}
