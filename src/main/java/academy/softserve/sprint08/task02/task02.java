package academy.softserve.sprint08.task02;

/*
*Create annotation Review with two string elements: reviewer and date.
Element date has default string value today.
This annotation can be applied to class when we execute static method review(String className)
*  of class Util and the result of this method will be printed Class <ClassName>
was reviewed <date in format yyyy-mm-dd> by <reviewer> to standard output (console).
If the class <className> isn’t annotated we show message: Class <ClassName> isn't marked as Reviewed.
If the class was not found we show message: Class <ClassName> was not found.
*
*
*
* */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Review {
    String reviewer();

    String date() default "today";
}

class Util {
    public static void review(String className) {
        Class<?> cls = null;
        try {
            cls = Class.forName(className);
            if (cls.isAnnotationPresent(Review.class)) {
                Review review = cls.getAnnotation(Review.class);
                String data = "";
                if (review.date().equals("today")) {
                    data = LocalDate.now().toString();
                } else {
                    data = review.date();
                }
                System.out.println("Class " + className + " was reviewed " + data
                        + " by " + review.reviewer() + ".");
            } else {
                System.out.println("Class " + className + " isn't marked as Reviewed");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class " + className + " was not found");
        }
    }
}

public class task02 {
}
