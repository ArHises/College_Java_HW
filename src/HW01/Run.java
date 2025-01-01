package HW01;

public class Run {
    public static void main(String[] args) {
        // Task 01:

        Task01 task01 = new Task01();
        System.out.println(task01.checkID("123456789"));
        System.out.println(task01.checkID("12345a789"));
        System.out.println(task01.checkID("12345678"));
        System.out.println(task01.checkID("1234567896"));
        System.out.println(task01.checkID("-123456789"));
        System.out.println(task01.checkID("123456782"));

        // Task 02:

//        Task02 task02 = new Task02();
//        task02.runWordle();
    }
}
