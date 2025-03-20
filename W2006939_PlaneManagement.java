/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.w2006939_planemanagement;
import java.util.*;

/**
 *
 * @author runningsalad
 */
public class W2006939_PlaneManagement {

    private static int [][] seats;
    
    // Creating an array to store the tickets sold 
    private static Ticket[] tickets;
    private static int ticketSold =0;
    
    // Intialise and creating a multi dimensional array for the plane seats
    private static void seatsInitialised(){
        seats = new int [4][];
        seats [0] = new int [14];
        seats [1] = new int [12];
        seats [2] = new int [12];
        seats [3] = new int [14];
    }
    public static void main(String[] args) {
        System.out.println("Welcome to the Plane Management application");
        seatsInitialised();
        
        // Initialise the tickets array
        tickets = new Ticket[52];
        
        //User will input their option
        Scanner userInput = new Scanner (System.in);
        int user_option;
        
        // Creating the user menu
        do{
            System.out.println("*************************************************");
            System.out.println("*                  MENU OPTIONS                 *");
            System.out.println("*******************★*****************************");
            System.out.println("1) Buy a seat");
            System.out.println("2) Cancel a seat");
            System.out.println("3) Find first available seat");
            System.out.println("4) Show seating plan");
            System.out.println("5) Print tickets information and total sales");
            System.out.println("6) Search ticket");
            System.out.println("0) Quit");
            System.out.println("*************************************************");
            System.out.println("Please select an option: ");
            
            user_option = userInput.nextInt();
            
            switch (user_option){
                case 1:
                    buy_seat();
                    break;
                case 2:
                    cancel_seat();
                    break;
                case 3:
                    int[] findFirstAvailable = find_first_available();
                    if (findFirstAvailable[0]!= -1 && findFirstAvailable[1] != -1){
                        char rowLetter = (char)('A' + findFirstAvailable[0]);
                        System.out.println("The first available seat is in row " + rowLetter + "and seat " + (findFirstAvailable[1]+1));
                }
                    break;
                case 4:
                    show_seating_plan();
                    break;
                case 5:
                    print_tickets_info();
                    break;
                case 6:
                    search_ticket();
                    break;
            }
        } while (user_option != 0);
    }
    
    
    // Creating method buy_seat 
    public static void buy_seat(){
        // Creating a try & catch incase user inputs the alphabet instead of the number that the row corresponds
        boolean row_selection = false;
        while (!row_selection){
        try{
            Scanner input = new Scanner (System.in);
        System.out.println("Please select a row, A = 1, B = 2, C = 3, D = 4: ");
        int row_chosen = input.nextInt();
        switch (row_chosen) {
            case 1:
            case 4:
                {
                    boolean seat_selection = false;
                    while(!seat_selection){
                        System.out.println("Choose your seat number from 1 to 14:");
                        int seat_chosen = input.nextInt();
                        // Have to -1 for both row and seat as index starts from 0
                        if (seat_chosen > 0 && seat_chosen < 15){
                            int row_index = row_chosen - 1;
                            int seat_index = seat_chosen -1;
                           
                            seats[row_index][seat_index] = 'X';
                            row_selection = true;
                            seat_selection = true;
                            // Get users personal info 
                            System.out.println("Enter your name:");
                            String name = input.next();
                            System.out.println("Enter your surname:");
                            String surname = input.next();
                            System.out.println("Enter your email:");
                            String email = input.next();
                                
                            //Calling the price for the ticket through the private method 
                            int price = givenPrice(seat_chosen);
                            
                            //Create person object
                            Person person =new Person(name, surname, email);
                            System.out.println(person.printPersonInfo());        

                            //Create ticket object
                            Ticket ticket = new Ticket(String.valueOf((char)('A'+ row_index)), seat_chosen, price, person);
                            System.out.println(ticket.printTicketInfo());        

                            //Adding the ticket object into the array
                            tickets[ticketSold] = ticket;
                            ticketSold++;
                        }
                        else{
                            System.out.println("Selection incorrect. Please select a seat number again from 1 to 14.");
                        }
                    } break;
                }
            case 2:
            case 3:
                {
                    boolean seat_selection = false;
                    while(!seat_selection){
                    System.out.println("Choose your seat number from 1 to 12:");
                    int seat_chosen = input.nextInt();
                    if (seat_chosen > 0 && seat_chosen < 13){
                        int row_index = row_chosen - 1;
                        int seat_index = seat_chosen -1;
                            
                        seats[row_index][seat_index] = 'X';
                        row_selection = true;
                        seat_selection = true;
                        // Get users personal info 
                        System.out.println("Enter your name:");
                        String name = input.next();
                        System.out.println("Enter your surname:");
                        String surname = input.next();
                        System.out.println("Enter your email:");
                        String email = input.next();
                                
                        //Calling the price for the ticket
                        int price = givenPrice(seat_chosen);
                           
                        //Create person object
                        Person person =new Person(name, surname, email);
                        System.out.println(person.printPersonInfo());        
    
                        //Create ticket object
                        Ticket ticket = new Ticket(String.valueOf((char)('A'+ row_index)), seat_chosen, price, person);
                        System.out.println(ticket.printTicketInfo());        
                        
                        //Adding the ticket object into the array
                        tickets[ticketSold] = ticket;
                        ticketSold++;
                    }
                    else{
                        System.out.println("Selection incorrect. Please select a seat number again from 1 to 12.");
                    }
                } break;
                }
                default:
                    System.out.println("Selection has to be between 1 to 4.");
                    break;
            }
        }catch(InputMismatchException fail){
            System.out.println("Selection has to be between 1 to 4.");
        }
    }
}    
    
    
    
