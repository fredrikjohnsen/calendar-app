package no.johnsen.fredrik;
import java.util.Scanner;
import java.util.regex.Pattern;

class Menu {
    private Calendar calendar;

    public Menu(Calendar calendar) {
        this.calendar = calendar;
    }
  
    public static String showMenu() {
        String[] options = {
            "\n",
            "0: Vis meny",
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
                return "\nHvilket innslag vil du slette [0-" + this.calendar.getEvents().size() + "]";
            case 3 :
                return "\nOversikt over events\n" + this.calendar.toString() ;
            case 9 :
                return "\nAvsluttet";

            default:
                return "\nUgyldig valg";
        }
    }
    public String changeStuff(int choice, String text ) {
        if (choice == 0) {
            Menu.showMenu();
        }
        if (choice == 1) {
            String[] params = text.split(Pattern.quote(","));
            this.calendar.addEvent(
                new Event(params[0], params[1], params[2], params[3])
            );
            return "\nEvent added";
        }
        if (choice == 2) {
            this.calendar.deleteEvent(this.calendar.getEvents().get( Integer.parseInt(text)));
            return "\nEvent deleted";
        }
        if (choice == 3) {
            return this.calendar.getEvents().toString();
        } else {
            return "Ugyldig valg!";
        }
    }
    public void run() {
        Scanner myInput = new Scanner( System.in );
        Scanner spesify = new Scanner( System.in );
        int choice = 0;
        System.out.println(Menu.showMenu());
        while (choice != 9) {
            choice = myInput.nextInt();
            if (choice != 9) {
                System.out.println(this.evaluateChoice(choice));
                String text = spesify.nextLine();
                System.out.println(this.changeStuff(choice, text));
            }
            System.out.println(Menu.showMenu());
        }
        spesify.close();
        myInput.close();
    }
}