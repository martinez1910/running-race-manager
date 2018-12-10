package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Util class for the project (both CLI and GUI).
 * @author Alejandro Martínez Remis
 */
public class MyUtil {
    
    /**
     * For testing purposes only. Can be removed after final implementation.
     * @param message
     */
    public static void unreachableCode(String message) {
        String str = "Unreachable code has been reached";
        if (message != null && message.length() != 0) {
            str += "\n Message: " + message;
        }
        throw new RuntimeException(str);
    }
    
    /**
     * Returns a copy of the object, or null if the object cannot
     * be serialized.
     * @param orig The object to be copied
     * @return The copy of the given object
     */
    public static Object copy(Object orig) {
        Object obj = null;
        try {
            // Write the object out to a byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(orig);
            out.flush();
            out.close();

            // Make an input stream from the byte array and read
            // a copy of the object back in.
            ObjectInputStream in = new ObjectInputStream(
                new ByteArrayInputStream(bos.toByteArray()));
            obj = in.readObject();
        }
        catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
