package ui;
import model.*;
import java.util.Scanner;
public class Main {

  Scanner lectorstr, lectorint;
  private MaximaSuperior maximaSuperior;

  public Main () {
    lectorstr = new Scanner(System.in);
    lectorint = new Scanner(System.in);
    System.out.println("How many angels do you want to register?");
    int cant_angels = lectorint.nextInt();
    maximaSuperior = new MaximaSuperior (cant_angels);
  }

  public static void main(String[] args) {
    Main obj = new Main();
    int cicle = 0;
    
    while (cicle==0)
    {
      System.out.println("\nMenu:\n1.Enter archangel.\n2.Count archangels entered.\n3.Show archangel info by its name.\n4.Show archangel info by its power.\n5.Show celebrations of a month.\n6.Show all celebrations.\n7.Exit.");
      int op = obj.lectorint.nextInt();
      switch (op)
      {
        case 1:
          obj.createArchangel();
          break;
        case 2:
          obj.cantAngelsEntered();
          break;
        case 3:
          obj.archInfoByName();
          break;
        case 4:
          obj.archInfoByPower();
          break;
        case 5:
          obj.monthCelebrations();
          break;
        case 6:
          obj.allCelebrations();
          break;
        case 7:
          cicle=1;
          break;
      }
    }
  }

  /**
   * This method asks for the atributes of the archangels, to pass them to a method in MaximaSuperior class in order to create a new Archangel.
   * <b>pre:</b> An object of type Main has already been created, as well as the "createArchangel" method in the MaximaSuperior class.
   * <b>post:</b> The information typed by the user hass been correctly passed to the method in MaximaSuperior class.
   */
  public void createArchangel () {
    if (maximaSuperior.thereIsSpace()==true)
    {
      System.out.println("\nArchangel's name:");
      String name = lectorstr.nextLine();
      while (maximaSuperior.nameApproved(name)==false) {
        System.out.println("This name doesn't end in \"el\" or already exists, please enter another one.");
        System.out.println("Archangel's name:");
        name = lectorstr.nextLine();
      }
      System.out.println("Archangel's prayer:");
      String prayer = lectorstr.nextLine();
      System.out.println("Archangel's celebration date (day/month):");
      String celeb_date = lectorstr.nextLine();
      while (maximaSuperior.validateDate(celeb_date)==false) {
        System.out.println("Invalid format, please try again.");
        System.out.println("Archangel's celebration date (day/month):");
        celeb_date = lectorstr.nextLine();
      }
      System.out.println("Archangel's power:");
      String power = lectorstr.nextLine();
      while (maximaSuperior.powerExists(power)==true) {
        System.out.println("This power already exists, please enter another one.");
        System.out.println("Archangel's power:");
        power = lectorstr.nextLine();
      }
      System.out.println("Candle's color:");
      String color = lectorstr.nextLine();
      System.out.println("Candle's essence:");
      String essence = lectorstr.nextLine();
      System.out.println("Candle's size:\ns: Small\nm: Medium\nb: Big");
      String size = lectorstr.nextLine();
      size = maximaSuperior.validateSize(size);
      System.out.println("Candle's illuminance grade:\nl: Low\nh :High");
      String illuminance_grade = lectorstr.nextLine();
      illuminance_grade = maximaSuperior.validateIlluminanceGrade(illuminance_grade);
      maximaSuperior.createArchangel(name, prayer, celeb_date, power, color, essence, size, illuminance_grade);
    }
    else
      System.out.println("\nThere is not enough space to register another archangel.");
  }

  /**
   * This method prints a message with the quantity of archangels the user has entered.
   * <b>pre:</b> The method "cantAngelsEntered" in the MaximaSuperior class has already been created.
   * <b>post:</b> A String shows on screen.
   */
  public void cantAngelsEntered () {
    System.out.println("\nYou have entered "+maximaSuperior.cantAngelsEntered()+" archangels.");
  }

  /**
   * This method asks for the name of an existent archangel to pass its value to a method in MaximaSuperior class in order to generate a String with the information of the archangel with that name and then show it on screen.
   * <b>pre:</b> An object of type Main has already been created, as well as the "cantAngelsEntered" and "archInfoByName" methods in the MaximaSuperior class.
   * <b>post:</b> The information is correctly passed to the corresponding method and shows the result on screen.
   */
  public void archInfoByName () {
    if (maximaSuperior.cantAngelsEntered()!=0) {
      System.out.println("\nArchangel's name:");
      String name = lectorstr.nextLine();
      System.out.println(maximaSuperior.archInfoByName(name));
    }
    else
      System.out.println("\nThere is not any archangel registered yet.");
  }

  /**
   * This method asks for the power of an existent archangel to pass its value to a method in MaximaSuperior class in order to generate a String with the information of the archangel with that power and then show it on screen.
   * <b>pre:</b> An object of type Main has already been created, as well as the "cantAngelsEntered" and "archInfoByPower" methods in the MaximaSuperior class.
   * <b>post:</b> The information is correctly passed to the corresponding method and shows the result on screen.
   */
  public void archInfoByPower () {
    if (maximaSuperior.cantAngelsEntered()!=0) {
      System.out.println("\nArchangel's power:");
      String power = lectorstr.nextLine();
      System.out.println(maximaSuperior.archInfoByPower(power));
    }
    else
      System.out.println("\nThere is not any archangel registered yet.");
  }

  /**
   * This method asks for a month to pass its value to a method in MaximaSuperior class in order to generate a String with the celebrations there are in that month and then show it on screen.
   * <b>pre:</b> An object of type Main has already been created, as well as the "monthCelebrations" method in the MaximaSuperior class.
   * <b>post:</b> The information is correctly passed to the corresponding method and shows the result on screen.
   */
  public void monthCelebrations () {
    System.out.println("\nMonth:");
    int month = lectorint.nextInt();
    if (maximaSuperior.monthCelebrations(month).equals(""))
      System.out.println("\nThere are no celebrations on this month.");
    else
      System.out.println(maximaSuperior.monthCelebrations(month));
  }

  /**
   * This method prints all the celebrations there are.
   * <b>pre:</b> The method "allCelebrations" in the MaximaSuperior class has already been created.
   * <b>post:</b> A String shows on screen.
   */
  public void allCelebrations () {
    if (maximaSuperior.allCelebrations().equals("\n"))
      System.out.println("\nThere are no celebrations.");
    else
      System.out.println(maximaSuperior.allCelebrations());
  }
}
