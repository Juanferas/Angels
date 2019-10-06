package model;
public class Archangel {

  // Relations
  private Candle newCandle;

  // Atributes
  private String name, prayer, celeb_date, power;

  // Constructor
  public Archangel (String name, String prayer, String celeb_date, String power, String color, String essence, String size, String illuminance_grade) {
    this.name = name;
    this.prayer = prayer;
    this.celeb_date = celeb_date;
    this.power = power;
    newCandle = new Candle (color, essence, size, illuminance_grade);
  }

  // Setters
  public void setName (String name) {
    this.name = name;
  }

  public void setPrayer (String prayer) {
    this.prayer = prayer;
  }

  public void setCelebDate (String celeb_date) {
    this.celeb_date = celeb_date;
  }

  public void setPower (String power) {
    this.power = power;
  }

  public void setCandle (Candle newCandle) {
    this.newCandle = newCandle;
  }

  // Getters
  public String getName () {
    return this.name;
  }

  public String getPrayer () {
    return this.prayer;
  }

  public String getCelebDate () {
    return this.celeb_date;
  }

  public String getPower () {
    return this.power;
  }

  public Candle getCandle() {
    return this.newCandle;
  }
}