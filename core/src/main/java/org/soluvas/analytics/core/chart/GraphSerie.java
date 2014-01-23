package org.soluvas.analytics.core.chart;

import java.io.Serializable;

/**
 * @author ceefour
 *
 */
public class GraphSerie implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String color = "steelblue";
	private final DataPoint[] data;
	
	public GraphSerie(DataPoint[] data) {
		super();
		this.data = data;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the data
	 */
	public DataPoint[] getData() {
		return data;
	}
	
}
