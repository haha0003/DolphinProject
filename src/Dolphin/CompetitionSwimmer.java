package Dolphin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompetitionSwimmer extends Member{

    private Member member;
    private Coach coach;
    private SwimmingDiscipline swimmingDiscipline;
    private List<TrainingResults> trainingResultsList = new ArrayList<>();
    private List<Member> competitionSwimmers = new ArrayList<>();
    private List<CompetitionResults> competitionResultsList;
    Scanner scanner = new Scanner(System.in);

    CompetitionSwimmer(Member member, Coach coach, SwimmingDiscipline swimmingDiscipline) {
        this.member = member;
        this.coach = coach;
        this.swimmingDiscipline = swimmingDiscipline;
        this.trainingResultsList = trainingResultsList;
        this.competitionResultsList = new ArrayList<>();
    }

    public CompetitionSwimmer(){
    }

    public void setSwimmingDiscipline(SwimmingDiscipline swimmingDiscipline) {
        this.swimmingDiscipline = swimmingDiscipline;
    }
    public Member getMember() {
        return member;
    }
    public void setMember(Member member) {
        this.member = member;
    }
    public Coach getCoach() {
        return coach;
    }
    public void setCoach(Coach coach) {
        this.coach = coach;
    }
    public SwimmingDiscipline getSwimmingDiscipline() {
        return swimmingDiscipline;
    }
    public List<TrainingResults> getTrainingResults() {
        return trainingResultsList;
    }
    public List<CompetitionResults> getCompetitionResultsList() {
        return competitionResultsList;
    }

    public void findAddCompSwimmer(Member member) {
        SwimmerDiscipline swimmerType = member.getMembership().getSwimmerType();
        if (swimmerType == SwimmerDiscipline.COMPETITOR) {
            competitionSwimmers.add(member);
        }
    } //Only used by Member -> createMember

    public void addToCompList(Member member) {
        competitionSwimmers.add(member);
    }

    public void viewCompSwimmers() {
        System.out.println("SWIMMERS: ");
        for (int i = 0; i<competitionSwimmers.size(); i++){
            System.out.println(i + ". " + competitionSwimmers.get(i).getName());
        }
    }

    public void createCompSwimmer(Member member, Coach coach) {
        viewCompSwimmers();
        System.out.println("Choose Number of 'desired' swimmer: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        member = competitionSwimmers.get(choice);
        setMember(member);
        System.out.println("You picked: " + member.getName());
        //TrainingResults ts = trainingResults.createTrainingResults();
        findSwimmerDiscipline();
        Coach selectedCoach = coach.chooseCoach();
        setCoach(selectedCoach);
        CompetitionSwimmer competitionSwimmer = new CompetitionSwimmer(member, selectedCoach, getSwimmingDiscipline());
        System.out.println(competitionSwimmer);
    }

    public void findSwimmerDiscipline() {
        boolean run = true;
        while (run) {
            System.out.println("Enter number of swimmer discipline:");
            SwimmingDiscipline[] s = SwimmingDiscipline.values();
            for (int i = 0; i < s.length; i++) {
                System.out.println(i + ". " + s[i]);
            }
            int ans = scanner.nextInt();
            scanner.nextLine();
            if (ans >= 0 && ans < s.length) {
                setSwimmingDiscipline(s[ans]);
                System.out.println("Swimming discipline: " + getSwimmingDiscipline());
                run = false;
            } else {
                System.out.println("INVALID!!!");
            }
        }
    }

    @Override
    public String toString() {
        return "\nCompetitionSwimmer: \n" +
                "Member: " + member.getName() +
                ", swimmingDiscipline: " + swimmingDiscipline + ", Coach: " + coach;
    }
}
