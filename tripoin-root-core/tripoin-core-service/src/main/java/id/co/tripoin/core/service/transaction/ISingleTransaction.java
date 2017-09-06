package id.co.tripoin.core.service.transaction;

/**
 * created on 1/20/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA> Request Object
 */
public interface ISingleTransaction<DATA> {

    boolean checkMandatoryFields(DATA p_DATA);
}
