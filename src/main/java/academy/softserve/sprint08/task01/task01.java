package academy.softserve.sprint08.task01;
/*
* Create marker-annotation CamelCase which will check whether method named
* according to code conventions. Create class CheckCamelCase for checking
* if all the annotated methods of some class satisfy naming pattern. This class
*  contains constant 'CAMELCASE_PATTERN' that introduces regex for checking
* method name. Also this class contains method checkAndPrint(Class clazz) which
* returns true if all annotated methods of class satisfy 'CAMELCASE_PATTERN'
* and prints to standard output information about all incorrect method names by
*  template: method <className>.<methodName> doesn't satisfy camelCase naming
* convention. For example

For class
public class Class1{
@CamelCase
public void correct(){}
@CamelCase
public void InCorrect(){}
public void JustMethod(){}
}
call CheckCamelCase.checkAndPrint(Class1.class)
prints to console
method Class1.InCorrect doesn't satisfy camelCase naming convention
*
* method <className>.<methodName> doesn't satisfy camelCase naming convention
* */


import java.lang.annotation.*;
import java.lang.reflect.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface CamelCase {
}

class CheckCamelCase {
    public static final String CAMELCASE_PATTERN = "^[a-z][a-zA-Z0-9]*$";

    public static boolean checkAndPrint(Class clazz) {
        boolean result = true;
        Method[] annotations = clazz.getDeclaredMethods();
        for (Method anno : annotations) {
            if (anno.isAnnotationPresent(CamelCase.class)
                    && !anno.getName().matches(CheckCamelCase.CAMELCASE_PATTERN)) {
                System.out.println("method " + clazz.getSimpleName() + "." + anno.getName() +
                        " doesn't satisfy camelCase naming convention");
                result = false;
            }
        }
        return result;
    }
}


// INSERT CODE HERE


class ClassForAnnot {
    @CamelCase
    public static void example() {
    }

    @CamelCase
    public void Example() {
    }

    public static void _main(String args[]) {
    }
}

class Class1 {
    @CamelCase
    public void correct() {
    }

    @CamelCase
    public void InCorrect() {
    }

    @CamelCase
    public void JustMethod() {
    }
}

class Class2 {
    @CamelCase
    public void correct() {
    }

    @CamelCase
    public void oneMoreCorrect() {
    }
}


public class task01 {
    public static void main(String[] args) {
        CheckCamelCase.checkAndPrint(Class1.class);

    }
}
