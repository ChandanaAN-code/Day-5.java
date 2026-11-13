import java.util.*;
abstract class Room{
    public int roomno;
    public double pricepernight;
    public boolean isBooked = false;

    public Room(int roomno, double pricepernight) {
        this.roomno = roomno;
        this.pricepernight = pricepernight;
    }

    abstract void isAvailable();
    abstract void showAmenities();
}
class Standardroom extends Room {
    public Standardroom(int roomno, double pricepernight) {
        super(roomno, pricepernight);
    }


    void isAvailable() {
        System.out.println("Standard Room " + this.roomno + ": Yes, Room is available");
    }

 
    void showAmenities() {
        System.out.println("Amenities: Has basic Wi-Fi");
    }
}

class Deluxeroom extends Room {
    public Deluxeroom(int roomno, double pricepernight) {
        super(roomno, pricepernight);
    }

   
    void isAvailable() {
        System.out.println("Deluxe Room " + this.roomno + ": Yes, Room is available");
    }


    void showAmenities() {
        System.out.println("Amenities: Has Balcony, King Bed Size");
    }
}

class Suiteroom extends Room {
    public Suiteroom(int roomno, double pricepernight) {
        super(roomno, pricepernight);
    }
    void isAvailable() {
        System.out.println("Suite Room " + this.roomno + ": Yes, Room is available");
    }
    void showAmenities() {
        System.out.println("Amenities: Multiple rooms, Private pool, Luxury services");
    }
}

// 1. Person Class (Must be outside other classes!)
class Person {
    public String name;
    public String email;
    public long phno;
}
// 3. Staff Class
class Staff extends Person {
    public int empid;
    public String password;

    public Staff(int empid, String sname, long sphno, String password) {
        this.empid = empid;
        this.name = sname;
        this.phno = sphno;
        this.password = password;
    }
}

// 4. Reservation Class
class Reservation {
    public int bookingId;
    public String name;
    public int roomid;
    public String checkindate;
    public String checkoutdate;
    public String bookingstatus;
    public int noofgu;

    public Reservation(int bookingId, String name, int roomid, String checkindate, String checkoutdate, String bookingstatus, int noofgu) {
        this.bookingId = bookingId;
        this.name = name;
        this.roomid = roomid;
        this.checkindate = checkindate;
        this.checkoutdate = checkoutdate;
        this.bookingstatus = bookingstatus;
        this.noofgu = noofgu;
    }
}

