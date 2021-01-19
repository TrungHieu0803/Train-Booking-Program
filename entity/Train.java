package entity;



public class Train implements Comparable<Train>{
    public String tcode;
    public String trainName;
    public int seat;
    public int booked;
    public double departTime;
    public String departPlace;

    public Train() {}

    public Train(String tcode, String trainName, int seat, int booked, double departTime, String departPlace) {
        this.tcode = tcode;
        this.trainName = trainName;
        this.seat = seat;
        this.booked = booked;
        this.departTime = departTime;
        this.departPlace = departPlace;
       
    }

    public String getTcode() {
        return tcode;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public double getDepartTime() {
        return departTime;
    }

    public void setDepartTime(double departTime) {
        this.departTime = departTime;
    }

    public String getDepartPlace() {
        return departPlace;
    }

    public void setDepartPlace(String departPlace) {
        this.departPlace = departPlace;
    }
    public int availableSeat(){
        return seat -booked;
    }

    @Override
    public int compareTo(Train o) {
        return tcode.compareTo(o.tcode);
    }
    
    
  
  
}
