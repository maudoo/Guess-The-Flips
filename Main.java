import java.text.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
    
    final int HEADS=0, TAILS=1; //heads=0, tails=1
    final String YES ="Y", NO ="N";
    DecimalFormat percent =new DecimalFormat("##0%");
    
    Simulation coin = new Simulation();

    boolean playAgain=true;
    while(playAgain){
      int flipCount=0;
      double sum=0;

       Random t = new Random();
       int targetHeadStreak=(t.nextInt(7))+6;
       System.out.println("Your target run is "+ targetHeadStreak +" heads");

 
       Scanner in = new Scanner(System.in);
       System.out.println("What is your guess of how many coin tosses are needed on average to reach that exact target run?");


       while(!in.hasNextDouble() ){
         System.out.println("you did not type an int");
         String garbage= in.next();
       }
       double yourGuess = in.nextDouble();
      
      for(int i=1; i<=1000;i++){
          int headStreak=0;

        
          while(headStreak<targetHeadStreak){
            int randomValue = coin.flip();
            flipCount++;

            if(randomValue==HEADS){
              headStreak++;
            }

            else {
              headStreak=0;
            }  

          }
          sum+=flipCount;
          flipCount=0;
        }



        double average= sum/1000;

        if(yourGuess<average){
          double guess =1-(yourGuess/average);
          System.out.println("On average, "+average+" flips were needed. You were off by " +percent.format(guess));
        }

        else if(yourGuess>average){
          double guess = (yourGuess/average)-1;
          System.out.println("On average, "+average+" flips were needed. You were off by " +percent.format(guess));

        }

      System.out.println("Do you want to play again (Y=yes, N=no)?");
     

      boolean valid = false;

      while (!valid) {
          System.out.println("Please enter Y or N");
          String input = in.next();

          if (!(input.equals(NO) || input.equals(YES))) {
            continue;
          }

          if (input.equals(NO)) {
              playAgain = false;
          } else if (input.equals(YES)) {
              playAgain = true;
          }

          valid = true;
      }
    }
  }
}