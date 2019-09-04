package no.johnsen.fredrik;

import java.util.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

class FileStorage implements Storage {
    private String filepath;
    private List<Event> events;

    public FileStorage(String filepath) {
        this.filepath = filepath;
        this.events = new ArrayList<Event>();
    }
    public List<Event> fetchEvents() {
        ObjectInputStream objectinputstream = null;
        try {
            FileInputStream streamIn = new FileInputStream(filepath);
            objectinputstream = new ObjectInputStream(streamIn);
            List<Event> readCase = (List<Event>) objectinputstream.readObject();
            //this.events.add(readCase);
            this.events = readCase;
            objectinputstream.close();
            System.out.println(this.events.get(0));
        } catch (Exception e) {
            e.printStackTrace();
            //objectinputstream.close();
        } 
        /* finally {
            if (objectinputstream != null){
                objectinputstream.close();
            }
        } */
        return this.events;
    }
        
    public void save(Event event) {
        this.events.add(event);
        this.saveToFile();
    }
    public void delete(Event event) {
        this.events.remove(event);
        this.saveToFile();
    }
    private void saveToFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this.events);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}