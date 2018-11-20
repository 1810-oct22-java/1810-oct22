package com.revature.examples;

import java.util.Scanner;

public class PacMan {
	 /* This program creates a PacMan grid with randomly 
	 * located cookies. It prompts user for row and column number of the grid
	 * as well as menu options, that control the PacMan's movement, 
	 * menu display and game exit. 
	 * 
	 * Pre-condition: 
	 * The PacMan grid is 2D char array. 
	 * User input for rows(X) and col(Y) as String. 
     * Cookies are randomly placed and takes up 8% of the grid.
	 *
	 * Post-condition: 
	 * A character array with '.' representing positions
	 * and 'O' representing cookies.
	 * A main menu with selection options that allows user to 
	 * to choose from by selecting 1, 2, 3, 4 or 5 
	 */

	  // Static shares grid array with other objects
    static char[][] grid; 
    static char pac; // Current pacman
    static char pacRow; // Pacman's row at specified point
    static char pacCol; // Pacman's col at specified point
    static int totalCookies; 
    static double eaten; // Double because want end stat to be double
    static double moves; 
    
    static Scanner scanner = new Scanner(System.in); 
    
    public static void main(String[] args)
    {
        newPacManGrid(); 
    }
    
   
    static void newPacManGrid()
    {
        System.out.println("Please input the number of rows(X) on your grid: ");
        String row = scanner.nextLine();
        System.out.println("Please input the number of column(Y) on your grid: ");
        String col = scanner.nextLine();
        
        // In case user input strings
        int r = Integer.parseInt(row);
        int c = Integer.parseInt(col);
        
        // Initialize new 2D grid using array of char
        grid = new char[r][c];
        
        int totalPosition = r * c; // Gives all the spaces in the grid
        
        // Calculate total cookies
        int totalCookies = (int) (totalPosition * 0.08);
        
        /************************
         *  Dot grid assignment
         ************************/
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j ++) 
            {
                grid[i][j] = '.';
            }
        }
        
        /**************************
         * Cookies grid assignment
         **************************/
        while(totalCookies > 0)
        {
            int randomNumber = (int)(totalPosition * Math.random()); 
            int on_col = (randomNumber % c); // Mod = column
            int on_row = (int) randomNumber / c; // Int div drops remainder
            
            if(on_row !=0 && on_col != 0 && grid[on_row][on_col] != 'O')
            {
                grid[on_row][on_col] = 'O';
                totalCookies --; 
            }
        }
        
        /*******************
         * Starting Pac Man
         *******************/
        grid[0][0] = '>'; 
        
        /****************************
         * Sets everything in motion
         ****************************/
        action(); // Prints grid, print menu & takes in selections
        
        scanner.close();
    } 
    
    /****************************************
     * Printing assignment of '.' and '0' on
     * via a space " "
     ****************************************/
    static void printGrid()
    {
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                System.out.print(grid[i][j]+ " ");
            }
            System.out.println(""); // Every complete row, start new line
        }  
        
        printMenu(); // So menu appears after every printGrid call 
    }

    /***********************
     * Printing the Menu
     ***********************/
    static void printMenu() 
    {
        System.out.println("");
        System.out.println("Main menu: \n"
                + "1. View Menu \n"
                + "2. Turn Left \n"
                + "3. Turn Right \n"
                + "4. Move \n"
                + "5. Exit\n"
                + "\n Command: ");      
    }
   
    /*****************************
     * Pac Man's action recursion 
     *****************************/
    static void action()
    {
        printGrid(); // Print grid before the action 
        String menuNum = scanner.nextLine(); 
        //System.out.println ("Command: ");
        int n = Integer.parseInt(menuNum); // Options for Integer
        char pac = grid[pacRow][pacCol];
        
        switch(n)
        {
            case 1:
                // Reruns this object action() and allow user to 
                // input their choice again
                action(); // Here, printGrid first, which also prints menu
                break; 
            case 2: 
                turnLeft(pac);
                action(); 
                break; 
            case 3:
                turnRight(pac);
                action(); 
                break; 
            case 4: 
                move(pac);
                action(); 
                break; 
            case 5: 
                endGame();
                break;
            default:
                System.out.println("Invalid selection. "
                        + "Please review options in the menu again.");
                action();
                break; 
        }
    }
    
   /************************
    * Turn Left
    ************************/
    static void turnLeft(char pac)
    {
        switch(pac)
        {
        case 'V': 
            grid[pacRow][pacCol] = '>';
            moves ++; 
            break; 
        case '<': 
            grid[pacRow][pacCol] = 'V';
            moves ++; 
            break; 
        case '^': 
            grid[pacRow][pacCol] = '<';
            moves ++; 
            break; 
        case '>': 
            grid[pacRow][pacCol] = '^';
            moves ++; 
            break; 
        }
    }
   
   
   /************************
    * Turn Right
    ************************/
    static void turnRight(char pac)
    {
        switch(pac)
        {
        case 'V': 
            grid[pacRow][pacCol] = '<';
            moves ++; 
            break; 
        case '<': 
            grid[pacRow][pacCol] = '^';
            moves ++; 
            break; 
        case '^': 
            grid[pacRow][pacCol] = '>';
            moves ++; 
            break; 
        case '>': 
            grid[pacRow][pacCol] = 'V';
            moves ++; 
            break; 
        }
    }
   
   
   /************************
    * Moving (forward)
    ************************/
    static void move(char pac)
    {
        switch(pac)
        {
        case 'V':
            if (pacRow == 0)
            {
                System.out.println("*~Ooooops you can't go off the grid!~*");
            }
            else
            {
                moves ++; 
                grid[pacRow][pacCol] = ' '; // Assign old spot with ' '
                pacRow -- ; // Go up(north) a row
                if( grid[pacRow][pacCol] == 'O') // NEW position has cookie
                {
                    eaten ++; 
                    System.out.println("Yum yum! " + (int) eaten 
                           + " cookies eaten.");
                }
                grid[pacRow][pacCol] = 'V'; // Assign new position 
            }
            break; 
           
       case '<':
            if (pacCol == grid[pacRow].length -1) // Second to last col 
            {
                System.out.println("*~Ooooops you can't go off the grid!~*");
            }
            else
            {
                moves ++;
                grid[pacRow][pacCol] = ' '; // Assign old spot with ' '
                pacCol ++ ; // Go up(north) a row 
                if( grid[pacRow][pacCol] == 'O') // NEW position has cookie
                {
                    eaten ++; 
                    System.out.println("Yum yum! " + (int) eaten 
                           + " cookies eaten.");
                }
                grid[pacRow][pacCol] = '<'; // Assign new position 
            }
            break; 
           
        case '^':
            if (pacRow == grid.length - 1) // Second to last col 
            {
                System.out.println("*~Ooooops you can't go off the grid!~*");
            }
            else
            {
                grid[pacRow][pacCol] = ' '; // Assign old spot with ' '
                pacRow ++ ; // Go up(north) a row
                moves ++; 
                if( grid[pacRow][pacCol] == 'O') // NEW position has cookie
                {
                    eaten ++; 
                    System.out.println("Yum yum! " + (int) eaten 
                           + " cookies eaten.");
                }
                grid[pacRow][pacCol] = '^'; // Assign new position 
            }
            break; 
  
        case '>':
            if (pacCol == 0) // Second to last col 
            {
                System.out.println("*~Ooooops you can't go off the grid!~*");
            }
            else
            {
                grid[pacRow][pacCol] = ' '; // Assign old spot with ' '
                pacCol -- ; // Go up(north) a row
                moves ++; 
                if( grid[pacRow][pacCol] == 'O') // NEW position has cookie
                {
                    eaten ++; 
                    System.out.println("Yum yum! " + (int) eaten 
                           + " cookies eaten.");
                }
                grid[pacRow][pacCol] = '>'; // Assign new position 
            }
            break;         
        }
    }
   
   /**********************
    * Exit option 
    * No more . and O automatically exit?
    **********************/
    static void endGame()
    {
        double avg; 
        if(moves == 0)
        {
            avg = 0;
        }
        else
        {
            avg = moves/eaten; 
        }
       

    System.out.println("\n ******* THANKS FOR PLAYING *******"
               + "\n ~ Total cookies eaten: " + (int) eaten
               + "\n ~ Total commands/moves made: " + (int) moves
               + "\n ~ Average moves per cookies: " + avg
               + "\n ******* See you next time! *******");
    }

}
