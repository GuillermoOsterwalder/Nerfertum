package corp.tarta.nerfertum.Model.Entities;

/**
 * Created by morio on 28/06/17.
 */
public class ExcelParameters {

  private int codeColIndex;
  private int codeRowIndex;
  private int descriptionColIndex;
  private int descriptionRowIndex;
  private int priceColIndex;
  private int priceRowIndex;

  public ExcelParameters(){
    codeColIndex = 0;
    codeRowIndex = 0;
    descriptionColIndex = 0;
    descriptionRowIndex = 0;
    priceColIndex = 0;
    priceRowIndex = 0;
  }

  public int getCodeColIndex() {
    return codeColIndex;
  }

  public void setCodeColIndex(int codeColIndex) {
    this.codeColIndex = codeColIndex;
  }

  public int getCodeRowIndex() {
    return codeRowIndex;
  }

  public void setCodeRowIndex(int codeRowIndex) {
    this.codeRowIndex = codeRowIndex;
  }

  public int getDescriptionColIndex() {
    return descriptionColIndex;
  }

  public void setDescriptionColIndex(int descriptionColIndex) {
    this.descriptionColIndex = descriptionColIndex;
  }

  public int getDescriptionRowIndex() {
    return descriptionRowIndex;
  }

  public void setDescriptionRowIndex(int descriptionRowIndex) {
    this.descriptionRowIndex = descriptionRowIndex;
  }

  public int getPriceColIndex() {
    return priceColIndex;
  }

  public void setPriceColIndex(int priceColIndex) {
    this.priceColIndex = priceColIndex;
  }

  public int getPriceRowIndex() {
    return priceRowIndex;
  }

  public void setPriceRowIndex(int priceRowIndex) {
    this.priceRowIndex = priceRowIndex;
  }

  public static int charToIndex(Character character){
    int index = 0;
    index = character.charValue() - 'a' + 1;
    return index;
  }

}
