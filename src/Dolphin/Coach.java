package Dolphin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Coach {

    private String name;
    private List<CompetitionSwimmer> swimmers;
    private List<Coach> coaches = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public Coach(String name) {
        this.name = name;
        this.swimmers = new ArrayList<>();
    }
    public Coach(){
    }

    public void addCoaches(Coach coach){
        coaches.add(coach);
    }

    public void viewCoaches(){
        System.out.println("Coaches: ");
        for (int i = 0; i < coaches.size(); i++){
            System.out.println(i + ". " + coaches.get(i));
        }
    }

    public Coach chooseCoach() {
        boolean run = true;
        Coach selectedCoach = null;

        while (run) {
            viewCoaches();
            System.out.println("Enter the number of the 'desired' coach:");
            int ans = scanner.nextInt();
            scanner.nextLine();

            if (ans > 0 && ans < coaches.size()) {
                selectedCoach = coaches.get(ans);
                System.out.println("Coach: " + selectedCoach);
                run = false;
            } else {
                System.out.println("INVALID!");
            }
        }
        return selectedCoach;
    }

    public void addSwimmer(CompetitionSwimmer swimmer) {
        swimmers.add(swimmer);
    }

    public void displaySwimmers() {
        for (CompetitionSwimmer swimmer : swimmers) {
            System.out.println(swimmer.getMember().getName());
        }
    }

    @Override
    public String toString() {
        return name;
    }

}