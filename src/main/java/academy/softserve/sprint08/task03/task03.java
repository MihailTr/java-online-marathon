package academy.softserve.sprint08.task03;

/*
*Create single-value annotation TestSuite with default element that returns
* array of strings.
 Create class TestSuitHandler with static method run(Class<?> clazz).
This method invokes all public non-static zero args methods.
This method print to console information about all executed methods in form:
   -- Method <class>.<methodname> started --
<result of  methodname invocation>
  -- Method <class><methodname> finished --
(before -- should printed tab character)
If clazz doesn't contain the <methodName> defined in annotation information Method
* with name <methodName> doesn't exists or not public in class clazz should be displayed.
If clazz is not marked with TestSuite annotation message Class clazz isn't
* annotated  should be displayed.
For example
We have
@TestSuite({"m1", "m2"})
class Class1{
  public void m2(){
    System.out.println("Hello");
  }
}

We run
TestSuiteHandler.run(Class1.class);

As a result we have

Method with name m1 doesn't exists or not public in class Class1
	 -- Method Class1.method2 started --
Hello
	 -- Method Class1.method2 finished --
*
*
*import java.lang.annotation.*;
import java.lang.reflect.*;

// type your code here
*
*
* */

import java.lang.annotation.*;
import java.lang.reflect.*;

// type your code here

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface TestSuite{
    String[] value();
}

class TestSuitHandler{
    public static void run(Class<?> clazz){
        if (clazz.isAnnotationPresent(TestSuite.class)) {
            TestSuite testSuite = clazz.getAnnotation(TestSuite.class);
            for (int i = 0; i <testSuite.value().length ; i++) {
                try {
                    if (clazz.getMethod(testSuite.value()[i]).getParameterCount() ==0
                            && !Modifier.isStatic(clazz.getMethod(testSuite.value()[i]).getModifiers())) {
                        System.out.println("\t -- Method " + clazz.getSimpleName() + "."
                                + testSuite.value()[i] + " started --");
                        try {
                            clazz.getMethod(testSuite.value()[i])
                                    .invoke(clazz.getDeclaredConstructor().newInstance());
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        System.out.println("\t -- Method " + clazz.getSimpleName() + "."
                                + testSuite.value()[i] + " finished --");
                    }
                }catch (NoSuchMethodException e){
                    System.out.println("Method with name " + testSuite.value()[i]
                            + " doesn't exists or not public in class " + clazz.getSimpleName());
                }
            }
        }else {
            System.out.println("Class "+clazz.getSimpleName()+" isn't " +
                    "annotated");
        }
    }
}


@TestSuite({"m1", "m2"})
class Class1{
    public void m2(){
        System.out.println("Hello");
    }
}
class Class2{

}

public class task03 {
    public static void main(String[] args) {
        TestSuitHandler.run(Class1.class);
        TestSuitHandler.run(Class2.class);

    }
}
