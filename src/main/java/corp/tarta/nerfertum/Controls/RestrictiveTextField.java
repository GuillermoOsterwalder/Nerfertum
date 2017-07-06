package corp.tarta.nerfertum.Controls;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

public class RestrictiveTextField extends TextField {
	 
    private IntegerProperty maxLength = new SimpleIntegerProperty(this, "maxLength", -1);
    private StringProperty restrict = new SimpleStringProperty(this, "restrict");
    private FloatProperty maxValue = new SimpleFloatProperty(this,"maxValue",-1);
    private boolean numericField = false;
    
    
    public RestrictiveTextField() {
    	
    	this.textProperty().addListener(
    			  (observable, oldValue, newValue) -> {
    			    
    				 if (newValue != null){
    					if (maxLength.get() > -1 && newValue.length() > maxLength.get()) {
    						((StringProperty)observable).setValue(oldValue.substring(0, maxLength.get()));
     	                }

    					if (restrict.get() != null && !restrict.get().equals("") && !newValue.matches(restrict.get() + "*")) {
    						((StringProperty)observable).setValue(oldValue); 
    		            }else{
        					if(numericField){
        						if (newValue.length() == (maxLength.get())){
        							char c = newValue.charAt(newValue.length()-1);
        							System.out.println("Last char : " + c);
        							if (c == '.'){
        								((StringProperty)observable).setValue(oldValue.substring(0, newValue.length()-1));
        							}
        						}
        	    				if (!newValue.isEmpty() && maxValue.get() != -1 && Float.valueOf(newValue).compareTo(maxValue.get())>0){
        	    					((StringProperty)observable).setValue(oldValue); 
        	    				}		
        					}
    		            }
    				 }
    			  }
    			);
    }
 
    /**
     * The max length property.
     *
     * @return The max length property.
     */
    public IntegerProperty maxLengthProperty() {
        return maxLength;
    }
 
    /**
     * Gets the max length of the text field.
     *
     * @return The max length.
     */
    public int getMaxLength() {
        return maxLength.get();
    }
 
    /**
     * Sets the max length of the text field.
     *
     * @param maxLength The max length.
     */
    public void setMaxLength(int maxLength) {
        this.maxLength.set(maxLength);
    }
 
    /**
     * The restrict property.
     *
     * @return The restrict property.
     */
    public StringProperty restrictProperty() {
        return restrict;
    }
 
    /**
     * Gets a regular expression character class which restricts the user input.
 
     *
     * @return The regular expression.
     * @see #getRestrict()
     */
    public String getRestrict() {
        return restrict.get();
    }
 
    /**
     * Sets a regular expression character class which restricts the user input.
 
     * E.g. [0-9] only allows numeric values.
     *
     * @param restrict The regular expression.
     */
    public void setRestrict(String restrict) {
        this.restrict.set(restrict);
    }

    public Float getMaxValue(){
    	return maxValue.get();
    }
    
    public void setMaxValue(Float maxValue){
    	this.maxValue.set(maxValue);
    }
    
    public boolean isNumeric(){
    	return numericField;
    }
    
    public void setNumericField(boolean isNumeric){
    	this.numericField = isNumeric;
    }
}
