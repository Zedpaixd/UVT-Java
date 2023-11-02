import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Creating some sample students and a teacher
        Teacher someTeacher = new Teacher("Lee Zhang", 51);
        PersonClass john = new PersonClass("John Doe", 25);
        PersonClass alice = new PersonClass("Alice Conwell", 26);
        PersonClass[] friendCircle = {
            new PersonClass("Josh", 19),
            new PersonClass("Alex", 21),
            new PersonClass("Tim", 22),
            new PersonClass("Jae", 20)
        };


        // Making Friends
        john.addFriend(alice);  // works both ways -> alice's friend
                                // circle now also contains john
        john.addFriend(List.of(friendCircle));

        // Proving the 2-way friendship
        john.printAllFriends();
        alice.printAllFriends();

        // Initializing the classroom
        Classroom classroom = new Classroom(someTeacher,"ClassName");
        classroom.addStudent(john);
        classroom.addStudent(alice);
        classroom.addGrade(john.getName(), 90);
        classroom.addGrade(alice.getName(), 87);

//        PersonClass johnA = new PersonClass("Name", 57);
//        System.out.println(johnA.toString());

        // "Printing" the classroom
        System.out.println(classroom);
    }
}