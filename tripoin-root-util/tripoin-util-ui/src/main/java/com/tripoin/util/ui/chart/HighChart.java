package com.tripoin.util.ui.chart;

import com.vaadin.annotations.JavaScript;

/**
 * This is the chart class we are using in the demo application.
 * It loads jquery 1.7.1 and highcharts.js located in the same package.
 * Extend you own class in order to load other JS files.
 * Make sure "highcharts-connector.js" is loaded at the end.
 *
 * @author <a href="mailto:tripoinstudio@gmail.com">Tripoin, inc.</a>
 */

interface a {
//	String ip = "10.10.130.206";
	String ip = "192.168.43.64";
}
//@JavaScript({ "http://" + a.ip + "/sales-dashboard/js/jquery.min.js",
//"http://" + a.ip + "/sales-dashboard/js/highcharts.js",
//"http://" + a.ip + "/sales-dashboard/js/highcharts-3d.js",
//"http://" + a.ip + "/sales-dashboard/js/grouped-categories.js",
//"http://" + a.ip + "/sales-dashboard/js/properties.js",
//"http://" + a.ip + "/sales-dashboard/js/modules/exporting.js",
//"http://" + a.ip + "/sales-dashboard/js/highcharts-connector.js" })
@JavaScript({"jquery.min.js", "highcharts.js",
	"highcharts-3d.js",

	"grouped-categories.js",
	"properties.js",
	"exporting.js", "highcharts-connector.js"})
public class HighChart extends AbstractHighChart {
	private static final long serialVersionUID = -7326315426217377753L;
}
