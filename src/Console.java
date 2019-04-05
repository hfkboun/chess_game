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
                
        try {
            board.move(board.white, "knight1", new Location(2, 2));
            board.movePawn(board.black, "pawn1", new Location(0, 5));
            // board.move(board.white, "knight1", new Location(1, 0));
            // board.movePawn(board.white, "pawn1", new Location(0, 3));
        }
        
        catch (Exception e){
        
            System.out.println(e.toString());
        
        }
        
        board.display();

        // while true
        // sira beyazda/siyahta
        // input al
        // board.move()
        // board.display()
       
    }
}