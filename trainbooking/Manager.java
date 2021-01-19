package TrainBooking;

import entity.Booking;
import entity.Train;
import entity.Customer;
import node.NodeC;
import node.NodeT;
import java.io.*;
import java.util.Scanner;
import node.NodeB;

public class Manager {

    private static Scanner sc = new Scanner(System.in);
    NodeT head,tail;
    NodeC headC, tailC;
    NodeB headB, tailB;

    Manager() {
        head = tail = null;
        headC = tailC = null;
    }

    void clear() {
        head = tail = null;
        headC = tailC = null;
    }
//---------------------check empty-------------------------------------//
    boolean isEmptyT() {
        return (head == null);
    }

    boolean isEmptyC() {
        return (headC == null);
    }
    boolean isEmptyB() {
        return (headB == null);
    }
//-------------------------Over----------------------------------------//
    
//--------------------add to the end---------------------------------//
    void addLastForTrain(Train x){
        NodeT q = new NodeT(x);
        if (isEmptyT()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }
    void addLastForCus(Customer x) {
        NodeC q = new NodeC(x);
        if (isEmptyC()) {
            headC = tailC = q;
            return;
        }
        tailC.next = q;
        tailC = q;
    }
    void addLastForBooking(Booking x) {
        NodeB q = new NodeB(x);
        if (isEmptyB()) {
            headB = tailB = q;
            return;
        }
        tailB.next = q;
        tailB = q;
    }
//------------------------Over---------------------------------------//
    
//---------------------Find index in the list------------------------//
    //find index for train's list
    int findIndex(String code) {
        NodeT p = head;
        int count = 0;
        while (p != null) {
            if (code.equalsIgnoreCase(p.info.getTcode())) {
                return count;
            }
            count++;
            p = p.next;
        }
        return -1;
    }
    //find index for customer's list
    int findIndexC(String code) {
        NodeC p = headC;
        int count = 0;
        while (p != null) {
            if (code.equalsIgnoreCase(p.in4.getCode())){
                return count;
            }
            count++;
            p = p.next;
        }
        return -1;
    }
    //find index for booking list
    int findIndexB(String tcode, String ccode) {
        NodeB p = headB;
        int count = 0;
        while (p != null) {
            if (tcode.equalsIgnoreCase(p.in4.getTcode()) && ccode.equalsIgnoreCase(p.in4.getCcode())){
                return count;
            }
            count++;
            p = p.next;
        }
        return -1;
    }
//---------------------------Over------------------------------------//
    
//-----------------------Display data----------------------------//
    //Display for train's date
    public void traverseForTrain() {
        NodeT p = head;
        System.out.printf("%5s | %4s  | %3s | %3s | %5s | %3s | %2s\r\n", "Code", "Name", "Seat", "Booked", "Depart Time", "Depart Place", "Available Seat");
        System.out.println("------------------------------------------------------------------------------");
        while (p != null) {
            System.out.printf("%5s | %4s  | %3d  | %4d   | %8.2f    | %6s       | %6d\r\n", p.info.tcode, p.info.trainName,
                    p.info.seat, p.info.booked, p.info.departTime, p.info.departPlace, p.info.availableSeat());
            p = p.next;
        }
    }

    //Display for customer's date
    public void traverseForCustomer() {
        NodeC p = headC;
        System.out.printf("%5s | %5s | %5s \r\n", "Code", "Name", "Phone");
        System.out.println("-----------------------");
        while (p != null) {
            System.out.printf("%5s | %5s | %4s \r\n", p.in4.code, p.in4.name, p.in4.phone);
            p = p.next;
        }
    }
    public void traverseForBooking() {
        NodeB p = headB;
        System.out.printf("%5s | %5s | %5s \r\n", "Customer's code", "Train's code", "Booked seat");
        System.out.println("-----------------------");
        while (p != null) {
            System.out.printf("%5s | %5s | %4s \r\n", p.in4.getCcode(), p.in4.getTcode(), p.in4.getSeat());
            p = p.next;
        }
    }
    
//----------------------------Over-----------------------------------------//  
    
//-----Create new infomations about train, customer and booking------------//
    //Train
    public void createNewTrain() {
        System.out.print("Enter code: ");
        String code;
        while (true) {
            code = sc.nextLine();
            if (findIndex(code)!=-1){
                System.out.println("The code already exit!!");
                System.out.print("Enter again: ");
                continue;
            } else {
                break;
            }
        }
        System.out.print("Enter name of train: ");
        String name = sc.nextLine();
        System.out.print("Enter seat: ");
        int seat = Validation.checkInputSeat();        
        System.out.print("Enter number of booked seats in the train: ");
        int booked = Validation.checkInputBooked(seat);
        System.out.print("Enter depart time: ");
        double departTime = Validation.checkInputDepartTime();
        System.out.print("Enter depart place: ");
        String departPlace = sc.nextLine();
        Train t = new Train(code, name, seat, booked, departTime, departPlace);
        addLastForTrain(t);
    }
    //Customer
    public void createNewCustomer(){
        System.out.print("Enter code: ");
        String code;
        while (true) {
            code = sc.nextLine();
            if (findIndexC(code)!=-1){
                System.out.println("The code already exit!!");
                System.out.print("Enter again: ");
                continue;
            } else {
                break;
            }
        }
        System.out.print("Enter customer's name: ");
        String name = sc.nextLine();
        System.out.print("Enter customer's phone: ");
        String phone = sc.nextLine();
        addLastForCus(new Customer(code, name, phone));       
    }
    // Booking
    public void createNewBooking(){
        System.out.print("Enter train's code: ");
        String tcode;
        while (true) {
            tcode = sc.nextLine();
            if (findIndex(tcode)== -1){
                System.out.println("The code doesn't exit in the train's list!!");
                System.out.print("Enter again: ");
                continue;
            } else {
                break;
            }
        }
        System.out.print("Enter customer's code: ");
        String ccode;
        while (true) {
            ccode = sc.nextLine();
            if (findIndexC(ccode)==-1){
                System.out.println("The code doesn't exit in the customer's list!!");
                System.out.print("Enter again: ");
                continue;
            } else {
                break;
            }
        }
        System.out.print("Enter numbers of seat: ");
        int seat = Validation.checkInputSeat();
        while (true) {
            if (findIndexB(tcode,ccode)!=-1){
                System.out.println("The customer have ID "+ ccode+" aleady booked!");
                System.out.print("Enter again: ");
                return;
            } else {
                break;
            }
        }
        int index = findIndex(tcode);
        int count =0;
        NodeT p = head;
        while(p != null){
            if(index == count){
                if(p.info.availableSeat()==0){
                    System.out.println("The "+ tcode+ " train is full!!");
                    return;
                }
                
                if(p.info.availableSeat() < seat){
                    System.out.println("Empty seat is not enough!!");
                    return;
                }
                else{
                    p.info.setBooked(p.info.getBooked()+seat);
                    break;
                }
            }
            p = p.next;
            count++;
        }
        addLastForBooking(new Booking(tcode, ccode, seat));    
    }
//------------------------------Over--------------------------------//

//--------------------------Load data from file--------------------//
    //Load data from train file
    public void loadTrainFile() throws IOException {
        String currentDir = System.getProperty("user.dir");
        currentDir = currentDir + "\\src\\trainbooking\\TrainFile.txt";
        FileReader fr = new FileReader(currentDir);
        BufferedReader br = new BufferedReader(fr);
        String[] a;
        String s,code, name,departPlace;
        int seat,booked;       
        double departTime;
        while (true) {
            s = br.readLine();
            if (s == null || s.trim().length() < 3) {
                break;
            }
            a = s.split("[|]");
            code = a[0].trim();
            name = a[1].trim();
            seat = Integer.parseInt(a[2].trim());
            booked = Integer.parseInt(a[3].trim());
            departTime = Double.parseDouble(a[4].trim());
            departPlace = a[5].trim();
            addLastForTrain(new Train(code, name, seat, booked, departTime, departPlace));
        }
        fr.close();
        br.close();
    }

    //Load data from customer file
    public void loadCustomerFile() throws IOException { // Using FileReader class
        String currentDir = System.getProperty("user.dir");
        currentDir = currentDir + "\\src\\trainbooking\\CustomerFile.txt";
        FileReader fr = new FileReader(currentDir);
        BufferedReader br = new BufferedReader(fr);      
        String[] a;
        String s,code, name, phone;
        while (true) {
            s = br.readLine();
            if (s == null || s.trim().length() < 3) {
                break;
            }
            a = s.split("[|]");
            code = a[0].trim();
            name = a[1].trim();
            phone = a[2].trim();
            addLastForCus(new Customer(code, name, phone));
        }
        fr.close();
        br.close();
    }
//------------------------------Over---------------------------------//

//----------------------------Save to file---------------------------//
    //Save to train's file
    public void saveTrainFile() throws IOException {
        String currentDir = System.getProperty("user.dir");
        currentDir = currentDir + "\\src\\trainbooking\\TrainFile.txt";
        FileWriter fw = new FileWriter(currentDir);
        PrintWriter pw = new PrintWriter(fw);
        NodeT p = head;
        while (p != null) {
            pw.printf("%5s | %4s  | %3d  | %4d   | %8.2f    | %6s      \r\n", p.info.tcode, p.info.trainName,
                    p.info.seat, p.info.booked, p.info.departTime, p.info.departPlace);
            p = p.next;
        }
        pw.close();
        fw.close();
    }
     //Save to customer's file
    public void saveCustomerFile() throws IOException {
        String currentDir = System.getProperty("user.dir");
        currentDir = currentDir + "\\src\\trainbooking\\CustomerFile.txt";
        FileWriter fw = new FileWriter(currentDir);
        PrintWriter pw = new PrintWriter(fw);
        NodeC p = headC;
        while (p != null) {
            pw.printf("%5s | %5s | %4s\r\n", p.in4.code, p.in4.name, p.in4.phone);
            p = p.next;
        }
        pw.close();
        fw.close();
    }
//--------------------------------Over----------------------------------------//

//-----------------------------Search by code-------------------------------//
    public void searchByTrainCode() {
        System.out.print("Enter train's code: ");
        String code = sc.nextLine();
        NodeT p = head;
        System.out.printf("%5s | %4s  | %3s | %3s | %5s | %3s | %2s\r\n", "Code", "Name", "Seat", "Booked", "Depart Time", "Depart Place", "Available Seat");
        System.out.println("------------------------------------------------------------------------------");
        while (p != null) {
            if (p.info.getTcode().equalsIgnoreCase(code)) {
                System.out.printf("%5s | %4s  | %3d  | %4d   | %8.2f    | %6s       | %6d\r\n", p.info.tcode, p.info.trainName,
                        p.info.seat, p.info.booked, p.info.departTime, p.info.departPlace, p.info.availableSeat());

            }
            p = p.next;
        }
    }
    public void searchByCutomerCode() {
        System.out.print("Enter customer's code");
        String code = sc.nextLine();
        NodeC p = headC;
        System.out.printf("%5s | %5s | %5s \r\n", "Code", "Name", "Phone");
        System.out.println("------------------------------------------------------------------------------");
        while (p != null) {
            if (p.in4.getCode().equalsIgnoreCase(code)) {
                System.out.printf("%5s | %5s | %4s \r\n", p.in4.code, p.in4.name, p.in4.phone);

            }
            p = p.next;
        }
    }
//----------------------------------Over--------------------------------------//
    
//---------------------------Delete by code------------------------------------//
    public void deleteByTrainCode() {
        int index = 0;
        System.out.print("Enter train's code: ");
        String code = sc.nextLine();
        NodeT q = head;
        while (q != null) {
            if (q.info.getTcode().equalsIgnoreCase(code)) {
                break;
            }
            index++;
            q = q.next;
        }
        NodeT p = head;
        int count = 0;
        if (index == 0) {
            head = p.next;
            return;
        }
        while (p != null) {
            if (index - 1 == count) {
                p.next = p.next.next;
                return;
            } else {
                count++;
                p = p.next;
            }
        }
    }
    public void deleteByCustomerCode() {
        int index = 0;
        System.out.print("Enter train's code: ");
        String code = sc.nextLine();
        NodeC q = headC;

        while (q != null) {
            if (q.in4.getCode().equalsIgnoreCase(code)) {
                break;
            }
            index++;
            q = q.next;
        }
        NodeC p = headC;
        int count = 0;
        if (index == 0) {
            headC = p.next;
            return;
        }
        while (p != null) {
            if (index - 1 == count) {
                p.next = p.next.next;
                return;
            } else {
                count++;
                p = p.next;
            }
        }
    }
//----------------------------Over------------------------------------------//
    
//-------------------------Add after position  k----------------------------//
    public void addAfter(){
        System.out.print("Enter code: ");
        String code;
        while (true) {
            code = sc.nextLine();
            if (findIndex(code) != -1) {
                System.out.print("Enter again: ");
                continue;
            } else {
                break;
            }
        }
        System.out.print("Enter name of train: ");
        String name = sc.nextLine();
        System.out.print("Enter seat: ");
        int seat = Validation.checkInputSeat();        
        System.out.print("Enter number of booked seats in the train: ");
        int booked = Validation.checkInputBooked(seat);
        System.out.print("Enter depart time: ");
        double departTime = Validation.checkInputDepartTime();
        System.out.print("Enter depart place: ");
        String departPlace = sc.nextLine();
        Train x = new Train(code, name, seat, booked, departTime, departPlace);
        System.out.print("Enter index: ");
        int index = sc.nextInt();
        NodeT px = new NodeT(x);
        int count =0;
        NodeT p = head;
        while(p!=null){           
            if(index == count){
                px.next= p.next;
                p.next=px;           
                return;
            }
            else{
                count++;
                p = p.next;
            }   
        }       
    }
//---------------------------Over-----------------------------------------------//
    
//------------------Delete the node before the node having tcode = xCode--------//
    public void del(){
        System.out.print("Enter code: ");
        String code;
        while (true) {
            code = sc.nextLine();
            if (findIndex(code) == -1) {
                System.out.println("The code dose not exit!!");
                System.out.print("Enter again: ");
                continue;
            } else {
                break;
            }
        }
        int index = findIndex(code);
        
        System.out.println(index);
        if(index ==0){
            System.out.println("Can not delete, beacause "+code+" is the first element!!");
            return;
        }
        NodeT p = head;
        if(index == 1){
            head = head.next;
            return;
        }
        int count =1;       
        while(p!=null){
            if(index-1 == count ){
                p.next = p.next.next;
                return;
            }else{
                count++;
                p=p.next;
            }
        }       
    }
//------------------------------Over----------------------------------------//
    
//-----------------------Sort by train code----------------------------------//
    public void sortByTrainCode() {
        Train tg;
        NodeT pi=head;
        while(pi!=null){
            NodeT pj=pi.next;
            while(pj!=null){
                if (pi.info.getTcode().compareTo(pj.info.getTcode())>0) {
                    tg=pi.info;
                    pi.info=pj.info;
                    pj.info=tg;
                }
                pj=pj.next;
            }
            pi=pi.next;
        }
    }
//-------------------------Over----------------------------------------------//
    
    
}
