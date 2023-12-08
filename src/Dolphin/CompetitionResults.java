        package Dolphin;
import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CompetitionResults extends Member {
    private double result;
    private LocalDateTime date;
    private CompetitionSwimmer competitionSwimmer;
    private Coach coach;
    private List<CompetitionResults> competitionResultsList;

    public CompetitionResults(double result, LocalDateTime date, CompetitionSwimmer competitionSwimmer, Coach coach) {
        this.result = result;
        this.date = date;
        this.competitionSwimmer = competitionSwimmer;
        this.coach = coach;
        this.competitionResultsList = new ArrayList<>();
    }
    public CompetitionResults() {
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public List<CompetitionResults> getCompetitionResultsList() {
        return competitionResultsList;
    }

    public LocalDateTime getDate() {
        return date;
    }
    public Coach getCoach() {
        return coach;
    }
    public void setCoach(Coach coach) {
        this.coach = coach;
    }
    public CompetitionSwimmer getCompetitionSwimmer() {
        // this.competitionSwimmer = CompetitionSwimmer.createCompetitionSwimmer();
        return competitionSwimmer;
    }
    public double getResult() {
        return result;
    }
    public void setResult(double result) {
        this.result = result;
    }
    public void getCompetitionResultsFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        //this.competitionSwimmer = CompetitionSwimmer.createCompetitionSwimmer();
        System.out.println("Enter competition results: ");
        this.result = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter competition date (yyyy-MM-dd HH:mm): ");
        String dateString = scanner.nextLine();
        this.date = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.coach = this.competitionSwimmer.getCoach();

        saveCompetitionResultsToFile();
    }


    public void saveCompetitionResultsToFile() {
        try {
            FileWriter fileWriter = new FileWriter("CompetitionResults.txt", true);
            PrintWriter writer = new PrintWriter(fileWriter);
            writer.println("Competition Swimmer: " +  competitionSwimmer);
            writer.println("Results: " + result);
            writer.println("Date: " + date);
            writer.println("Coach: " + coach);
            writer.println();

            System.out.println("Competition results saves successfully!");
            writer.close();
        } catch(FileNotFoundException e) {
            System.err.println("Error saving competition results to file: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public String toString() {
        return "CompetitionResults{" +
                ", competition Swimmer=" + competitionSwimmer +
                ", coach=" + coach +
                "result=" + result +
                ", date=" + date +
                '}';
    }
}
 