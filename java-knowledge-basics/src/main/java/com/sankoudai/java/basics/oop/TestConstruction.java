package com.sankoudai.java.basics.oop;

import junit.framework.TestCase;

/**
 * @author : sankoudai
 * @version : created at 2015/8/7
 */
public class TestConstruction extends TestCase{
    /** Order of execution:
         1.load parent class
         2.load child class
         3.run parent constructor
         4.run child constructor
       Concretely:
         1. parent static initializer
         2. parent static block
         3. child static initializer
         4. child static block
         5. parent initializer
         6. parent constructor
         7. child initializer
         8. child constructor

        At second call, class won't be loaded again.
    */
    public void testConstruction(){
        ConstructionChild child = new ConstructionChild();
        System.out.println();
        child = new ConstructionChild();
    }
}

class ConstructionParent{
    public static String staticMarker = "parent static initializer";
    public String attributeMarker = "parent attribute initializer";
    public String inheritationMarker;

    static {
        printStaticMarkers("at beginning of parent static block");
        staticMarker = "parent static block";
        printStaticMarkers("at end of parent static block");
    }

    public ConstructionParent(){
        printMarkers("at beginning of parent constructor");
        attributeMarker = "attribute constructor-init";
        inheritationMarker = "parent constructor-init";
        printMarkers("at end of parent constructor");
    }

    public void printMarkers(String word){
        System.out.printf("--------------- %s ---------------\n", word);
        System.out.println("staticMarker = " + staticMarker);
        System.out.println("attributeMarker=" + attributeMarker);
        System.out.println("inheritationMarker = " + inheritationMarker);
    }

    public static void printStaticMarkers(String word){
        System.out.printf("--------------- %s ---------------\n", word);
        System.out.println("staticMarker = " + staticMarker);
    }
}

class ConstructionChild extends ConstructionParent{
    public String childAttributeMarker = "child attribute initializer";

    static {
        printStaticMarkers("at beginning of child static block");
        staticMarker = "child static block";
        printStaticMarkers("at end of child static block");
    }

    public ConstructionChild(){
        printMarkers("at beginning of child constructor");
        System.out.println("childAttributeMarker = " + childAttributeMarker);
        inheritationMarker = "child constructor-init";
        printMarkers("at end of child constructor");
    }
}
