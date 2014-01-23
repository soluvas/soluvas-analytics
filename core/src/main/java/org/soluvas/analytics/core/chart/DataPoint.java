package org.soluvas.analytics.core.chart;

import java.io.Serializable;

public class DataPoint implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private double x;
	private double y;
	
	public DataPoint(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}
	
}
