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
                    //System.out.println("You have been assigned seat number " + (seatingChart.length - 1));
                }
                else
                {
                    System.out.println("First class is full. Would you like to be placed in economy? (y/n)");
                    String answer = input.nextLine();
                    if (answer.equals("y"))
                    {
                        if (economy(seatingChart))
                        {
                            //System.out.println("You have been assigned seat number " + (seatingChart.length - 1));
                        }
                        else
                        {
                            System.out.println("Sorry, the plane is full.");
                            break;
                        }
                    }
                }
            }
            if (choice == 2)
            {
                if (economy(seatingChart))
                {
                    //System.out.println("You have been assigned seat number " + (seatingChart.length - 1));
                }
                else
                {
                    System.out.println("Economy is full. Would you like to be placed in first class? (y/n)");
                    String answer = input.nextLine();
                    if (answer.equals("y"))
                    {
                        if (firstClass(seatingChart))
                        {
                            //System.out.println("You have been assigned seat number " + (seatingChart.length - 1));
                        }
                        else
                        {
                            System.out.println("Sorry, the plane is full.");
                        }
                    }
                    else
                    {
                        System.out.println("Next flight leaves in 3 hours.");
                    }
                }
            }
            else
            {
                System.out.println("Invalid input. Please enter 1 or 2.");
            }
        }

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
                System.out.printf("Empty Seat Available at %d",i);
            }
        }
        if(countFilledSeats==5)
            return false;
        else
            return true;
    }
}
