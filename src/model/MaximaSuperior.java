package model;
public class MaximaSuperior {

  // Relations
  private Archangel[] archangels;

  // Constructor
  public MaximaSuperior (int cant) {
    archangels = new Archangel[cant];
  }

  // Setters
  public void setArchangel (int i, Archangel new_archangel) {
    archangels[i] = new_archangel;
  }

  // Getters
  public Archangel getArchangel (int i) {
    return archangels[i];
  }

  // Methods

  /**
   * This method compares a String typed by the user with the names of the archangels already created.
   * <b>pre:</b> The variable name has already been asked to the user.
   * <b>post:</b> It is known if the name exists or not.
   * @param name corresponds to the name of an archangel.
   * @return boolean that indicates if the name exists.
   */
  public boolean nameApproved (String name) {
    String angelName = name;
    boolean nameApproved = false, endFor = false;
    if (angelName.substring((name.length()-2), (name.length())).equalsIgnoreCase("el")) {
      for (int i=0; i<archangels.length && !endFor; i++) {
        if (archangels[i]!=null && archangels[i].getName().equals(name)) {
            nameApproved = false;
            endFor = true;
        }
        else {
          nameApproved = true;
        }
      }
    }
    return nameApproved;
  }

  /**
   * This method compares a String typed by the user with the powers of the archangels already created.
   * <b>pre:</b> The variable power has already been asked to the user.
   * <b>post:</b> It is known if the power exists or not.
   * @param power corresponds to the power of an archangel.
   * @return boolean that indicates if the power exists.
   */
  public boolean powerExists (String power) {
    boolean powerExists = false;
    for(int i=0; i<archangels.length && !powerExists; i++) {
      if (archangels[i]!=null && archangels[i].getPower().equals(power)) {
          powerExists = true;
      }
    }
    return powerExists;
  }

  /**
   * This method goes through an array and checks if there is any null box.
   * <b>pre:</b> An array of archangels has already been created.
   * <b>post:</b> It is known if there is space or not.
   * @return boolean that indicates if there is space to create a new archangel.
   */
  public boolean thereIsSpace () {
    boolean thereIsSpace = false;
    for (int i=0; i<archangels.length && !thereIsSpace; i++) {
      if (archangels[i]==null)
        thereIsSpace = true;
    }
    return thereIsSpace;
  }
  
  /**
   * This method creates a new archangel with the parameters given if there is space.
   * <b>pre:</b> An array of archangels has already been created.
   * <b>post:</b> A new archangel has been created.
   * @param name is the name of the new archangel.
   * @param prayer is the prayer of the new archangel.
   * @param celeb_date is the celebration date of the new archangel.
   * @param power is the power of the new archangel.
   * @param color is the color of the new archangel's candle.
   * @param essence is the essence of the new archangel's candle.
   * @param size is the size of the new archangel's candle.
   * @param illuminance_grade is the illuminance grade of the new archangel's candle
   */
  public void createArchangel (String name, String prayer, String celeb_date, String power, String color, String essence, String size, String illuminance_grade) {
    boolean created = false;
    for (int i=0; i<archangels.length && !created; i++) {
      if (archangels[i]==null) {
        archangels[i] = new Archangel (name, prayer, celeb_date, power, color, essence, size, illuminance_grade);
        created = true;
      }
    }
  }

  /**
   * This method goes through an array and counts how many boxes aren't null.
   * <b>pre:</b> An array of archangels has already been created.
   * <b>post:</b> It is known how many archangels have been entered.
   * @return int that idicates the amount of archangels entered.
   */
  public int cantAngelsEntered () {
    int cantAngelsEntered = 0;
    for (int i=0; i<archangels.length; i++) {
      if (archangels[i]!=null)
        cantAngelsEntered += 1;
    }
    return cantAngelsEntered;
  }

  /**
   * This method compares a String typed by the user with the names of the archangels already created.
   * <b>pre:</b> An array of archangels has already been created.
   * <b>post:</b> It is known which archangel matches with the name given.
   * @param name corresponds to the name of an archangel.
   * @return archangel whose name matches with the name given.
   */
  public Archangel searchArchangelByName (String name) {
    Archangel archangel_found = null;
    boolean finish = false;
    for (int i=0; i<archangels.length && !finish; i++) {
      if (archangels[i]!=null && archangels[i].getName().equals(name)) {
        archangel_found = archangels[i];
        finish = true;
      }
    }
    return archangel_found;
  }

  /**
   * This method compares a String typed by the user with the powers of the archangels already created.
   * <b>pre:</b> An array of archangels has already been created.
   * <b>post:</b> It is known which archangel matches with the power given.
   * @param power corresponds to the power of an archangel.
   * @return archangel whose power matches with the power given.
   */
  public Archangel searchArchangelByPower (String power) {
    Archangel archangel_found = null;
    boolean finish = false;
    for (int i=0; i<archangels.length && !finish; i++) {
      if (archangels[i]!=null && archangels[i].getPower().equals(power)) {
        archangel_found = archangels[i];
        finish = true;
      }
    }
    return archangel_found;
  }

