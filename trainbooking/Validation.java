package TrainBooking;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);

    

    public static int checkInputSeat() {
        int seat;
        while (true) {
            try {
                seat = sc.nextByte();
                if (seat < 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("The number of seat must be greater than 0!");
                System.out.println("Enter again");
                sc.nextLine();
            }
        }
        return seat;
    }

    public static int checkInputBooked(int seat) {
        int booked;
        while (true) {
            try {
                booked = sc.nextByte();
                if (booked < 0 || booked > seat) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("The number of booked seats in the train must be greater than 0 and smaller than numbers of seat!!");
                System.out.print("Enter again: ");
                sc.nextLine();
            }
        }
        return booked;
    }

    public static double checkInputDepartTime() {
        double departTime;
        while (true) {
            try {
                departTime = sc.nextDouble();
                if (departTime < 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Depart time must be greater than 0!");
                System.out.println("Enter again");
                sc.nextLine();
            }
        }
        return departTime;
    }
}
