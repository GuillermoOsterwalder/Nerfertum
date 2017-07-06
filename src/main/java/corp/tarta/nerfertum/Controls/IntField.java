package corp.tarta.nerfertum.Controls;

public class IntField extends RestrictiveTextField {


	//private final String regex = "^(\\d+(\\.\\d+)?)$";
	private final String regex = "^(\\d*)$";
	
	public IntField (Long maxValue, int maxLenght){
		super();
		
		this.setMaxLength(maxLenght);
		this.setRestrict(regex);
		this.setMaxValue(Float.valueOf(maxValue));
		this.setNumericField(true);
	}
}
