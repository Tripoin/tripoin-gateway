package id.co.tripoin.core.service;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IServiceInitializer {

	/**
	 * <p>
	 * 		Initiate service when @PostConstruct with any particular DAO. Example
	 * 		<code>
	 * 
	 * 			@Autowired
	 * 			private MyDao myDAO;
	 * 
	 * 			@PostConstruct
	 * 			public void init(
	 * 				super.scaffoldingDAO = myDAO;
	 * 			);
	 * 		</code>
	 * </p>
	 */
	public void init();
}
