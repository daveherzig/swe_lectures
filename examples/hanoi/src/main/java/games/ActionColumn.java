package games;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

class ActionColumn extends JPanel implements ActionListener {
	    private HanoiWindow hw;
	    private JButton runbutton;
	    private boolean isRunning;

	public ActionColumn( HanoiWindow h ){
			hw=h;
			setLayout( new GridLayout(1,0) );
			JButton button;
			button = new JButton("Reset");
			button.addActionListener(
			    new ActionListener(){
				public void actionPerformed( ActionEvent e ){
				    hw.reset();
				}    
			    });
			add( button );
			runbutton = new JButton("Run");
			runbutton.addActionListener( this );
			add( runbutton );
			isRunning=false;

			button = new JButton("Quit");
			button.addActionListener(
			    new ActionListener(){
				public void actionPerformed( ActionEvent e ){
				    System.exit(0);
				}
			    });
			add( button );
		    }

		    public void actionPerformed( ActionEvent e ){
			if( !isRunning ){
			    isRunning=true;
			    runbutton.setText( "Stop");
			    final SwingWorker worker = new SwingWorker() {
				    public Object construct() {
				    hw.moveDiscs( );
				    return null;
				    }
				};
			    worker.start();
			}
			else{
			    isRunning=false;
			    runbutton.setText( "Run");
			    hw.stop();
			}
		    }
}
