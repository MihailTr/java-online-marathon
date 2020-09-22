package academy.softserve.sprint04.task02;

/**
 * Create the commonStudents() method of the MyUtils class to return a HashSet of common elements of two student lists.
 * For example, for a given
 * list1 [Students [id=1, name=Ivan], Students [id=2, name=Petro], Students [id=3, name=Stepan]]
 * and
 * list2 [Students [id=1, name=Ivan], Students [id=3, name=Stepan], Students [id=4, name=Andriy]]
 * you should get
 * [Students [id=3, name=Stepan], Students [id=1, name=Ivan]].
 *
 * import java.util.HashSet;
 * import java.util.List;
 * import java.util.Set;
 * public class MyUtils {
 *     public static class Student {
 *         private int id;
 *         private String name;
 *         // Constructor, metthods, Code
 *         }
 *     public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
 *         // Code
 *     }
 * }
 */

import java.util.*;

public class MyUtils {
    public static class Student {
        private int id;
        private String name;
        // Constructor, metthods, Code

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return id == student.id &&
                    Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }
    public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
        // Code
        Set<Student>listCommon = new HashSet<>();
        if (list1 == null ) {
            return null;
        }
        if (list2 == null ) {
            return null;
        }

        if (list1.size() == 0) {
            return listCommon;
        }
        if (list2.size() == 0) {
            return listCommon;
        }

//        for (Student s :list1) {
//            if (s.getName()==null) {
//                listCommon.add(new Student(s.id, null));
//                return listCommon;
//            }
//        }
//        for (Student s :list2) {
//            if (s.getName()==null) {
//                listCommon.add(new Student(s.id, null));
//                return listCommon;
//            }
//        }


        for (Student s :list1) {
            if (list2.contains(s)) {
                listCommon.add(s);
            }
        }
        return listCommon;
    }
}



class task02 {
    public static void main(String[] args) {
//        List<MyUtils.Student> list1 = new ArrayList<>();
//        list1.add(new MyUtils.Student(1, "Ivan"));
//        list1.add(new MyUtils.Student(2, "Petro"));
//        list1.add(new MyUtils.Student(3, "Stepan"));
//        list1.add(new MyUtils.Student(4, null));
//        System.out.println(list1.toString());
////        другий список
//        List<MyUtils.Student> list2 = new ArrayList<>();
//        list2.add(new MyUtils.Student(1, "Ivan"));
//        list2.add(new MyUtils.Student(3, "Stepan"));
//        list2.add(new MyUtils.Student(4, "Andriy"));
//        System.out.println(list2.toString());
////        очікується
//        Set<MyUtils.Student> expected = new HashSet<>();
//        expected.add(new MyUtils.Student(1, "Ivan"));
//        expected.add(new MyUtils.Student(3, "Stepan"));
//        розраховується
//        Set<MyUtils.Student> actual = new MyUtils().commonStudents(list1, list2);
//        та перевіряєть з очікуваним
//        MyUtils myUtils = new MyUtils();
//        System.out.println(myUtils.commonStudents(list1, list2).toString());
        List<MyUtils.Student> list1 = new ArrayList<>();
        list1.add(new MyUtils.Student(1, null));
        list1.add(new MyUtils.Student(2, null));
//        та другий
        List<MyUtils.Student> list2 = new ArrayList<>();
        list2.add(new MyUtils.Student(1, null));
        list2.add(new MyUtils.Student(2, null));
//        очікується
        Set<MyUtils.Student> expected = new HashSet<>();
        expected.add(new MyUtils.Student(1, null));
        expected.add(new MyUtils.Student(2, null));
//        розраховується результат
//        Set<MyUtils.Student> actual = new MyUtils().commonStudents(list1, list2);


        Set<MyUtils.Student> actual = new MyUtils().commonStudents(list1, list2);
        for (MyUtils.Student s : actual) {
            System.out.println(s.getId() + " " + s.getName());
        }
    }
}
