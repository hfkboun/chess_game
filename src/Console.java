import java.util.Scanner;
import java.lang.System;
public class Console {
    /**
     * Console Class
     * 
     * 
     * 
     */
     
    
    
    public static void main(String[] args) {
        Board board = new Board();
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Shall we begin? \n[Y]es or [N]o");
        String input = reader.next();
        if (input.toLowerCase().startsWith("n")) System.exit(0);
        board.display();


        // while true
        // sira beyazda/siyahta
        // input al
        // board.move()
        // board.display()
       
    }
}