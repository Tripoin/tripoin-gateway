package id.co.tripoin.core.pojo.base;

import java.io.Serializable;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <KEY>
 */
public interface IBaseMapperDATA<KEY extends Serializable> extends IMasterDATA, ISingleKeyDATA<KEY> {

}
