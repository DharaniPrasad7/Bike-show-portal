/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

/**
 *
 * @author dhara
 */
public class MyProject {
String a,b;
    /**
     * @param strNum
     * @return 
     */
 public static boolean isNumeric(String strNum){
            if (strNum == null) {
                return false;
            }
            try {
            int d = Integer.parseInt(strNum);
            }
            catch(NumberFormatException nfe){
            return false;
            }
            return true;
        }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
