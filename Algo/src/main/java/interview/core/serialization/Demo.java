package interview.core.serialization;

import java.io.Serializable;

class Demo implements Serializable {
    public int id;                             // Normal field (serialized)

    public SerializableClass serializableClass;
    public transient int tempInt;              // Transient primitive (not serialized)
    public transient String tempString;        // Transient String (not serialized)
    public transient NotSerializableClass tempObj; // Transient object (not serialized)
    public static int staticInt = 42;          // Static field (not serialized)
    public static String staticStr = "static"; // Static String (not serialized)
    public static NotSerializableClass staticObj = new NotSerializableClass("staticObj"); // Static object (not serialized)

    public Demo(int id, int tempInt, String tempString, NotSerializableClass tempObj,SerializableClass serializableClass) {
        this.id = id;
        this.tempInt = tempInt;
        this.tempString = tempString;
        this.tempObj = tempObj;
        this.serializableClass = serializableClass;
    }
}

class NotSerializableClass {
    public String info;
    public NotSerializableClass(String info) { this.info = info; }
}

class SerializableClass implements Serializable{
    public String info;
    public SerializableClass(String info) { this.info = info; }
}
