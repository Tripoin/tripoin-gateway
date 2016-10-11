package id.co.tripoin.core.pojo.base;

import java.io.Serializable;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <KEY>
 */
public interface ISingleKeyDATA<KEY extends Serializable> {
	
	public KEY getId();

}
