/**
 * Name: Wyatt Humphrey
 * Date: 1/21/25
 * Purpose: This programs prompts user to input player information (name, height, age). Players are stored in an
 * array list of Player class objects with the height stored as a height class object. Program then determines the average
 * age of players and which player has the tallest height yet less than average age.
 */

import java.util.*;

// Main Class
public class Project1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // Array list of players
        ArrayList<Player> players = new ArrayList<>();
        int totalAge = 0;
        // Loops till blank line entered
        while (true) {
            // Asks for players name
            System.out.print("Enter player's name: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }
            // Asks for age and height
            System.out.print("Enter " + name + "'s age and height in feet and inches: ");
            int  age = scanner.nextInt(), feet = scanner.nextInt(), inches = scanner.nextInt();
            scanner.nextLine();
            // Player added to player Array list
            players.add(new Player(name, new Height(feet, inches), age));
            totalAge += age;
        }

        if (players.isEmpty()){
            System.out.println("No player data entered.");
            return;
        }
        // Computes and displays average
        double averageAge = (double) totalAge / players.size();
        System.out.printf("Average player age: %.2f%n", averageAge);
        // Computes tallest player less than average age
        Player tallestPlayer = null;
        for (Player player : players) {
            if (player.getAge() <= averageAge) {
                if (tallestPlayer == null || player.getHeight().toInches() >= tallestPlayer.getHeight().toInches()) {
                    tallestPlayer = player;
                }
            }
        }
        // Prints tallest player less than average age
        System.out.println("The tallest player is " + tallestPlayer.toString());
    }
}