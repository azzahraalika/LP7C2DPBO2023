/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package synchronization;

import java.awt.Graphics;

/**
 *
 * @author Satria Ramadhani
 */
public interface GameInterface
{
    public void render(Graphics object);  // Render object. buat nampilin apa yg ada di kodingan ke layar
    public void loop();    // Loop / refresh object. logika setiap objek 
}
