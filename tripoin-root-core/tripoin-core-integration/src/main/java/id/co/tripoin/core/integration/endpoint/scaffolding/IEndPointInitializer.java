package id.co.tripoin.core.integration.endpoint.scaffolding;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IEndPointInitializer {

	/**
	 * <p>
	 * 		Initiate service when @PostConstruct with any particular Service. Example
	 * 		<code>
	 * 
	 * 			@Autowired
	 * 			private MyService myService;
	 * 
	 * 			@PostConstruct
	 * 			public void init(
	 * 				super.scaffoldingService = myService;
	 * 			);
	 * 		</code>
	 * </p>
	 */
	public void init();
}
