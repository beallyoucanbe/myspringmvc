package spittr.conditional;

/**
 * Created by zhaosy-c on 2017/8/1.
 */
public class LinuxListService implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
