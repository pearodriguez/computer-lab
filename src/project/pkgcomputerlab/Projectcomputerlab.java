/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkgcomputerlab;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author peterrodriguez
 */

public class Projectcomputerlab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String [][] cpuLabs = new String [4][6]; 
        Scanner input = new Scanner(System.in); 
        int option;

        labAssign(cpuLabs); 

        do {
            menu(); 
            System.out.println("Enter: "); 
            option = input.nextInt(); 
            
            switch (option) {
                case 0:
                    System.out.print("Goodbye\n");
                    break;
                case 1:
                    logIn(cpuLabs); 
                    break;
                case 2:
                    logOff(cpuLabs);
                    break;
                case 3:
                    search(cpuLabs); 
                    break;
                default:
                    System.out.print("Error, try again");     
                    break;
            }
        } while (option != 0);

    }
    
    public static void menu () 
    {
        System.out.println("\nMenu" + "\n 0) Quit" + "\n 1) Simulate Login" + 
                            "\n 2) Simulate Logoff" + "\n 3) Search"); 
    }
    
    public static void printLab (String [][] x)
    {
        System.out.println("\nLab # Computer Stations");
        int row = 1; 
        
        for (int i = 0; i < x.length; i++)
        {
            System.out.print(row + "   "); 
            for (int j = 0; j < x[i].length; j++)
            {
               System.out.print(j+1 + ": " + x[i][j] + " ");
            }
            row++; 
            System.out.println(); 
        }
    }
    
       public static void labAssign (String [][] x)
    {
        for (String[] labs : x) {
            for (int j = 0; j < labs.length; j++) {
                labs[j] = "empty"; 
            }
        }
    }
       
    public static void logIn(String [][] x)
    {
        Scanner in = new Scanner (System.in); 
        String iD; 
        int lab, station; 
        
        System.out.println("\nEnter the 5 digit ID of the user logging in: "); 
        iD = in.nextLine(); 
        System.out.println("Enter the lab number the user is logging in from (1-4) : "); 
        lab = in.nextInt(); 
        System.out.println("Enter the computer station the user is logging in to (1-6) : "); 
        station = in.nextInt(); 
        
        x[lab - 1][station - 1] = iD; 
        
        printLab(x); 
    }
       
    public static void logOff(String [][] x) 
    {
        Scanner in = new Scanner (System.in); 
        String [] iD = {" "};   
        
        System.out.println("\nEnter the 5 digit ID of the user logging out: "); 
        iD[0] = in.nextLine(); 
        
        for (int i = 0; i < x.length; i++)
        {
            for (int j = 0; j < x[i].length; j++)
            {
                if (x[i][j] == iD[0]);
                    x[i][j] = "empty"; 
            }
        }
        System.out.println("User " + iD[0] + " is logged off.");
        printLab(x); 
    }
    
    public static void search (String [][] x) 
    {
        Scanner in = new Scanner (System.in); 
        String iD;   
        
        System.out.println("\nEnter the 5 digit ID to search: "); 
        iD = in.nextLine(); 
        
        for(String [] strings: x)
        {
            for(String s: strings)
            {
            if(s.equals(iD))
                System.out.print("\nFound"); 
            
            } 
        }
        // System.out.print("\nNone");
    }
        
    }

