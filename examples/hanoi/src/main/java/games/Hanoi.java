/* $Id: Hanoi.java,v 1.1 2003/09/26 06:44:07 tar Exp $
 *                      The Towers of Hanoi 
 *
 * 
 *                      All Rights Reserved.
 *
 * WE DO NOT MAKE ANY REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY
 * OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. WE SHALL NOT BE LIABLE FOR ANY
 * DAMAGES SUFFERED BY USERS AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *
 * Author: Ronald Tanner                   Date: 2001/1/23
 */

package games;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

/* A simple class that implements the tower of hanoi game
   adapted from 
     Borland Pascal for Windows (Sybex)
     Gerd-Uwe Neukamp
*/

public class Hanoi{
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void create() {
    //Make sure we have nice window decorations.
	JFrame.setDefaultLookAndFeelDecorated(true);
	JFrame f = new JFrame( "The Towers of Hanoi" );
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container cp=f.getContentPane();
	cp.setLayout( new BorderLayout() );
	HanoiWindow hw = new HanoiWindow();
	cp.add( hw, BorderLayout.CENTER);
	cp.add( new ActionColumn( hw ), 
		BorderLayout.PAGE_END );
	f.pack();
	f.setVisible( true );
    }
    

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                create();
            }
        });
    }
}
