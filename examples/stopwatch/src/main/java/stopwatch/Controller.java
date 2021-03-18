package stopwatch;

import stopwatch.MainDialog.EventType;

/**
 * 
 * @author Ronald Tanner, SEMAFOR Informatik & Energie AG
 *
 */
public class Controller implements TimerTask {
    private StopWatch stopWatch;
    private MainDialog dialog;
    private Timer timer;
    
    public Controller( StopWatch stopWatch, MainDialog dialog ){
    	this.stopWatch=stopWatch;
    	this.dialog=dialog;
    	this.timer = new Timer(1000); // interval in ms
    	this.timer.addTask(this); // attach observer to subject
    }

    public void reset(){
    	stopWatch.reset();
        dialog.updateDisplay( stopWatch.getElapsedTime());
    }

	/** stops the timer
	 */
	public void stopTimer() {
		this.timer.stop();
		this.dialog.setButton1Text("Start");
	}
	/** starts the timer
	 */
	public void startTimer() {
		this.timer.start();
		this.dialog.setButton1Text("Stop");		
	}	
	
	/** stops the display
	 */ 
	public void stopUpdate(){
		this.dialog.stopUpdate();
	}
	
	/** reactivates the display
	 */
	public void startUpdate(){
		this.dialog.startUpdate();
	}
	/** increments and displays the elapsed time
	 */ 
	public void tick() {
		stopWatch.incrementTime();
		this.dialog.updateDisplay( stopWatch.getElapsedTime());
	}


}
