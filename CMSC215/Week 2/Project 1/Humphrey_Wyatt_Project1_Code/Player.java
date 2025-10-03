/**
 * Name: Wyatt Humphrey
 * Date: 1/21/25
 * Purpose:  Player class with name, height stored as a height class object, and age. Has getters for variables.
 */
public class Player {
    private final String name;
    private final Height height;
    private final int age;
    // Player constructor
    public Player(String name, Height height, int age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public Height getHeight() {
        return this.height;
    }

    public int getAge() {
        return this.age;
    }
    @Override
    public String toString() {
        return "Name: " + this.name + " Age: " + this.age + " Height: " + this.height.toString();
    }
}