    private static void cancel_seat(){
        // Creating a try & catch incase user inputs the alphabet instead of the number that the row corresponds
        boolean row_cancel = false;
        while (!row_cancel){
        try{
            Scanner input = new Scanner (System.in);
        System.out.println("Please select a row, A = 1, B = 2, C = 3, D = 4: ");
        int row_chosen = input.nextInt();
        switch (row_chosen) {
            case 1:
            case 4:
                {
                    boolean seat_cancel = false;
                    while(!seat_cancel){
                        System.out.println("Choose your seat number from 1 to 14:");
                        int seat_chosen = input.nextInt();
                        // Have to -1 for both row and seat as index starts from 0
                        if (seat_chosen > 0 && seat_chosen < 15){
                            int row_index = row_chosen - 1;
                            int seat_index = seat_chosen -1;
                           
                            if (seats[row_index][seat_index]== 'X'){
                                seats[row_index][seat_index]= 'O';
                                row_cancel = true;
                                seat_cancel = true;
                                
                                // Removing the ticket object after cancelling it 
                                for(int i = 0; i < ticketSold; i++){
                                    Ticket ticket = tickets[i];
                                    if (ticket.getRow().equals(String.valueOf((char)('A'+ row_index))) && ticket.getSeat() == seat_chosen)
                                        for (int j =i; j< ticketSold - 1; j++){
                                            
                                            tickets[--ticketSold] = null;
                                            break;
                                        }
                                        }
                                                                
                            }
                            else{
                                System.out.println("Row and seat selected is already available");
                                break;
                            }
                        }
                        else{
                            System.out.println("Selection incorrect. Please select a seat number again from 1 to 14.");
                        }
                    } break;
                }
            case 2:
            case 3:
                {
                    boolean seat_cancel = false;
                    while(!seat_cancel){
                    System.out.println("Choose your seat number from 1 to 12:");
                    int seat_chosen = input.nextInt();
                    if (seat_chosen > 0 && seat_chosen < 13){
                        int row_index = row_chosen - 1;
                        int seat_index = seat_chosen -1;
                            
                        if (seats[row_index][seat_index]== 'X'){
                            seats[row_index][seat_index]= 'O';
                            row_cancel = true;
                            seat_cancel = true;
                            
                            // Removing the ticket object after cancelling it 
                            for(int i = 0; i < ticketSold; i++){
                                Ticket ticket = tickets[i];
                                if (ticket.getRow().equals(String.valueOf((char)('A'+ row_index))) && ticket.getSeat() == seat_chosen)
                                for (int j =i; j< ticketSold - 1; j++){
                                            
                                            tickets[--ticketSold] = null;
                                            break;
                                        }
                                        }
                        }
                        else{
                            System.out.println("Row and seat selected is already available");
                            break;
                        }
                    }
                    else{
                        System.out.println("Selection incorrect. Please select a seat number again from 1 to 12.");
                    }
                } break;
                }
                default:
                    System.out.println("Selection has to be between 1 to 4.");
                    break;
            }
        }catch(InputMismatchException fail){
            System.out.println("Selection has to be between 1 to 4.");
        }
    }        
}

    
    private static int [] find_first_available(){
        // Making the multi dimensional intialisation default to -1 to show that there are "no seats" availble first
        int [] results = {-1,-1};
        //checking if any of the numbers in the array is available 
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 'O'){
                        return new int[]{i,j};
                    }
        }
    } // if no available seats found the ouput will show {-1,-1}
        return results;
}   
    
    // Creating a method to show the seating plan in output 
    private static void show_seating_plan(){
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                // checking which seat has been bought
                if (seats[i][j] == 'X'){
                    System.out.print('X');
                }
                else{
                    System.out.print("O");
                }
            }
            System.out.println();
        }
    }
    
    // Defining the ticket prices
    private static int givenPrice(int seat_chosen){
        if(seat_chosen >=1 && seat_chosen <= 5){
            return 200;
        } else if (seat_chosen >=6 && seat_chosen <= 9){
            return 150;
        } else {
            return 180;
        }
    }
    
    // Creating a method for user to print ticket info 
    private static void print_tickets_info(){
        int totalAmount = 0;
        
        // Getting the ticket at index 
        for(int i = 0; i< ticketSold; i++ ){
            Ticket ticket = tickets[i];
            System.out.println("Ticket" + (i+1) + ": Row" + ticket.getRow() + ", Seat" +ticket.getSeat());
            
            //Add ticket price to totalprice
            totalAmount += ticket.getPrice();
        }
        System.out.println("Total amount made: £" + totalAmount);
    }
    
    private static void search_ticket(){
        boolean row_selection = false;
        while (!row_selection){
        try{
            Scanner input = new Scanner (System.in);
        System.out.println("Please select a row, A = 1, B = 2, C = 3, D = 4: ");
        int rowChosen = input.nextInt();
        switch (rowChosen) {
            case 1:
            case 4:
                {
                    boolean seat_selection = false;
                    while(!seat_selection){
                        System.out.println("Choose your seat number from 1 to 14: ");
                        int seatChosen = input.nextInt();
                        if (seatChosen > 0 && seatChosen < 15){
                            searchTicket(rowChosen,seatChosen);
                            break;
                        }
                        else{
                            System.out.println("Selection incorrect. Please select a seat number again from 1 to 14.");
                        }
                    } break;
                }
            case 2:
            case 3:
                {
                    boolean seat_selection = false;
                    while(!seat_selection){
                    System.out.println("Choose your seat number from 1 to 12: ");
                    int seatChosen = input.nextInt();
                    if (seatChosen > 0 && seatChosen < 13){
                        searchTicket(rowChosen,seatChosen);
                        break;
                    }
                    else{
                        System.out.println("Selection incorrect. Please select a seat number again from 1 to 12.");
                    }
                } break;
                }
                default:
                    System.out.println("Selection has to be between 1 to 4.");
                    break;
            }
        }catch(InputMismatchException fail){
            System.out.println("Selection has to be between 1 to 4.");
        }
    }
   
}
    
    private static void searchTicket(int rowChosen, int seatChosen){
        // converting to index since I removed this step in search_ticket
        int rowIndex = rowChosen -1;
        int seatIndex = seatChosen -1;
        // Checking to see if the seat is taken
        if (seats[rowIndex][seatIndex] == 'X'){
            for(Ticket ticket: tickets){
                if(ticket != null && ticket.getRow().equals(String.valueOf((char)('A'+ rowIndex))) && ticket.getSeat() == seatChosen){
                    System.out.println("Ticket and personal information: ");
                    System.out.println(ticket.printTicketInfo());
                    break;
                }
            }
    } else{
            System.out.println("The seat is available");
        }
    }
}


