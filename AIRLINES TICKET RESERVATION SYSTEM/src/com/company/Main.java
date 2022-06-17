package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class airline
{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                    String  search, choice,yn;
                    int to=0, z=0,b=0 ;
                    int availableseat[] = new int[6];
                    int passengernumber[][] = new int[100][3];
                    String nameanddestination[][] = new String[100][3];
                    int passengerprice[][] = new int[100][3];
                    double pay[] = new double[100];
                    double change[] = new double[100];


                 //assign the destinations and prices to string and int array//
                    String dest[] = {"UNITED KINGDOM", "ITALY", "FRANCE", "RUSSIA", "CANADA"};
                    int price[] = {500, 300, 200, 500, 600};


public void destination()
           {

               System.out.println("**********************************************************");
               System.out.println("**      AVAILABLE DESTINATIONS INFORMATION              **");
               System.out.println("**********************************************************");
               System.out.println("**   DESTINATIONS      |  PRICE  |      SEAT            **");
               System.out.println("**********************************************************");
               System.out.println("   1.)UNITED KINGDOM   |   500$  |       " + availableseat[1] );
               System.out.println("   2.)ITALY            |   300$  |       " + availableseat[2] );
               System.out.println("   3.)FRANCE           |   200$  |       " + availableseat[3] );
               System.out.println("   4.)RUSSIA           |   500$  |       " + availableseat[4] );
               System.out.println("   5.)CANADA           |   600$  |       " + availableseat[5] );
               System.out.println("**********************************************************");
               System.out.println("**********************************************************\n");
           }



public void ticketbooking() throws IOException {
                    this.destination();

                    //checking if there is available seat//
              if ((availableseat[1] == 0) && (availableseat[2] == 0) && (availableseat[3] == 0) && (availableseat[4] == 0) && (availableseat[5] == 0)) {
                   System.out.println("Sorry We don't  have available seats for all Destination!");
               }


               else {
                  //inputting of destination Number//
                   System.out.print("\nENTER DESTINATION NUMBER: ");
                   to = Integer.parseInt(in.readLine());

                       if (to < 1 || to > 5) {
                           System.out.println("Invalid Input!");
                           System.exit(0);
                       }

            //if there is no available seat , display error //
                       if (availableseat[to] == 0) {
                           System.out.println("Sorry, We don't have available seat!");
                           System.exit(0);
                       }
           //converted destination to string, transfer to array that we declare it for a storage purpose//
                   nameanddestination[z][1] = dest[to-1];

                  //inputting of Passenger Name//
                   System.out.print("ENTER PASSENGERS NAME: ");
                   nameanddestination[z][0] = in.readLine();

                   //if Passengers Name already used, display error and go back to Inputting//
                   for (int l = 0; l < z; l++) {
                       if (nameanddestination[l][0].equals(nameanddestination[z][0])) {
                           System.out.println("Sorry Passengers name have already used!");
                           System.exit(0);
                       }
                   }

           //inputting for Number of Passengers//
                   System.out.print("HOW MANY PASSENGERS ARE YOU?: ");
                   passengernumber[z][0] = Integer.parseInt(in.readLine());


                   availableseat[to] = availableseat[to] - passengernumber[z][0];
                   if (availableseat[to] < 0) {
                       System.out.print("Sorry We don't have seat available for " + passengernumber[z][0] + " person\n");
                       availableseat[to] = availableseat[to] + passengernumber[z][0];
                       System.out.print("We only have " + availableseat[to] + " seat available\n");
                       System.exit(0);
                   }

          //print out of passengers details

                   System.out.println("\n*************************************");
                   System.out.println("**        PASSENGERS DETAILS        **");
                   System.out.println("***************************************");
                   System.out.println("PASSENGERS NAME: " + nameanddestination[z][0]);
                   System.out.println("PASSENGERS DESTINATION : " + nameanddestination[z][1]);
                   System.out.println("TOTAL PRICE:  " + price[to-1]*passengernumber[z][0]);
                   System.out.println("***************************************");
                   System.out.println("***************************************\n");
                   nameanddestination[z][2] = "0";
                   z++;
               }
           }

public void payment() throws IOException {

               System.out.print("ENTER PASSENGERS NAME: ");
               search = in.readLine();


               int s = 1;

                   if (search.equals(nameanddestination[b][0])) {
                       System.out.println("***************************************");
                       System.out.println("**        PASSENGERS DETAILS        **");
                       System.out.println("***************************************");
                       System.out.println("PASSENGERS NAME:-" + nameanddestination[b][0]);
                       System.out.println("PASSENGERS DESTINATION :- " + nameanddestination[b][1]);
                       System.out.println("PRICE:- " + price[to-1]*passengernumber[b][0]);
                       System.out.println("NUMBER OF PASSENGERS:- " + passengernumber[b][0]);
                       System.out.println("***************************************");
                       System.out.println("***************************************");
                       s = 0;

                           System.out.print("ENTER AMOUNT TO PAY: ");
                           pay[b] = Double.parseDouble(in.readLine());
                           change[b] =price[to-1]*passengernumber[b][0]- pay[b] ;

                           if (change[b] < 0) {
                               System.out.println("Invalid Input!");
                           }
                           else {
                               System.out.println("unpaid balance: " + change[b]);
                               System.out.println("");
                           }
                   }

               if (s == 1) {
                   System.out.println("\nPASSENGERS NAME NOT FOUND!\n");
               }

           }
public void passengerinfo() throws IOException {

               System.out.print("SEARCH PASSENGERS NAME: ");
               search = in.readLine();

               if (search.equalsIgnoreCase(nameanddestination[b][0])) {
                   System.out.println("***************************************");
                   System.out.println("**        PASSENGERS DETAILS         **");
                   System.out.println("***************************************");
                   System.out.println("PASSENGERS NAME: " + nameanddestination[b][0]);
                   System.out.println("PASSENGERS DESTINATION : " + nameanddestination[b][1]);
                   System.out.println("NUMBER OF PASSENGERS: " + passengernumber[b][0]);
                   System.out.println("UNPAID BALANCE: " + change[b]);
                   System.out.println("PAYED BALANCE:  " + pay[b]);

                    if(change[b]!=0)
                    {
                        System.out.println("STATES: NOT COMPLETELY PAID");
                    }
                    else {
                        System.out.println("STATES: COMPLETELY PAID");
                    }
                }

               else{
                   System.out.println("Passenger Name not found!");
               }

           }
}


