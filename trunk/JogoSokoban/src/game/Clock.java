package game;

import java.util.TimerTask;

/**
 *
 * @author jaspion
 */
public class Clock extends TimerTask {

  int timeLeft;

  public Clock(int maxTime) {
    timeLeft = maxTime;
  }

  public void run() {
	timeLeft--;
  }

  public int getTimeLeft() { return this.timeLeft; }
}
