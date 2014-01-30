package org.soluvas.analytics.core.chart;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class GraphTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * http://code.shutterstock.com/rickshaw/tutorial/introduction.html 
	 * @throws IOException 
	 */
	@Test
	public void blueChart() throws IOException {
		final DataPoint[] blueData = new DataPoint[] { new DataPoint(0, 40), new DataPoint(1, 49), new DataPoint(2, 17), new DataPoint(3, 42) };
		final GraphSerie blueSerie = new GraphSerie(blueData); 
		final Graph graph = new Graph(ImmutableList.of(blueSerie));
		final File outFile = new File(System.getProperty("user.home"), "tmp/chart_blue.html");
		graph.renderHtml(outFile);
		assertTrue(outFile.exists());
	}

	@Test
	public void blueRed() throws IOException {
		final DataPoint[] blueData = new DataPoint[] { new DataPoint(0, 40), new DataPoint(1, 49), new DataPoint(2, 17), new DataPoint(3, 42) };
		final DataPoint[] redData = new DataPoint[] { new DataPoint(0, 25), new DataPoint(1, 35), new DataPoint(2, 42), new DataPoint(3, 11) };
		final GraphSerie blueSerie = new GraphSerie(blueData); 
		final GraphSerie redSerie = new GraphSerie(redData);
		redSerie.setColor("red");
		final Graph graph = new Graph(ImmutableList.of(blueSerie, redSerie));
		final File outFile = new File(System.getProperty("user.home"), "tmp/chart_bluered.html");
		graph.renderHtml(outFile);
		assertTrue(outFile.exists());
	}

}
