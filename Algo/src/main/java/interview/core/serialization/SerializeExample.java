package interview.core.serialization;

import java.io.*;

public class SerializeExample {
    public static void main(String[] args) {
        Demo.staticInt = 1234;
        Demo.staticStr = "changed";
        Demo.staticObj = new NotSerializableClass("static changed");

        Demo obj = new Demo(11, 222, "secret", new NotSerializableClass("not serializable"), new SerializableClass("Serializable class"));
        String filename = "demo.ser";

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(obj);
            System.out.println("Serialization done");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Change static and transient fields after serialization
        Demo.staticInt = 9999;
        Demo.staticStr = "after serialization";
        Demo.staticObj = new NotSerializableClass("after serialization");
        obj.tempInt = 888;
        obj.tempString = "changed after serialization";
        obj.tempObj = new NotSerializableClass("object after serialization");

        // Deserialization
        Demo deserialized = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            deserialized = (Demo) ois.readObject();
            System.out.println("Deserialization done");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Output
        System.out.println("id = " + deserialized.id);                              // 11 (serialized)
        System.out.println("Serializable = " + deserialized.serializableClass.info);// Serializable class
        System.out.println("tempInt = " + deserialized.tempInt);                    // 0  (default int, transient)
        System.out.println("tempString = " + deserialized.tempString);              // null (transient)
        System.out.println("tempObj = " + deserialized.tempObj);                    // null (transient)
        System.out.println("staticInt = " + Demo.staticInt);                        // 9999 (current JVM value)
        System.out.println("staticStr = " + Demo.staticStr);                        // "after serialization" (current JVM value)
        System.out.println("staticObj = " + (Demo.staticObj != null ? Demo.staticObj.info : null)); // "after serialization"

    }
}
