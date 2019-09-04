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
            this.events = readCase;
            objectinputstream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
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
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}