package Dolphin;

import java.util.ArrayList;

public class Subscription {
    private double price;
    private ArrayList<Member> debtList = new ArrayList<>();

    public static final String COLOR_RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";


    Subscription(){
    }


    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public void addToDebtList(Member member){
        debtList.add(member);
        System.out.println(member.getName() + " is in debt and owes ");
        findPrice(member);
    }

    public void addToDebtListNoInfo(Member member) {
        debtList.add(member);
    }

    public void removeFromDebtList(Member member){
        debtList.remove(member);
        System.out.println(member.getName() + "has now paid their debt.");
    }

    public void displayDebtList(){
        System.out.println("--------------------------------\n\tList of members in debt\n");
        for (int i = 0 ; i<debtList.size(); i++){
            System.out.println(i + ". " + debtList.get(i));

        }
    }


    public void findPrice(Member member){
        MemberType memberType = member.getMembership().getMemberType();
        MemberStatus memberStatus = member.getMembership().getMemberStatus();
        int age = member.getAge();
        if (memberStatus == MemberStatus.ACTIVE) {
            if (memberType == MemberType.JUNIOR) {
                setPrice(1000);
                System.out.println(getPrice() + "kr yearly");
            } else if (memberType == MemberType.SENIOR && age >= 60) {
                setPrice(1200);
                System.out.println(getPrice() + "kr yearly");
            } else {
                setPrice(1600);
                System.out.println(getPrice() + "kr yearly");
            }
        }else {
            setPrice(500);
            System.out.println(getPrice() + "kr yearly");
        }
    }
}
