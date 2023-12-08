package Dolphin;

import java.util.Scanner;

public class Menu {
    private String menuHeader;
    private String[] menuLog;

    Menu(String menuHeader, String[] menuLog){
        this.menuHeader = menuHeader;
        this.menuLog = menuLog;
    }

    public void viewMenu(){
        System.out.println("\n------------------------------------");
        for (int i = 0; i < menuLog.length; i++){
            System.out.println(menuLog[i]);
        }
        System.out.println("\n"+menuHeader);
    }

    public int readChoice(){
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        int choice = 0;

        while (! valid){
            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
                valid = true;
                System.out.println();
            } else {
                scanner.nextLine();
            }
        }
        return choice;
    }

}
