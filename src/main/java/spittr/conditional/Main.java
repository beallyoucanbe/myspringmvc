package spittr.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Condition;

/**
 * Created by zhaosy-c on 2017/8/1.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService listService = context.getBean(ListService.class);

        System.out.println(context.getEnvironment().getProperty("os.name") + "系统下的列表命令为："
                + listService.showListCmd());
        System.out.println(context.getEnvironment());
    }
}
