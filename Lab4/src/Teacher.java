public class Teacher implements Person{
    private String name;
    private int age;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void introduceSelf() {
        System.out.println("Hi, my name is " + this.getName() + " and I am " + this.getAge() + " years old.");
    }
}
