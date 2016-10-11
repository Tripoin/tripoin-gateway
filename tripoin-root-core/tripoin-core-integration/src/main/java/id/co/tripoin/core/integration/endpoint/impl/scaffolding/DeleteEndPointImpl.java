package id.co.tripoin.core.integration.endpoint.impl.scaffolding;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import id.co.tripoin.core.integration.endpoint.scaffolding.IDeleteEndPoint;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * 
 */
public class DeleteEndPointImpl implements IDeleteEndPoint<Long>{

	private static Logger LOGGER = Logger.getLogger(DeleteEndPointImpl.class);
	
	@Override
	public void delete(ArrayList<Long> p_IDs) {
		if (p_IDs.size() > 0){
			LOGGER.info("ID is Less than 1");
		}
		for(Long id : p_IDs){
			
		}
	}

}
