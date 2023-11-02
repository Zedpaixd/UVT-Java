import java.util.ArrayList;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;

class Classroom {
    private ArrayList<PersonClass> students = new ArrayList<>();
//    private HashMap<String, Integer> gradebook = new HashMap<>();
    private HashMap<Integer,String> gradebook = new HashMap<>();
    private Teacher classroomTeacher;
    private String className;

    public Classroom(Teacher t, String c)
    {
        this.classroomTeacher = t;
        this.className = c;
    }

    public void addStudent(PersonClass student) {
        students.add(student);
    }

    public void addGrade(String studentName, int grade) {
        gradebook.put(grade, studentName);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = sdf.format(new Date());

        return "Welcome to " + this.className +
                "\nTaught by Prof. " + this.classroomTeacher.getName() +
                "\nCurrent date is: " + currentDate +
                "\nGradebook: " + gradebook.toString();
    }
}
