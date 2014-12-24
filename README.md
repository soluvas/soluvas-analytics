# Soluvas Analytics

Open source analytics gathering, processing, presentation framework for Java.

http://www.soluvas.com/

Supports:

1. [D3](http://d3js.org/) / [Rickshaw](http://code.shutterstock.com/rickshaw/) JavaScript charting library
2. Spring Batch
3. Aoache Spark
4. Spring Task Scheduler scheduling
5. Scheduling with Quartz
6. JasperReports reporting & charts
7. OLAP with Mondrian (optionally Saiku for UI)
8. Apache HBase datastore
9. Spark Streaming
10. Spark MLlib
11. ElasticSearch
12. [PredictionIO](http://prediction.io/) (which requires Spark, HBase, ElasticSearch) 

See also:

1. [Cascading](http://www.cascading.org/) includes: Lingual, Pattern
2. [Wicket chart.js](http://pingunaut.com/wicket-chartjs/)

## Modules

### org.soluvas.analytics.core

Core APIs, non-web framework specific, JAX-RS resources.

### org.soluvas.analytics.web

Web components, works with Wicket, Bootstrap, and Atmosphere (for push).

## FAQ

1. Why not [Highcharts](http://www.highcharts.com/) / [Wicked Charts](https://code.google.com/p/wicked-charts/) ?

Highcharts is not compatible with Eclipse Public License. :(
