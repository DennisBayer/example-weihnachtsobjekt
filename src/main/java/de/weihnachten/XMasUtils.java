package de.weihnachten;

public class XMasUtils {
   
    public static double getZufallsFliesskommazahl(double ug, double og) {
        double x = (Math.random() * ((og - ug) + 1)) + ug;
        return x;
       
    }
    
    public static int getZufallsGanzzahl(int ug, int og) {
        int x = (int) getZufallsFliesskommazahl(ug, og);
        return x;
    }
    
    public static double getZufallHunger(double ug, double og) {
        double x = ((Math.random() * ((og - ug) + 1)) + ug);
        return x;
    }
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        
    }

}