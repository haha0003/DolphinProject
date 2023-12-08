package Dolphin;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TrainingResults extends Member implements Comparable<TrainingResults> {

    private LocalDateTime date;
    private double timeSeconds;

    public TrainingResults(double timeSeconds ,LocalDateTime date) {
        this.timeSeconds = timeSeconds;
        this.date = date;
    }

    public TrainingResults() {
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public void setTimeSeconds(double timeSeconds) {
        this.timeSeconds = timeSeconds;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public double getTimeSeconds() {
        return timeSeconds;
    }


    public void createTrainingResults() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter date of training results (yyyy-MM-dd) ");
        String dateString = scanner.nextLine();
        this.date = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        setDate(this.date);

        System.out.println("Enter time in seconds: ");
        this.timeSeconds = scanner.nextDouble();
        setTimeSeconds(this.timeSeconds);

        System.out.println("Training results registered successfully! ");
    }

    public int compareTo(TrainingResults other) {
        return Double.compare(this.timeSeconds, other.timeSeconds);
    }


    public static void savingTrainingResultsToFile(List<TrainingResults> trainingResultsList) {
        try {
            PrintWriter writer = new PrintWriter("TrainingResults.txt");

            for (TrainingResults trainingResults : trainingResultsList ) {
                writer.println(trainingResults.getDate() + "," + trainingResults.getTimeSeconds());
            }
            System.out.println("Training results saved successfully!");
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static boolean isCompetitionSwimmer(CompetitionSwimmer swimmer, List<CompetitionSwimmer> competitionSwimmers) {
        return competitionSwimmers.contains(swimmer);
    }
}