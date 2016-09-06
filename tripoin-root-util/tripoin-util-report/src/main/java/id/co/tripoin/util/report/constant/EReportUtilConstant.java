
package id.co.tripoin.util.report.constant;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public enum EReportUtilConstant {

	REPORT_PDF(".pdf", "application/pdf"),
	REPORT_EXCEL(".xls", "application/vnd.ms-excel"),
	REPORT_CSV(".csv", "text/csv"),
	REPORT_TEXT(".txt", "text/plain");

	private String operator;
	private Integer operatorInteger;	
	private String operand;
	
	private EReportUtilConstant(String operator){
		this.operator = operator ;
	}	
	
	private EReportUtilConstant(String operator, String operand){
		this.operator = operator ;
		this.operand = operand;
	}	
	
	private EReportUtilConstant(Integer operatorInteger){
		this.operatorInteger = operatorInteger ;
	}
	
	public static EReportUtilConstant getEnum(String value) {
        for(EReportUtilConstant eReportUtilConstant : values())
            if(eReportUtilConstant.getOperator().equalsIgnoreCase(value)) return eReportUtilConstant;
        throw new IllegalArgumentException();
    }
	
	public String getOperator() {
		return operator;
	}
	
	public String getOperand(){
		return operand;
	}

	public Integer getOperatorInt() {
		return operatorInteger;
	}

	@Override
	public String toString() {
		if(operator == null)
			return operatorInteger.toString();
		return operator;
	}
	
}
