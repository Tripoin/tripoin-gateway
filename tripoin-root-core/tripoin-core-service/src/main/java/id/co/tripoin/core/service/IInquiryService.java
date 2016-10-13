package id.co.tripoin.core.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <ID>
 */
public interface IInquiryService<DATA, ID> {

	List<DATA> findAll();
	
	DATA findById(ID p_ID);
	
	List<DATA> findByCode(String p_Code);
	
	List<DATA> findByName(String p_Name);
	
	List<DATA> pagination(Pageable p_Pageable);
	
	List<DATA> advancedPagination(Pageable p_Pageable);
	
	List<DATA> selectLOV();
	
	List<String> getPhysicalColumnNames();

}
