package no.johnsen.fredrik;
import java.util.Scanner;

class Menu {
    private Calendar calendar;

    public Menu(Calendar calendar) {
        this.calendar = calendar;
    }
  
    public static String showMenu() {
        String[] options = {
            "1: Legg inn kalenderinnslag",
            "2: Slett kalenderinnslag",
            "3: Se alle kalenderinnslag",
            "9: Avslutt kalender"
        };
        return String.join("\n", options);
    }
    public String evaluateChoice(int choice) {
        switch (choice) {
            case 1 : 
                return "\nKalenderInnslag. YYYY-mm-dd hh:mm, YYYY-mm-dd hh:mm, Tittel, Decription";
            case 2 :
                return "\nHvilket innslag vil du slette";
            case 3 :
                return "\nOversikt over events\n" + this.calendar.getEvents() ;
            case 9 :
                return "\nAvsluttet";

            default:
                return "\nUgyldig valg";
        }
    }
    public static String changeStuff(int choice, String text ) {
        return "Done";
    }
    public void run() {
        Scanner myInput = new Scanner( System.in );
        int choice = 0;
        while (choice != 9) {
            System.out.println(Menu.showMenu());
            choice = myInput.nextInt();
            System.out.println(this.evaluateChoice(choice));
            String spesify = myInput.next();
            System.out.println(Menu.changeStuff(choice, spesify));
            myInput.next();
            // clearConsole();
        }
        System.out.println(this.calendar);
        myInput.close();
    }
}