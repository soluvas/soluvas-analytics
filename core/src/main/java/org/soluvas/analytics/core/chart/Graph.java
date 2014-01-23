package org.soluvas.analytics.core.chart;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.json.JsonUtils;

/**
 * Rickshaw Graph abstraction.
 * @author ceefour
 */
public class Graph {
	
	private static final Logger log = LoggerFactory.getLogger(Graph.class);
	
	private int width = 580;
	private int height = 250;
	
	private final List<GraphSerie> series;
	
	public Graph(List<GraphSerie> series) {
		super();
		this.series = series;
	}
	
	public List<GraphSerie> getSeries() {
		return series;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * Render to standalone HTML, with scripts loaded from CDN.
	 * @param outFile
	 * @throws IOException 
	 */
	public void renderHtml(File outFile) throws IOException {
		String doc =
				"<!doctype html>\n"
				+ "<script src=\"http://cdnjs.cloudflare.com/ajax/libs/d3/3.4.0/d3.min.js\"></script>\n"
//				+ "<script src="../vendor/d3.layout.min.js"></script>\n"
				+ "<script src=\"http://cdnjs.cloudflare.com/ajax/libs/rickshaw/1.4.6/rickshaw.min.js\"></script>\n"
				+ "<div id=\"chart\"></div>\n"
				+ "<script>\n";
		for (int i = 0; i < series.size(); i++) {
			final GraphSerie serie = series.get(i);
			doc += "var data" + i + " = " + JsonUtils.asJson(serie.getData()) + ";\n";
		}
		doc +=
				"var graph = new Rickshaw.Graph( {\n"
				+ "element: document.querySelector(\"#chart\"),\n"
				+ "width: " + width + ",\n"
				+ "height: " + height + ",\n";
		doc += "series: [\n";
		for (int i = 0; i < series.size(); i++) {
			final GraphSerie serie = series.get(i);
			doc += "{\n";
			doc += "color: '" + serie.getColor() + "',\n";
			doc += "data: data" + i + "\n";
			doc += "},\n";
		}
		doc += "]\n";
		doc +=
				"} );\n"
				+ "\n"
				+ "graph.render();\n"
				+ "\n"
				+ "</script>\n"
				+ "";
		log.debug("Writing HTML to {}", outFile);
		FileUtils.write(outFile, doc);
	}
	
}
