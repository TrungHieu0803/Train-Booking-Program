package TrainBooking;

import java.util.Scanner;


public class Main {

    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);    
        Manager t = new Manager();
        t.clear();
        while(true){
            System.out.println("***************MENU*****************");
            System.out.println("1. Train list");
            System.out.println("2. Customer list ");
            System.out.println("3. Booking list");
            System.out.println("0. Exit");
            System.out.print("Enter your option:");
            int choice = sc.nextInt();
            switch(choice){
                case 1:                  
                    boolean check = true;
                    while(check){
                        System.out.println("1. Load data from file");
                        System.out.println("2. Input & add to the end");
                        System.out.println("3. Display data");
                        System.out.println("4. Save train list to file");
                        System.out.println("5. Search by train's code");
                        System.out.println("6. Delete by train's code");
                        System.out.println("7. Sort by train's code");
                        System.out.println("8. Add after position k");
                        System.out.println("9. Delete the node before the node having tcode = xCode");
                        System.out.println("0. Exit");
                        System.out.print("Enter your option: ");
                        int c1 = sc.nextInt();
                        switch(c1){
                            case 1:
                                t.loadTrainFile();
                                System.out.println("-------Loading successful-------");
                                break;
                            case 2:
                                t.createNewCustomer();
                                System.out.println("-------Adding successful-------");
                                break;
                            case 3:
                                t.traverseForTrain();
                                break;
                            case 4:
                                t.saveTrainFile();
                                System.out.println("-------Saving successful-------");
                                break;
                            case 5:
                                t.searchByTrainCode();
                                break;
                            case 6:
                                t.deleteByTrainCode();
                                System.out.println("-------Deleting successful-------");
                                break;
                            case 7:
                                t.sortByTrainCode();
                                break;
                            case 8:
                                t.addAfter();
                                System.out.println("-------Adding successful-------");
                                break;
                            case 9:
                                t.del();
                                break;
                            case 0:
                                check = false;                              
                        }
                    }
                    break;
                case 2:
                    boolean check1 = true;
                    while(check1){
                        System.out.println("1. Load data from customer's file");
                        System.out.println("2. Input & add to the end");
                        System.out.println("3. Display customer's data");
                        System.out.println("4. Save customer list to file");
                        System.out.println("5. Search by customer's code");
                        System.out.println("6. Delete by customer's code");
                        System.out.println("0. Exit");
                        System.out.print("Enter your option: ");
                        int c2 = sc.nextInt();
                        switch(c2){
                            case 1:
                                t.loadCustomerFile();
                                System.out.println("-------Loading successful-------");
                                break;
                            case 2:
                                t.createNewCustomer();
                                System.out.println("-------Adding successful-------");
                                break;
                            case 3:
                                t.traverseForCustomer();
                                break;
                            case 4:
                                t.saveCustomerFile();
                                System.out.println("-------Saving successful-------");
                                break;
                            case 5:
                                t.searchByCutomerCode();
                                break;
                            case 6:
                                t.deleteByCustomerCode();
                                System.out.println("-------Deleding successful-------");
                                break;
                            case 0:
                                check1 = false;
                        }
                    }
                    break;
                case 3:
                    System.out.println("======Information of Trains======");
                    t.loadTrainFile();
                    t.traverseForTrain();
                    System.out.println();
                    System.out.println("======Information of Customers===== ");
                    t.loadCustomerFile();
                    t.traverseForCustomer();
                    boolean check2 = true;
                    while(check2){
                        System.out.println("1. Input data");
                        System.out.println("2. Display booking data");
                        System.out.println("3. Sort  by tcode + ccode");
                        System.out.println("0. Exit");
                        System.out.print("Enter your option: ");
                        int c3 = sc.nextInt();
                        switch(c3){
                            case 1:
                                t.createNewBooking();
                                System.out.println("-------Booking successful-------");
                                break;
                            case 2:
                                t.traverseForBooking();
                                break;
                            case 3:
                                break;
                            case 0:
                                check2 = false;
                        }
                    }
                    break;
                case 0:
                    return;
            }
        }
        
     
        
    }
    
}