  /**
   * This method creates a String with the information of an archangel given its name.
   * <b>pre:</b> the method "searchArchangelByName" has already been created.
   * <b>post:</b> A String that contains all the information of an archangel has been created.
   * @param name corresponds to the name of an archangel.
   * @return String that contains all the information of an archangel.
   */
  public String archInfoByName (String name) {
    String infoArch = "";
    Archangel arch = searchArchangelByName(name);
    if (arch!=null) {
      infoArch = "\n--------Archangel's info--------\nName:"+arch.getName()+"\nPrayer: "+arch.getPrayer()+"\nCelebration date: "+arch.getCelebDate()+"\nPower: "+arch.getPower()+"\nCandle's color: "+arch.getCandle().getColor()+"\nCandle's essence: "+arch.getCandle().getEssence()+"\nCandle's size: "+arch.getCandle().getSize()+"\nCandle's illuminance grade: "+arch.getCandle().getIlluminanceGrade();
    }
    else
      infoArch = "\nThere is not any archangel with that name.";
    return infoArch;
  }

  /**
   * This method creates a String with the information of an archangel given its power.
   * <b>pre:</b> the method "searchArchangelByPower" has already been created.
   * <b>post:</b> A String that contains all the information of an archangel has been created.
   * @param power corresponds to the power of an archangel.
   * @return String that contains all the information of an archangel.
   */
  public String archInfoByPower (String power) {
    String infoArch = "";
    Archangel arch = searchArchangelByPower(power);
    if (arch!=null) {
      infoArch = "\n---------Archangel's info---------\nName:"+arch.getName()+"\nPrayer: "+arch.getPrayer()+"\nCelebration date: "+arch.getCelebDate()+"\nPower: "+arch.getPower()+"\nCandle's color: "+arch.getCandle().getColor()+"\nCandle's essence: "+arch.getCandle().getEssence()+"\nCandle's size: "+arch.getCandle().getSize()+"\nCandle's illuminance grade: "+arch.getCandle().getIlluminanceGrade();
    }
    else
      infoArch = "\nThere is not any archangel with that power.";
    return infoArch;
  }

  /**
   * This method validates if the input of size is valid and completes it for a better understanding.
   * <b>pre:</b> The variable size has already been asked to the user.
   * <b>post:</b> A String with a new value for size.
   * @param size corresponds to the size of an archangel's candle.
   * @return String that contains the new value for the variable size.
   */
  public String validateSize(String size) {
    String final_size = "";
    if (size.equalsIgnoreCase("s"))
      final_size = "Small";
    else if (size.equalsIgnoreCase("m"))
      final_size = "Medium";
    else if (size.equalsIgnoreCase("b"))
      final_size = "Big";
    else
      final_size = "Invalid input";
    return final_size;
  }

  /**
   * This method validates if the input of illuminance_grade is valid and completes it for a better understanding.
   * <b>pre:</b> The variable illuminance_grade has already been asked to the user.
   * <b>post:</b> A String with a new value for illuminance_grade.
   * @param illuminance_grade corresponds to the illuminance grade of an archangel's candle.
   * @return String that contains the new value for the variable illuminance grade.
   */
  public String validateIlluminanceGrade(String illuminance_grade) {
    String final_illuminance_grade = "";
    if (illuminance_grade.equalsIgnoreCase("l"))
      final_illuminance_grade = "Low";
    else if (illuminance_grade.equalsIgnoreCase("h"))
      final_illuminance_grade = "High";
    else
      final_illuminance_grade = "Invalid input";
    return final_illuminance_grade;
  }

  /**
   * This method validates if the input of celeb_date is valid.
   * <b>pre:</b> The variable celeb_date has already been asked to the user.
   * <b>post:</b> It is known is the input of celeb_date is in a valid format.
   * @param celeb_date corresponds to the celeb date of an archangel's candle.
   * @return boolean that indicates if the input of celeb_date is valid.
   */
  public boolean validateDate (String celeb_date) {
    boolean valid_date = false;
    if (celeb_date.contains("/")) {
      valid_date = true;
    }
    return valid_date;
  }

  /**
   * This method creates a String with the celebrations of a given month.
   * <b>pre:</b> An array of archangels has already been created.
   * <b>post:</b> String containing the celebrations of a given month has been created.
   * @param month corresponds to the number of a month.
   * @return A String with the names, celebrations dates, candle's colors and candle's essences of the archangels.
   */
  public String monthCelebrations (int month) {
    String monthCelebs = "";
    for (int i=0; i<archangels.length; i++) {
      if (archangels[i]!=null && Integer.valueOf(archangels[i].getCelebDate().substring(archangels[i].getCelebDate().indexOf("/")+1, (archangels[i].getCelebDate().length())))==month) {
        monthCelebs += "\nArchangel name: "+archangels[i].getName()+"\nCelebration date: "+archangels[i].getCelebDate()+"\nCandle's color: "+archangels[i].getCandle().getColor()+"\nCandle's essence: "+archangels[i].getCandle().getEssence()+"\n";
      }
    }
    return monthCelebs;
  }

  /**
   * This method creates a String with all the celebrations.
   * <b>pre:</b> An array of archangels has already been created.
   * <b>post:</b> A String with the names of the archangels and their celebrations dates has been created.
   * @return String containing all the celebrations.
   */
  public String allCelebrations () {
    String allCelebs = "\n";
    for (int i=0; i<archangels.length; i++) {
      if (archangels[i]!=null) {
        allCelebs += archangels[i].getName()+": "+archangels[i].getCelebDate()+". ";
      }
    }
    return allCelebs;
  }
}