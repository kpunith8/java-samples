package com.java.example.oracle;

import java.lang.annotation.Annotation;

@Premable(author = "Punith K", date = "09-03-2017", currentRevision = 1, reviewers = {
	"Tejas", "Mukul" })
public class AnnotationSample {
    public static void myClassAnnotations()
    {
        AnnotationSample annotationTest = new AnnotationSample();
        // First, get a Class object that represents
        // this class.
        // Using Reflection to get the annotation details
        Class<?> c = annotationTest.getClass();

        // Now, get a Method object that represents
        // this method.
        // Method m = c.getMethod("myMeth");
        // here myMeth is the method name,

        // Here, the parameter types are specified.
        // Method m = c.getMethod("myMeth", String.class, int.class); // other params String.class and int.class are the
        // params passed to it

        Annotation annos[] = annotationTest.getClass().getAnnotations();
        // Display all annotations for Meta2.
        System.out.println("All annotations for AnnotationSample:");
        for (Annotation a : annos)
            System.out.println(a);

        // Next, get the annotation for this class.
        Premable anno = c.getAnnotation(Premable.class);
        // Finally, display the values.
        System.out.println("Class level anntations" + anno.author() + " " + anno.date());
    }

    public static void main(String[] args)
    {
        myClassAnnotations();
    }
}
