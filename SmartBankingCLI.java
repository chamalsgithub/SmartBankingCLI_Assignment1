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
        
        String[] accHolders = new String[0];
        double[] accBal = new double[0];

        String screen = DASHBOARD;

       
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
                    System.out.println("\t[4]. Exit\n");

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
                        

            }


        } while (true);
    }
}