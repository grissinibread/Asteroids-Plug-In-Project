package edu.csusm.navarro.vector;

public class Vector2 implements IVector {
	/**
	 * The x value of the vector.
	 */
	public double x;
	
	/**
	 * The y value of the vector.
	 */
	public double y;
	
	/**
	 * Creates a new Vector from an angle. The length of this vector will be 1.
	 * @param angle The angle.
	 */
	public Vector2(double angle) {
		this.x = Math.cos(angle);
		this.y = Math.sin(angle);
	}
	
	/**
	 * Creates a new Vector with the desired values.
	 * @param x The x value.
	 * @param y The y value.
	 */
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Creates a new Vector and copies the components from the old.
	 * @param vec The vector to copy.
	 */
	public Vector2(IVector vec) {
		this.x = vec.getX();
		this.y = vec.getY();
	}
	
	/**
	 * Sets the components of this vector.
	 * @param x The x component.
	 * @param y The y component.
	 * @return This vector for chaining.
	 */
	public IVector set(double x, double y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	/**
	 * Adds the components of a vector to this one.
	 * @param vec The vector to add.
	 * @return This vector for chaining.
	 */
	public IVector add(IVector vec) {
		this.x += vec.getX();
		this.y += vec.getY();
		return this;
	}
	
	/**
	 * Scales the components of this vector.
	 * @param scalar The scalar value.
	 * @return This vector for chaining.
	 */
	public IVector scale(double scalar) {
		this.x *= scalar;
		this.y *= scalar;
		return this;
	}
	
	/**
	 * Normalizes this Vector (giving it a length of 1.0).
	 * @return This vector for chaining.
	 */
	public IVector normalize() {
		double length = getLengthSquared();
		if(length != 0.0f && length != 1.0f) {
			length = Math.sqrt(length);
			this.x /= length;
			this.y /= length;
		}
		return this;
	}
	
	/**
	 * Gets the squared length of this Vector.
	 * @return The squared length.
	 */
	public double getLengthSquared() {
		return (x * x + y * y);
	}

	/**
	 * Gets the squared distance to another Vector.
	 * @param vec The other vector.
	 * @return The squared distance.
	 */
	public double getDistanceToSquared(IVector vec) {
		double dx = this.x - vec.getX();
		double dy = this.y - vec.getY();
		return (dx * dx + dy * dy);
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void setX(double x) {
		this.x = x;
		
	}

	@Override
	public void setY(double y) {
		this.y = y;
	}
}
