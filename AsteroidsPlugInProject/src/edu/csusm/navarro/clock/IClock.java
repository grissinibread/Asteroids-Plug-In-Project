package edu.csusm.navarro.clock;

public interface IClock {
	/**
	 * Sets the number of cycles that elapse per second.
	 * @param cyclesPerSecond The number of cycles per second.
	 */
	public void setCyclesPerSecond(float cyclesPerSecond);
	
	/**
	 * Resets the clock stats. Elapsed cycles and cycle excess will be reset
	 * to 0, the last update time will be reset to the current time, and the
	 * paused flag will be set to false.
	 */
	public void reset();
	
	/**
	 * Updates the clock stats. The number of elapsed cycles, as well as the
	 * cycle excess will be calculated only if the clock is not paused. This
	 * method should be called every frame even when paused to prevent any
	 * nasty surprises with the delta time.
	 */
	public void update();
	
	/**
	 * Pauses or unpauses the clock. While paused, a clock will not update
	 * elapsed cycles or cycle excess, though the {@code update} method should
	 * still be called every frame to prevent issues.
	 * @param paused Whether or not to pause this clock.
	 */
	public void setPaused(boolean paused);
	
	/**
	 * Checks to see if the clock is currently paused.
	 * @return Whether or not this clock is paused.
	 */
	public boolean isPaused();
	
	/**
	 * Checks to see if a cycle has elapsed for this clock yet. If so,
	 * the number of elapsed cycles will be decremented by one.
	 * @return Whether or not a cycle has elapsed.
	 * @see peekElapsedCycle
	 */
	public boolean hasElapsedCycle();
	
	/**
	 * Checks to see if a cycle has elapsed for this clock yet. Unlike
	 * {@code hasElapsedCycle}, the number of cycles will not be decremented
	 * if the number of elapsed cycles is greater than 0.
	 * @return Whether or not a cycle has elapsed.
	 * @see hasElapsedCycle
	 */
	public boolean peekElapsedCycle();
}
