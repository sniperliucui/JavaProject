package com.c01_c04;// Demonstration of the garbage
// collector and finalization

class Chair{
    static boolean gcrun = false;
    static boolean f = false;
    static int created = 0;
    static int finalized = 0;
    int i;
    Chair(){
        i = ++created;
        if(created==47){
            System.out.println("Created 47");
        }
    }

    public void finalize(){
        if(!gcrun){
            // The first time finallize() is called;
            gcrun = true;
            System.out.println("Beginnig to finalize() after " + created + " Chairs hava been created");
        }
        if(i==47){
            System.out.println("Finalizing com.c01_c04.Chair #47, " + "Setting flag to stop com.c01_c04.Chair creation");
        }
    }
}
public class Garbage {
    public static void main(String[] args) {
        // As long as the flag hasn't been set
        // make Chairs and Strings:
        while(!Chair.f){
            new Chair();
            new String("To take up space");
        }
        System.out.println("After all Chairs have been created:\n"+
                "total created = " + Chair.created +
                ", total finalized = " + Chair.finalized);
        // Optimal arguments force garbage
        // collection & finalization
        if(args.length > 0){
            if(args[0].equals("gc") || args[0].equals("all")){
                System.out.println("gc():");
                System.gc();
            }
            if(args[0].equals("finalize") || args[0].equals("all")){
                System.out.println("runFinalization():");
                System.runFinalization();
            }
        }
        System.out.println("bye!");
    }

}
