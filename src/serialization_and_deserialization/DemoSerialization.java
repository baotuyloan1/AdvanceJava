package serialization_and_deserialization;

import java.io.*;

/**
 * @author ADMIN
 * 8/2/2023
 */
// Serialization is a mechanism of converting the state of an object into a byte stream.
//   Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory
public class DemoSerialization implements Serializable{

    /**
     * The byte steam is created is platform independent.
     * So the object serialized on platform can be deserialized on a different platform.
     * To made a Java object serializable we implement the Serializable interface
     * Advantages of Serialization
     * <p>
     * To save/persist state of an object.
     * To travel an object across a network.
     * <p>
     * 1. If a parent class has implemented Serializable interface then child class doesn’t need to implement it but (ngược lại)vice-versa is not true.
     * Only non-static data members are saved via Serialization process.
     * <p>
     * . Static data members and transient data members are not saved via Serialization process. So, if you don’t want to save value of a non-static data member then make it transient.
     * Constructor of object is never called when an object is deserialized.
     */

    private int a;
    private String b;


    DemoSerialization(int a, String b) {
        this.a = a;
        this.b = b;
    }


    public static void main(String[] args) {
        DemoSerialization obj = new DemoSerialization(1, "Nguyen Duc Bao");
        String fileName = "file.ser";


        // Serialization
        //Saving of object in a file
        try (FileOutputStream file = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(file)
        ) {


            // Method for serialization of object
            out.writeObject(obj);

            System.out.println("Object has been serialized");

        } catch (IOException e) {
            e.printStackTrace();
        }

        DemoSerialization obj2 = null;

//        Deserialization
        try{
            //reading the object from a file
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
