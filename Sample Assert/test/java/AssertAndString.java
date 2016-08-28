/**
 * Created by ACHU on 24/08/2016.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AssertAndString {

    @Test
    public void examplemethod(){
        assertEquals("123456769", "17" + "29" + "76");
    }

    @Test
    public void someStringMethods(){
        String aString = "abcd";

        assertEquals(6, aString.length());
        assertTrue(aString.compareToIgnoreCase("ABCD")==0);
        assertTrue(aString.contains("bcd"));
        assertTrue(aString.startsWith("abc"));

        // string indexing starts at 0
        assertEquals('c', aString.charAt(1));
        assertEquals("bc", aString.substring(3));
    }
}
