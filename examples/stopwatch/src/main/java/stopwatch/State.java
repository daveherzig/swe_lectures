package stopwatch;

import stopwatch.MainDialog.EventType;

public interface State {
	public enum StateType { READY, RUNNING, LAP, STOPPED, SUSPENDED };
	
	public State getNext(Controller controller, EventType event);
}
