package main.com.java.example.generics;

public class GenericsBasicEx
{
    public static void main(String[] args)
    {
        Generic<Integer> integerObject = new Generic<Integer>(100);

        // Get the value in integerObject. Notice that
        // no cast is needed.
        int intValue = integerObject.getGenericObject();
        System.out.println("Integer value is: " + intValue);
        integerObject.showType();

        Generic<String> stringObject = new Generic<>("Hello Universe");
        String stringValue = stringObject.getGenericObject();
        System.out.println("String value is: " + stringValue);
        stringObject.showType();
    }

    public static class Generic<T>
    {
        T genericObject;

        public Generic(T genericObject)
        {
            this.genericObject = genericObject;
        }

        public T getGenericObject()
        {
            return genericObject;
        }

        void showType()
        {
            System.out.println("Type of T is " + genericObject.getClass().getName());
        }
    }
}
