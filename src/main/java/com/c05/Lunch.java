//: c05:Lunch.java
// Demonstrates class access specifiers.
// Make a class effectively private
// with private constructors:

package com.c05;

class Soup {
    private Soup() {
    }

    // (1) Allow creation via static method;
    public static Soup makeSoup() {
        return new Soup();
    }

    // (2) Create a static object and
    // return a reference upon request
    // (The "Singleton" pattern):
    private static Soup psl = new Soup();

    public static Soup access() {
        return psl;
    }

    public void f() {
    }
}

class Sandwich {
    void f() {
        new Lunch();
    }
}

// Only one public class allowed per file;
public class Lunch {
    void test() {
        // Can't do this! Private constructor:
        // !Soup privl = new Soup();
        Soup priv2 = Soup.makeSoup();
        Sandwich f1 = new Sandwich();
        Soup.access().f();
    }

}
