package id.co.tripoin.core.service.formula;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <PARAM>
 * @param <RESULT>
 */
public interface IFormulaCalculator<PARAM, RESULT> {

    void setParam(PARAM param);

    PARAM getParam();

    void setResult(RESULT result);

    RESULT getResult();

    void calculate();
    
}
