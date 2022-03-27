package main.com.java.example.main;

public class StringTest
{
    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();

        // Default capacity of the String Buffer
        System.out.println("StringBuffer's initial capacity: " + sb.capacity());

        sb.append("Hello");

        System.out.println("StringBuffer's capacity after initializg it to Hello: " + sb.capacity());

        // inserts data from position 2
        sb.insert(2, "-LL-");

        // replaces the charcters from position 2 to 6
        sb.replace(2, 6, "");
        sb.append("This is Punith K from Anku City");
        System.out
                .println("StringBuffer's capacity after appending some text {Capacity increased by (capacity*2) + 2}: "
                        + sb.capacity());

        // Measure the time taken to concat a string using String and
        // StringBuffer

        long startTime = System.currentTimeMillis();
        concatWithString();
        System.out.println("Time taken by Concating with String: " + (System.currentTimeMillis() - startTime) + " ms");
        startTime = System.currentTimeMillis();
        concatWithStringBuffer();
        System.out.println("Time taken by Concating with  StringBuffer: " + (System.currentTimeMillis() - startTime)
                + " ms");

        System.out.println("Switch testing: " + testSwitch("A"));

    }

    public static String testSwitch(String test) {
        switch (test)
        {
            case "A":
            case "B":
            case "C":
                return "ABC";
            default:
                return "abc";
        }
    }

    /**
     * concat a string uisng {@code String}.
     * 
     * @return concatenated string.
     */
    public static String concatWithString()
    {
        String t = "Java";
        for (int i = 0; i < 10000; i++)
        {
            t = t + "Tpoint";
        }
        return t;
    }

    /**
     * Concat a string using {@code StringBuffer}
     * 
     * @return Concatenated String
     */
    public static String concatWithStringBuffer()
    {
        StringBuffer sb = new StringBuffer("Java");
        for (int i = 0; i < 10000; i++)
        {
            sb.append("Tpoint");
        }
        return sb.toString();
    }

    // StringBuffer is thread safe while StringBuilder is not, and StringBuilder is more efficient than its counter part
}
