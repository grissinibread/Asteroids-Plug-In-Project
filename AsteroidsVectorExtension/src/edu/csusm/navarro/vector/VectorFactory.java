package edu.csusm.navarro.vector;

public class VectorFactory implements IVectorFactory {
	public IVector createVector(double angle) {
		return new Vector2(angle);
	}
	
	public IVector createVector(double x, double y) {
		return new Vector2(x, y);
	}

	public IVector createVector(IVector vec) {
		return new Vector2(vec);
	}
}