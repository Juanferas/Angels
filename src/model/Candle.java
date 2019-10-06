package model;
public class Candle {

  // Atributes
  private String color, essence, size, illuminance_grade;

  // Constructor
  public Candle (String color, String essence, String size, String illuminance_grade) {
    this.color = color;
    this.essence = essence;
    this.size = size;
    this.illuminance_grade = illuminance_grade;
  }

  // Setters
  public void setColor (String color) {
    this.color = color;
  }

  public void setEssence (String essence) {
    this.essence = essence;
  }

  public void setSize (String size) {
    this.size = size;
  }

  public void setIlluminanceGrade (String illuminance_grade) {
    this.illuminance_grade = illuminance_grade;
  }

  // Getters
  public String getColor () {
    return this.color;
  }

  public String getEssence () {
    return this.essence;
  }

  public String getSize () {
    return this.size;
  }

  public String getIlluminanceGrade () {
    return this.illuminance_grade;
  }
}