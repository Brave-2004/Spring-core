package G50.main;

import G50.Model.StudentService;
import G50.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentService bean = context.getBean(StudentService.class);
        System.out.println(bean.StudentServiceSay());

    }
}
