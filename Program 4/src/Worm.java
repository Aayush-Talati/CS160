/**  Tortoise class
 *    inherits from abstract Racer class
 */

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Worm extends Racer {
    private int speed;
    private Random rand;

    /** Default Constructor: calls Racer default constructor
     */
    public Worm( )
    {
        super( );
        setRandAndSpeed();
    }

    /** Constructor
     *    @param rID  racer Id, passed to Racer constructor
     *    @param rX    x position, passed to Racer constructor
     *    @param rY    y position, passed to Racer constructor
     */
    public Worm( String rID, int rX, int rY )
    {
        super( rID, rX, rY );
        setRandAndSpeed();
    }

    /** move:  calculates the new x position for the racer
     *   Tortoise move characteristics: "slow & steady wins the race"
     *      increment x by 1 most of the time
     */
    public void move( )
    {
        int move =  rand.nextInt( 100 )  + 1;
        if ( move < speed )
            setX( getX( ) + 3 );
    }

    /** draw: draws the Tortoise at current (x, y) coordinate
     *       @param g   Graphics context
     */
    public void draw( Graphics g )
    {
        int startX = getX( );
        int startY = getY( );

        if (this.isWinner) {
            morph(g);
        }
        g.setColor( new Color( 139, 69, 19 ) ); // dark green

        //body
        g.fillRect( startX - 30, startY, 25, 10 );
        g.fillRect(startX - 10, startY - 17, 10, 25);
        g.fillRect(startX - 10, startY - 17, 25, 10);
    }

    private void setRandAndSpeed( ) {
        // percentage of time (between 20% - 40%) that this Worm moves each turn
        rand = new Random( );
        speed = rand.nextInt( 20 ) + 20;
    }
    public void morph(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(this.getX() - 25, this.getY() - 20, 30, 10);
        g.fillRect(this.getX() - 15, this.getY() - 30, 10, 20);
    }

}