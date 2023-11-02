import java.util.ArrayList;
import java.util.Collection;

class PersonClass implements Person {
    private String name;
    private int age;
    private ArrayList<PersonClass> friendCircle = new ArrayList<>();

    public PersonClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void introduceSelf() {
        System.out.println("Hi, my name is " + this.getName() + " and I am " + this.getAge() + " years old.");
    }

    public void addFriend(PersonClass friendName) {
        if (friendCircle.contains(friendName)) return;   // guard clause
        friendCircle.add(friendName);
        friendName.addFriend(this);
    }

    public void addFriend(Collection<PersonClass> friendList) {
        for(PersonClass friendName: friendList)
        {
            if (friendCircle.contains(friendName)) return;
            friendCircle.add(friendName);
            friendName.addFriend(this);
        }

    }

    public void printAllFriends() {
        System.out.println(name + "'s Friends: ");
        for (PersonClass friend : friendCircle) {
            System.out.println("- " + friend.getName());
        }
    }

    @Override
    public String toString() {
        return "Hi, i'm " + name;
    }
}