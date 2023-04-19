import java.util.Scanner;
public class AirlineAhmad {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        boolean[] seatingChart = new boolean[10];
        for(;;)
        {
            System.out.println("Please enter 1 for first class or 2 for economy or press 3 to EXIT");
            int choice = input.nextInt();
            if (choice == 1)
            {
                if (firstClass(seatingChart))
                {
                    if (!Booking(input, seatingChart))
                        System.out.printf("Please Try again%n");
                }
                else
                {
                    System.out.println("First class is full. Would you like to be placed in economy? (y/n)");
                    String answer = input.nextLine();
                    if (answer.equals("y"))
                    {
                        choice =2;
                    }
                    else
                    {
                        System.out.println("Sorry, the plane is full.Next Flight Leaves in 3 hours");
                        break;
                    }
                }
            }
            if (choice == 2)
            {
                if (economy(seatingChart))
                {
                    if (Booking(input, seatingChart))
                        break;
                }
                else
                {
                    System.out.println("Economy is full. Would you like to be placed in first class? (y/n)");
                    String answer = input.nextLine();
                    if (answer.equals("y"))
                       choice=1;
                    else
                    {
                        System.out.println("Sorry, the plane is full, The Next Flight Leaves in 3 hours");
                    }
                }
            }
            if(choice==3)
            {
                System.out.println("Thank you for using our service");
                break;
            }
        }
    }

    private static boolean Booking(Scanner input, boolean[] seatingChart) {
        System.out.printf("Enter Which Seat would you like to Book?%n");
        int seat = input.nextInt();
        if(seatingChart[seat]){
            System.out.printf("Seat is already Booked%n");
        }
        else{
            seatingChart[seat]=true;
            System.out.printf("Seat Booked%n");
            return true;
        }
        return false;
    }

    public static boolean economy(boolean[] seatingChart)
    {
        int countFilledSeats=0;
        for(int i=5;i<seatingChart.length;i++){
            if(seatingChart[i]){
                countFilledSeats++;
            }
            else{
                System.out.printf("Empty Seat Available at %d",i);
            }
        }
        if(countFilledSeats==seatingChart.length-5)
            return false;
        else
            return true;
    }
    public static boolean firstClass(boolean[] seatingChart)
    {
        int countFilledSeats=0;
        for(int i=0;i<5;i++){
            if(seatingChart[i]){
                countFilledSeats++;
            }
            else{
                System.out.printf("Empty Seat Available at %d%n",i);
            }
        }
        if(countFilledSeats==5)
            return false;
        else
            return true;
    }
}
