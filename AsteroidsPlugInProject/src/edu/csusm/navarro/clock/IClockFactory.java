package edu.csusm.navarro.clock;

public interface IClockFactory {
	IClock createClock(int framesPerSecond);
}