package id.co.tripoin.core.service.formula;


/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <PARAM>
 * @param <RESULT>
 */
public abstract class AFormulaCalculator<PARAM, RESULT> implements IFormulaCalculator<PARAM, RESULT> {

	protected PARAM param;
	protected RESULT result;
	
	@Override
	public void setParam(PARAM param) {
		this.param = param;
	}

	@Override
	public PARAM getParam() {
		return param;
	}

	@Override
	public void setResult(RESULT result) {
		this.result = result;
	}

	@Override
	public RESULT getResult() {
		return result;
	}

}
