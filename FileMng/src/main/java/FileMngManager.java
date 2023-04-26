import java.util.List;

public class FileMngManager {
    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();
        List<FileAvlbDomine> list = fileUtil.readFileFromXcel();

//        List<FileAvlbDomine> list = fileUtil.readFile();
        list.forEach(el->{
            System.out.println(el);
        });
    }
}
