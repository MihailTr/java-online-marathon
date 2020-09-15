package academy.softserve.sprint02;
/**
 * Create next types: Person (field String name), Student (fields String studyPlace, int studyYears)
 * and Worker (fields String workPosition, int experienceYears). Classes Student and Worker are
 * derived from class Person. All classes have getters to return fields.
 * Create a maxDuration() method of the MyUtils class to return a list of Students
 * with maximum duration of study and Workers with maximum experience.
 * For example, for a given list
 * [Person [name=Ivan],
 * Student [name=Petro, studyPlace=University, studyYears=3],
 * Worker [name=Andriy, workPosition=Developer, experienceYears=12],
 * Student [name=Stepan, studyPlace=College, studyYears=4],
 * Worker [name=Ira, workPosition=Manager, experienceYears=8],
 * Student [name=Ihor, studyPlace=University, studyYears=4]]
 * you should get
 * [Worker [name=Andriy, workPosition=Developer, experienceYears=12],
 * Student [name=Stepan, studyPlace=College, studyYears=4],
 * Student [name=Ihor, studyPlace=University, studyYears=4]]
 * <p>
 * import java.util.ArrayList;
 * import java.util.Collections;
 * import java.util.Comparator;
 * import java.util.HashMap;
 * import java.util.List;
 * import java.util.Map;
 * <p>
 * class Person {
 * // Code
 * }
 * class Student extends Person {
 * // Code
 * }
 * class Worker extends Person {
 * // Code
 * }
 * public class MyUtils {
 * public List<Person> maxDuration(List<Person> persons) {
 * // Code
 * }
 * }
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Person {
    // Code
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Student extends Person {
    // Code
    private String studyPlace;
    private int studyYears;

    public Student(String name, String studyPlace, int studyYears) {
        super(name);
        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }
}

class Worker extends Person {
    // Code
    private String workPosition;
    private int experienceYears;

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }
}

public class MyUtils1 {
    public List<Person> maxDuration(List<Person> persons) {
        // Code
        List<Person> workerList = new ArrayList<>();
        List<Person> studentList = new ArrayList<>();
        List<Person> mapPers= new ArrayList<>();
        mapPers.clear();
        if (persons.isEmpty()) {
            return mapPers;
        } else {
            for (Person list : persons) {
                String clPr = String.valueOf(list.getClass().getSimpleName());
                if (clPr.equals("Worker")) {
                    workerList.add(list);
                } else if (clPr.equals("Student")) {
                    studentList.add(list);
                }
            }

            for (Person person: workerList){
                int maxW = maxValueWork(workerList);
                if (maxW==((Worker)person).getExperienceYears()) {
                    mapPers.add(person);
                }
            }

            for (Person person: studentList){
                int maxS = maxValueStud(studentList);
                if (maxS==((Student)person).getStudyYears()) {
                    mapPers.add(person);
                }
            }
        }
        return mapPers;
    }

    int maxValueWork(List<Person> listMax) {
        int max = 0;
        for (Person person : listMax) {
            if (max < ((Worker)person).getExperienceYears()) {
                max = ((Worker)person).getExperienceYears();
            }
        }
        return max;
    }

    int maxValueStud(List<Person> listMax) {
        int max = 0;
        for (Person person : listMax) {
            if (max < ((Student)person).getStudyYears()) {
                max = ((Student)person).getStudyYears();
            }
        }
        return max;
    }
}

class task03 {
    public static void main(String[] args) {
//        Student student = new Student("Qwer", "VPU", 2);
//        System.out.println(student.getName());
        List<Person> originList = new ArrayList<>();
        originList.add(new Person("Ivan"));
        originList.add(new Student("Petro", "University", 3));
        originList.add(new Worker("Andriy", "Developer", 12));
        originList.add(new Student("Stepan", "College", 4));
        originList.add(new Worker("Ira", "Manager", 8));
        originList.add(new Student("Ihor", "University", 4));

        MyUtils1 myUtils1 = new MyUtils1();
        myUtils1.maxDuration(originList);
        System.out.println(myUtils1.maxDuration(originList).toString());
    }
}