public class Main extends airline {

public static void main(String[] args) throws IOException {
                airline air = new airline();

         //store 5 seats every for destination 1-5//
                for (int o = 1; o <= 5; o++) {
                    air.availableseat[o] = 5;}


                do {

                    //the MAIN MENU//
                    System.out.println("********************************************");
                    System.out.println("** ETHIOPIA AIRLINE RESERVATION SYSTEM   **");
                    System.out.println("********************************************");
                    System.out.println("** [1] Available destinations             **");
                    System.out.println("** [2] For booking ticket                 **");
                    System.out.println("** [3] For paying bill                    **");
                    System.out.println("** [4] Passenger information              **");
                    System.out.println("** [5] Exit                               **");
                    System.out.println("********************************************");
                    System.out.println("********************************************\n");


                    System.out.print("ENTER CHOICE: ");
                    air.choice = air.in.readLine();
                        switch (air.choice)
                        {
                            case "1":
                                air.destination();
                                break;
                            case "2":
                                air.ticketbooking();
                                break;
                            case "3":
                                air.payment();
                                break;
                            case "4":
                                air.passengerinfo();
                                break;
                            case "5":
                                System.out.println("Thank You!");
                                System.exit(0);
                            default:
                                System.out.println("Invalid Input!");
                                System.exit(0);
                        }
                    System.out.print("Do you want another transaction? press 1 for confirmation:- ");
                    air.yn = air.in.readLine();
                   }while (air.yn.equals("1"));

    }
}