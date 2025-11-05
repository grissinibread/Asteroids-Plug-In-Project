package edu.csusm.navarro.vector;

public interface IVectorFactory {
	public IVector createVector(double angle);
	
	public IVector createVector(double x, double y);

	public IVector createVector(IVector vec);
}