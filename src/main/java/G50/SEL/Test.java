package G50.SEL;

import G50.Model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("G50.Model");
        Student bean = applicationContext.getBean(Student.class);
        System.out.println(bean);


    }
}
