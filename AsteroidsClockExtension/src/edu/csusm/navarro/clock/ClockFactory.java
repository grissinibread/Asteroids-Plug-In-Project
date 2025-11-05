package edu.csusm.navarro.clock;

public class ClockFactory implements IClockFactory {

	public ClockFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IClock createClock(int cyclesPerSecond) {
		// TODO Auto-generated method stub
		return new Clock(cyclesPerSecond);
	}

}
