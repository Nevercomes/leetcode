package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 利用java的集合类和list来对多字段的对象进行排序
 * 按照 number升序，age降序，name升序 的关系来排序
 *
 * @author Sunss
 * @since 2021/3/30
 */
public class JavaListSort {

    public void test() {
        List<User> userList = new ArrayList<>();
        User u1 = new User("1", 1, 1);
        User u2 = new User("2", 2, 1);
        User u3 = new User("3", 2, 3);
        User u4 = new User("4", 4, 3);
        User u5 = new User("5", 4, 3);
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);
        userList.add(u5);
        Collections.sort(userList);
        for (User user : userList) {
            System.out.println(user);
        }
        List<Staff> staffList = new ArrayList<>();
        Staff s1 = new Staff("1", 1, 1);
        Staff s2 = new Staff("2", 2, 1);
        Staff s3 = new Staff("3", 2, 3);
        Staff s4 = new Staff("4",4,3);
        Staff s5 = new Staff("5", 4, 3);
        staffList.add(s1);
        staffList.add(s2);
        staffList.add(s3);
        staffList.add(s4);
        staffList.add(s5);
        staffList.sort(new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                if (o1.number < o2.number) {
                    return -1;
                } else if (o1.number > o2.number) {
                    return 1;
                } else {
                    if (o1.age > o2.age) {
                        return -1;
                    } else if (o1.age < o2.age) {
                        return 1;
                    } else {
                        return o1.name.compareTo(o2.name);
                    }
                }
            }
        });
        for (Staff staff : staffList) {
            System.out.println(staff);
        }
    }

    public static void main(String[] args) {
        JavaListSort javaListSort = new JavaListSort();
        javaListSort.test();
    }

    static class User implements Comparable<User> {
        public String name;
        public int age;
        public int number;

        public User() {
        }

        public User(String name, int age, int number) {
            this.name = name;
            this.age = age;
            this.number = number;
        }

        @Override
        public int compareTo(User o) {
            if (this.number < o.number) {
                return -1;
            } else if (this.number > o.number) {
                return 1;
            } else {
                if (this.age > o.age) {
                    return -1;
                } else if (this.age < o.age) {
                    return 1;
                } else {
                    return this.name.compareTo(o.name);
                }
            }
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", number=" + number +
                    '}';
        }
    }

    static class Staff {
        public String name;
        public int age;
        public int number;

        public Staff() {
        }

        public Staff(String name, int age, int number) {
            this.name = name;
            this.age = age;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Staff{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", number=" + number +
                    '}';
        }
    }

}
