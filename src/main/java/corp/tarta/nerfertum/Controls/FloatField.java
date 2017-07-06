package corp.tarta.nerfertum.Controls;

public class FloatField extends RestrictiveTextField{


	//private final String regex = "^(\\d+(\\.\\d+)?)$";
	private final String regex = "^(\\d*)|(\\d+\\.?\\d*)$";
	
	public FloatField (Float maxValue, int maxLenght){
		super();
		
		this.setMaxLength(maxLenght);
		this.setRestrict(regex);
		this.setMaxValue(Float.valueOf(maxValue));
		this.setNumericField(true);
	}
	
	
}