// 5. Room Class (Removed 'extends Reservation' to fix Error 2!)
class HotelManagementSystem
{
    public static void main(String args[])
    {
        LinkedHashMap<String ,String> g1=new LinkedHashMap<>();
        ArrayList<Room> roomList = new ArrayList<>();
        ArrayList<Reservation> bookingList = new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        do
        {
        System.out.println("Choose your option:");
        System.out.println("1.Add Guest");
        System.out.println("2.View Guest Details");
        System.out.println("3.Add Room");
        System.out.println("4.View Available rooms");
        System.out.println("5.Book Room");
        System.out.println("6.View Booking Details");
        System.out.println("7.Payment Details");
        System.out.println("8.Exit");
        System.out.println("Enter Your Choice");
        int choice=sc.nextInt();

if (choice == 1) {
    System.out.println("Add New Guest");
    System.out.println("Enter no of guests to add");
    int n=sc.nextInt();
    for (int i=1;i<n;i++)
    {
    sc.nextLine();
    System.out.println("Enter Guest Id:");
    String i1 = sc.nextLine();
    sc.nextLine();
    System.out.println("Enter Guest Name:");
    String n1 = sc.nextLine();

    System.out.println("Enter Email ID:");
    String e = sc.nextLine();

    System.out.println("Enter Mobile Number:");
    String p = sc.nextLine();
    sc.nextLine();

    System.out.println("Enter ID Proof:");
    String ip = sc.nextLine();
    g1.put("GusetId:","i");
    g1.put("Gusetname:","n");
    g1.put("Guset email:","e");
    g1.put("phno:","p");
    g1.put("Id proof:","ip");
    System.out.println("Guest added successfully!");
} 
}
else if (choice == 2) {
    System.out.println("Guest Details:");
    System.out.println(g1);
}
else if (choice == 3) {
                System.out.println("\nSelect Room Type: 1. Standard | 2. Deluxe | 3. Suite");
                int a = sc.nextInt();

                System.out.print("Enter Room No: ");
                int rno = sc.nextInt();

                System.out.print("Enter Price per night: ");
                double ppn = sc.nextDouble();

                if (a == 1) {
                    roomList.add(new Standardroom(rno, ppn));
                    System.out.println("Standard Room added!");
                } else if (a == 2) {
                    roomList.add(new Deluxeroom(rno, ppn));
                    System.out.println("Deluxe Room added!");
                } else if (a == 3) {
                    roomList.add(new Suiteroom(rno, ppn));
                    System.out.println("Suite Room added!");
                } else {
                    System.out.println("Invalid room type.");
                }
            } 

else if(choice==4)
{
    System.out.println("\n--- AVAILABLE ROOMS ---");
    if (roomList.isEmpty()) {
    System.out.println("No rooms added yet.");
    } 
    else {
         for (Room r : roomList) {
                if (!r.isBooked) {
                         r.isAvailable();
                         r.showAmenities();
                    }
                }
        }
} 
else if (choice == 5) {
                System.out.println("\n--- BOOK A ROOM ---");
                System.out.print("Enter Booking ID: ");
                int bid = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Guest Name: ");
                String bname = sc.nextLine();

                System.out.print("Enter Room No to book: ");
                int broomId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Check-in Date (DD-MM-YYYY): ");
                String checkin = sc.nextLine();

                System.out.print("Enter Check-out Date (DD-MM-YYYY): ");
                String checkout = sc.nextLine();

                System.out.print("Enter Number of Guests: ");
                int noOfGuests = sc.nextInt();
                sc.nextLine();
                for (Room r : roomList) {
                    boolean roomFound=false;
                    if (r.roomno == broomId && !r.isBooked) 
                    {
                        r.isBooked = true;
                        roomFound = true;
                        break;
                    }
                   if (roomFound) {
                        Reservation res = new Reservation(bid, bname, broomId, checkin, checkout,  "confirmed",noOfGuests);
                        bookingList.add(res);
                        System.out.println("Room booked successfully!");
                    } 
                    else {
                        System.out.println("Room not found or already booked!");
                    }
                    }

                }
            else if (choice == 6) {
                System.out.println("\n--- VIEW BOOKING DETAILS ---");
                if (bookingList.isEmpty()) {
                    System.out.println("No bookings found.");
                } else {
                    for (Reservation res : bookingList) {
                        System.out.println("Booking ID: " + res.bookingId 
                            + " Guest: " + res.name 
                            + " Room No: " + res.roomid 
                            + " Check-In: " + res.checkindate 
                            + " Check-Out: " + res.checkoutdate 
                            + " Guests: " + res.noofgu 
                            + " Status: " + res.bookingstatus);
                    }
                }
            } 
            else if (choice == 7) {
                System.out.println("\n--- PAYMENT DETAILS ---");
                System.out.print("Enter Booking ID for Payment: ");
                int payBid = sc.nextInt();
                System.out.print("Enter Number of Nights stayed: ");
                int nights = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Payment Method (1.Cash / 2.Card / 3.UPI): ");   
                int s1=sc.nextInt();
                if(s1==1)
                    {
                        System.out.println("Payed through cash");

                    }    
                    else if(s1==2)
                    {
                        System.out.println("Payed through Upi");
                        
                    }    
                    else
                    {
                        System.out.println("Payed through Card");
                        
                    }
                    }    
                else if(choice==8)
                {
                    System.out.println("Thanks for visiting");
                }
        }while(true);
    }
}


