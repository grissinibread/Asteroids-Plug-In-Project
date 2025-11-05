package edu.csusm.navarro.vector;

public interface IVector {
	
	public double getX();
	
	public double getY();
	
	public void setX(double x);
	
	public void setY(double y);
	
	/**
	 * Sets the components of this vector.
	 * @param x The x component.
	 * @param y The y component.
	 * @return This vector for chaining.
	 */
	public IVector set(double x, double y);
	
	/**
	 * Adds the components of a vector to this one.
	 * @param vec The vector to add.
	 * @return This vector for chaining.
	 */
	public IVector add(IVector vec);
	
	/**
	 * Scales the components of this vector.
	 * @param scalar The scalar value.
	 * @return This vector for chaining.
	 */
	public IVector scale(double scalar);
	
	/**
	 * Normalizes this Vector (giving it a length of 1.0).
	 * @return This vector for chaining.
	 */
	public IVector normalize();
	
	/**
	 * Gets the squared length of this Vector.
	 * @return The squared length.
	 */
	public double getLengthSquared();

	/**
	 * Gets the squared distance to another Vector.
	 * @param vec The other vector.
	 * @return The squared distance.
	 */
	public double getDistanceToSquared(IVector vec);
}
