import java.util.Arrays;
import java.util.Scanner;

public class SmartBankingCLI{
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String COLOR_GREEN_BOLD = "\033[33;1m";
        final String RESET = "\033[0m";

        final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
        final String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);

        final String DASHBOARD = "\u25B6 \u25B9 Welcome to Smart Banking \u25B9 \u25B6    ";
        final String CREATE_ACC = "➕ Create New Account \u25B9 \u25B6 ";
        final String DEPOSITS = " ⏬ Deposit \u25B9 \u25B6 ";
        final String WITHDRAWALS = "⏫ Withdraw \u25B9 \u25B6 ";
        final String TRANSFER = "🔁 Trasfer \u25B9 \u25B6 ";
        final String PRINT_STATEMENT = "🖨 Bank Statement \u25B9 \u25B6 ";
        final String DELETE_ACC = " ␡ Delete Account \u25B9 \u25B6 ";
        
        String[] accId = new String[0];
        String[] accHolders = new String[0];
        double[] accBal = new double[0];

        String screen = DASHBOARD;
        int idLast=0;
       
        do {

            final String APP_TITLE = String.format("%s%s%s",
                                COLOR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
           
            System.out.println("\t" + APP_TITLE + "\n");
            
            switch(screen){
                //Dashboard View
                case DASHBOARD:
                    System.out.println("\t[1]. Create New Account");
                    System.out.println("\t[2]. Deposits");
                    System.out.println("\t[3]. Withdrawals");
                    System.out.println("\t[4]. Transfer");
                    System.out.println("\t[5]. Print Statement");
                    System.out.println("\t[6]. Delete Account");
                    System.out.println("\t[7]. Exit\n");

                    System.out.print("\tEnter an option to continue: ");
                    int option = SCANNER.nextInt();
                    SCANNER.nextLine();

                    switch (option){ 
                        
                        case 1: screen = CREATE_ACC; break;
                        case 2: screen = DEPOSITS; break;
                        case 3: screen = WITHDRAWALS; break;
                        case 4: screen = TRANSFER; break;
                        case 5: screen = PRINT_STATEMENT; break;
                        case 6: screen = DELETE_ACC; break;
                        case 7: System.out.println(CLEAR); System.exit(0);
                        default: continue;}
                        break;
                
                //Create Account        
                case CREATE_ACC :
                    boolean valid = true;
                    String id;
                    String name;
                    double balance=0; 
                    
                      
            
                    
                    loop1: 
                    do{

                        // Generate auto ID & store in temp var.
                        id = String.format("SDB-%05d", (idLast + 1));
                        System.out.print("\tID :"+id+ "\n");

                        // Get name and store in temp var.
                        valid = true;
                        System.out.print("\tName: ");
                        name = SCANNER.nextLine().strip();

                        

                        if (name.isBlank()){  //Check whether the name is empty
                            System.out.printf(ERROR_MSG, "Name can't be empty");
                            valid = false;
                            continue loop1;
                        }

                        for (int i = 0; i < name.length(); i++) { // check A-Z a-z spaces invalidity
                            if (!(Character.isLetter(name.charAt(i)) || 
                                Character.isSpaceChar(name.charAt(i))) ) {
                                System.out.printf(ERROR_MSG, "Invalid Name");
                                valid = false;
                                continue loop1;
                            }

                        }
                        
                        loop2: 
                        do { // Get initial deposit and store in temp var.
                            System.out.print("\tInitial Deposit : ");
                            balance = SCANNER.nextDouble();
                            SCANNER.nextLine();
                            valid=true;


                            if (balance<5000){  //Check whether the initial Deposit is higher than 5000/= 
                                System.out.printf(ERROR_MSG, "Insufficient initial deposit"); 
                                valid = false;
                                continue loop2;
                            }
                            
                        } while (!valid);

                    ///// Save acc holder id from temp var. to accId Array
                    String[] newAccId= new String[accId.length + 1];
                    for (int i = 0; i < accId.length; i++) {
                        newAccId[i] = accId[i];
                    }
                    newAccId[newAccId.length -1] = id;
                    accId = newAccId;

                    ///// Save acc holder name from temp var. to accHolders Array
                    String[] newAccHolders = new String[accHolders.length + 1];
                    for (int i = 0; i < accHolders.length; i++) {
                        newAccHolders[i] = accHolders[i];
                    }
                    newAccHolders[newAccHolders.length -1] = name;
                    accHolders = newAccHolders;

                    ///// Save acc holder's initial deposit amount from temp var. to accBal Array
                    double [] newAccBal = new double[accBal.length + 1];
                    for (int i = 0; i < accBal.length; i++) {
                        newAccBal[i] = accBal[i];
                    }
                    newAccBal[newAccBal.length -1] = balance;
                    accBal = newAccBal;

                    idLast++;
                    //Re-enter or Return to the dashboard
                    System.out.println();
                    System.out.printf("\tID: %s %s has been created successfully.\n\tDo you want to add another (Y/n)? ", id,name);
                    if (SCANNER.nextLine().strip().toUpperCase().equals("Y")) continue;
                    screen = DASHBOARD;
                        
                                                
                    }while(!valid);
                    
                    break;
                
                //Deposit        
                case DEPOSITS :

                //Withdrawals       
                case WITHDRAWALS :

                //Transfer       
                case TRANSFER :

                //Print Statement      
                case PRINT_STATEMENT :

                //Delete Account        
                case DELETE_ACC :

                                       

            }


        } while (true);
    }
}