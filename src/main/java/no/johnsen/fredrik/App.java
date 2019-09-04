package no.johnsen.fredrik;

import java.util.Scanner;
class App {

    public static String menu() {
        String[] options = {
            "1: Legg inn kalenderinnslag",
            "2: Slett kalenderinnslag",
            "3: Se alle kalenderinnslag",
            "9: Avslutt kalender"
        };
        return String.join("\n", options);
    }

    public static void main(String[] args) {
        Scanner myInput = new Scanner( System.in );
        int valueChosen = 0;
        Calendar cal = new Calendar(new FileStorage("saved_events"));
        cal.addEvent(new Event("En", "Ny", "Event", "Er laget"));
        while (valueChosen != 9) {
            System.out.println(menu());
            valueChosen = myInput.nextInt();
        }
        System.out.println(cal);
        myInput.close();
    }

    /* public static void main(String[] args) {
        Calendar cal = new Calendar(new FileStorage("Lol"));
        cal.addEvent(new Event("En", "Ny", "Event", "Er laget"));
        System.out.println(cal);
        CalendarGui gui = new CalendarGui();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("MouseEvent Demo"); // "super" Frame sets title
        gui.setSize(350, 100);           // "super" Frame sets initial size
        gui.setVisible(true);            // "super" Frame shows
    } */
}
