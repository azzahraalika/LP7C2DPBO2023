/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchronization;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Satria Ramadhani
 */
public class Controller extends KeyAdapter implements KeyListener
{
    /**
     * Attribute declaration.
     */
    
    private int klik = 0;
    private Game game;
    private Handler handler;
    
    /**
     * Constructor.
     */
    
    // Default constructor.
    public Controller()
    {
        this.game = new Game();
        this.handler = new Handler();
    }
    
    // Constructor with controller data.
    public Controller(Game game, Handler handler)
    {
        this.game = game;
        this.handler = handler;
    }
    
    /**
     * Getter and Setter.
     */

    /* Controller's game. */
    
    public Game getGame()
    {
        return game;
    }

    public void setGame(Game game)
    {
        this.game = game;
    }

    /* Controller's handler. */
    
    public Handler getHandler()
    {
        return handler;
    }

    public void setHandler(Handler handler)
    {
        this.handler = handler;
    }
    
    /**
     * Public methods.
     */
    
    // Override trait when key is pressed.
    @Override
    public synchronized void keyPressed(KeyEvent e)
    {
        System.out.println("Pressed");
        
        // Get key code (what key that pressed?).
        int key = e.getKeyCode();
        if(game.isRunning())
        {
            // Searching for player object.
            int i = 0; boolean found = false;
            while((found == false) && (i < handler.count()))
            {
                if(handler.get(i).getType().equals("Player"))
                {
                    found = true;
                }
                else
                {
                    i++;
                }
            }
            
            // Set the object and do the handling.
            GameObject temp = handler.get(i);
            if((key == KeyEvent.VK_W) || (key == KeyEvent.VK_UP))
            {
                // Move up.
                temp.setVelY(-5);
            }
            if((key == KeyEvent.VK_A) || (key == KeyEvent.VK_LEFT))
            {
                // Move left.
                temp.setVelX(-5);
            }
            if((key == KeyEvent.VK_S) || (key == KeyEvent.VK_DOWN))
            {
                // Move down.
                temp.setVelY(+5);
            }
            if((key == KeyEvent.VK_D) || (key == KeyEvent.VK_RIGHT))
            {
                // Move right.
                temp.setVelX(+5);               
            }
        }
    }
    
    // Override trait when key is released from being pressed.
    @Override
    public synchronized void keyReleased(KeyEvent e)
    {
        System.out.println("Released");
        
        // Get key code (what key that released?).
        int key = e.getKeyCode();
        if(game.isRunning())
        {
            // Searching for player object.
            int i = 0; boolean found = false;
            while((found == false) && (i < handler.count()))
            {
                if(handler.get(i).getType() == "Player")
                {
                    found = true;
                }
                else
                {
                    i++;
                }
            }
            
            // Set the object and do the handling.
            GameObject temp = handler.get(i);            
            
            // kalo misal pencet spasi dia bakal nutup program
            if(key == KeyEvent.VK_SPACE)
            {
                // Close the game.
                game.setRunning(false);
                game.close();
            }
            if((key == KeyEvent.VK_W) || (key == KeyEvent.VK_UP))
            {
                // Stop from being moved up.
                temp.setVelY(0);
                
                // kalo si kuncinya bukan W dan UP atau kalo user masi klik key yg sama 
                // dia ga bakal nambah score. 
                // tapi kalo misal dia klik key yg beda maka score bakal nambah 1 
                // kalo user pindah key atau released. 
                if((this.klik != KeyEvent.VK_W) && (this.klik != KeyEvent.VK_UP)){
                    // manggil score yang ada di game 
                    game.score += 1;
                }
            }
            if((key == KeyEvent.VK_A) || (key == KeyEvent.VK_LEFT))
            {
                // Stop from being moved left.
                temp.setVelX(0);
                
                // kalo si kuncinya bukan A dan LEFT atau kalo user masi klik key yg sama 
                // dia ga bakal nambah score. 
                // tapi kalo misal dia klik key yg beda maka score bakal nambah 1 
                // kalo user pindah key atau released. 
                if((this.klik != KeyEvent.VK_A) && (this.klik != KeyEvent.VK_LEFT)){
                    // manggil score yang ada di game
                    game.score += 1;
                }
            }
            if((key == KeyEvent.VK_S) || (key == KeyEvent.VK_DOWN))
            {
                // Stop from being moved down.
                temp.setVelY(0);
                
                // kalo si kuncinya bukan S dan DOWN atau kalo user masi klik key yg sama 
                // dia ga bakal nambah score. 
                // tapi kalo misal dia klik key yg beda maka score bakal nambah 1 
                // kalo user pindah key atau released. 
                if((this.klik != KeyEvent.VK_S) && (this.klik != KeyEvent.VK_DOWN)){
                    // manggil score yang ada di game
                    game.score += 1;
                }
            }
            if((key == KeyEvent.VK_D) || (key == KeyEvent.VK_RIGHT))
            {
                // Stop from being moved right.
                temp.setVelX(0);
                
                // kalo si kuncinya bukan D dan RIGHT atau kalo user masi klik key yg sama 
                // dia ga bakal nambah score. 
                // tapi kalo misal dia klik key yg beda maka score bakal nambah 1 
                // kalo user pindah key atau released. 
                if((this.klik != KeyEvent.VK_D) && (this.klik != KeyEvent.VK_RIGHT)){
                    // manggil score yang ada di game
                    game.score += 1;
                }
            }
            
            //inisialisasi kalo yg user klik sekarang itu adalah key yg sekarang
            this.klik = key;
        }
    }
}
