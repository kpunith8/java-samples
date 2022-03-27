package main.com.java.example.oracle;

public class StringSample
{
    public static void main(String[] args)
    {
        byte[] ascii = { 65, 66, 67, 68, 69, 70 }; // Specifies the ASCII byte code for ASCII values
        String s1 = new String(ascii);
        System.out.println(s1);
        String s2 = new String(ascii, 2, 3);
        System.out.println(s2);

        StringBuffer sb = new StringBuffer("Hello");
        sb.ensureCapacity(100);
        // sb.setLength(10); // Call setLength() with a value less than the current value returned by length(), then the
                          // characters stored beyond the new length will be lost. When you increase the size of the
                          // string, null characters are added to the end

        System.out.println("buffer = " + sb.append(" Punith"));
        System.out.println("length = " + sb.length());
        System.out.println("capacity = " + sb.capacity());
    }
}
