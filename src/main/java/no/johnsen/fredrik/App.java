package no.johnsen.fredrik;

class App {
    public static void main(String[] args) {
        Calendar cal = new Calendar(new FileStorage("saved_events"));
        Menu menu = new Menu(cal);
        menu.run();
    }
}
