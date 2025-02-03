/**  Tortoise class
 *    inherits from abstract Racer class
 */

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Bird extends Racer {
    private int speed;
    private Random rand;

    /** Default Constructor: calls Racer default constructor
     */
    public Bird( )
    {
        super( );
        setRandAndSpeed();
    }

    /** Constructor
     *    @param rID  racer Id, passed to Racer constructor
     *    @param rX    x position, passed to Racer constructor
     *    @param rY    y position, passed to Racer constructor
     */
    public Bird( String rID, int rX, int rY )
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
            setX( getX( ) + 5 );
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
        g.setColor(Color.RED);

        g.fillOval(startX - 30, startY, 40, 20);
        g.setColor(Color.BLACK);
        g.fillOval(startX - 7, startY + 5, 5, 5);
        g.setColor(Color.ORANGE);
        g.fillRect(startX, startY + 7, 20, 5);
    }

    private void setRandAndSpeed( ) {
        // percentage of time (between 10% - 30%) that this Worm moves each turn
        rand = new Random( );
        speed = rand.nextInt( 20 ) + 10;
    }
    public void morph(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(this.getX() - 30, this.getY() - 2, 30, 5);
        g.fillRect(this.getX() - 20, this.getY() - 12, 10, 20);
    }
}