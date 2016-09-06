package id.co.tripoin.util.ui.chart;

import com.vaadin.shared.ui.JavaScriptComponentState;

/**
 * State of the chart which is transferred to the web browser whenever a property changed.
 *
 * @author <a href="mailto:tripoinstudio@gmail.com">Tripoin, inc.</a>
 */
public class HighChartState extends JavaScriptComponentState {
	private static final long serialVersionUID = -8963272160069864062L;

	public String domId;
	public String hcjs;
}