import processing.core.PApplet;
import processing.core.PImage; // import the PImage library

/**
* A program Sketch.java that displays animated objects and parabolic movement of an object
* @author: Avin A.
*
*/


public class Sketch extends PApplet {

  // declare global image variables 
  
  PImage imgSponge1;
  PImage imgSponge2;
  PImage imgSquid1;
  PImage imgSquid2;
  PImage imgKrabs1;
  PImage imgKrabs2;
  PImage imgKrabs3;
  PImage imgKrabs4;
  PImage imgMoney;
  PImage imgBackground;

  // declare global variables (such as coordinates)
  
  float fltSpongeX = 120;
  float fltSpongeY = 280;
  float fltSpongeSpeedX = 5;

  float fltKrabsX = 350;
  float fltKrabsY = 250;
  float fltKrabsSpeedX = 2;

  float fltMoneyX = 350;
  float fltMoneyY = 50;
  float fltMoneySpeed = 2;

  boolean drawsSpongeTwo = false;
  int intCntAddToSpongeX = 0;

  boolean drawSquidTwo = false;
  int intCntToCloseSquidEyes = 0;

  boolean drawOtherKrabs = false;
  int intCntAddToKrabsX = 0;

  
  /**
   * Initial settings happens in it
   *
   */
  public void settings() {
    size(600, 400);
  }

  /**
   * Is called once and to set the initial environment code is to happen in
   *
   */
  public void setup() {
    // load images and resize if necessary
  
    imgSponge1 = loadImage ("SpongeLeft.png");
    imgSponge1.resize (80, 120);

    imgSponge2 = loadImage ("SpongeRight.png");
    imgSponge2.resize (80, 120);

    imgSquid1 = loadImage ("Squidward1.png");
    imgSquid1.resize (135, 220);

    imgSquid2 = loadImage ("Squidward2.png");
    imgSquid2.resize (135, 220);

    imgKrabs1 = loadImage ("MrKrabs1.png");
    imgKrabs1.resize (80, 90);
    imgKrabs2 = loadImage ("MrKrabs2.png");
    imgKrabs2.resize (80, 90);
    imgKrabs3 = loadImage ("MrKrabs3.png");
    imgKrabs3.resize (80, 90);
    imgKrabs4 = loadImage ("MrKrabs4.png");
    imgKrabs4.resize (80, 90);

    imgMoney = loadImage ("Money.png");
    
    imgBackground = loadImage ("Background.jpg");
    imgBackground.resize (width, height);
  }

  /**
   * Is called continuously and executes the codes within it infinite times
   *
   */
  public void draw() {
	  background (0);
    // show background behind everything
    image (imgBackground, 0, 0);

    // variable to count loops and reset after 20 times, set value for boolean drawOtherKrabs 
    if (intCntAddToKrabsX == 20) {
      intCntAddToKrabsX = 0;
      if (drawOtherKrabs == false) {
        drawOtherKrabs = true;
      }
      else {
        drawOtherKrabs = false;
      }
    }

    // based on boolean and direction of moving, MrKrabs changes figures
    if (drawOtherKrabs) {
      if (fltKrabsSpeedX > 0) {
        image (imgKrabs3, fltKrabsX,fltKrabsY);
      }
      else {
        image (imgKrabs1, fltKrabsX,fltKrabsY);
      }
    }
    else {
      if (fltKrabsSpeedX > 0) {
        image (imgKrabs4, fltKrabsX,fltKrabsY);
      }
      else {
        image (imgKrabs2, fltKrabsX,fltKrabsY);
      }
    }

    fltKrabsX += fltKrabsSpeedX;
    intCntAddToKrabsX ++;

    // declare limits for where MrKrabs changes direction and bounces off the edges
    if (fltKrabsX < 150 || fltKrabsX > 350) {
      fltKrabsSpeedX *= -1;
    }

    // variable to declare Squidward's figure
    intCntToCloseSquidEyes ++;

    // variable to count loops and reset after 30 times, set value for boolean drawSquidTwo 
    if (intCntToCloseSquidEyes == 30) {
      intCntToCloseSquidEyes = 0;
      if (drawSquidTwo == false) {
        drawSquidTwo = true;
      }
      else {
        drawSquidTwo = false;
      }
    }

    // based on boolean, Squidward changes figures
    if (drawSquidTwo == false) {
      image (imgSquid1, 18, 225);
    }
    else {
      image (imgSquid2, 18, 225);
    }

    // variable to count loops and reset after 12 times, set value for boolean drawsSpongeTwo 
    if (intCntAddToSpongeX >= 12) {
      intCntAddToSpongeX = 0;
      if (drawsSpongeTwo == false) {
        drawsSpongeTwo = true;
      }
      else {
        drawsSpongeTwo = false;
      }
    }

    // based on boolean, SpongeBob changes figures
    if (drawsSpongeTwo == false) {
      image (imgSponge1, fltSpongeX, fltSpongeY);
    }
    else {
      image (imgSponge2, fltSpongeX, fltSpongeY);
    }
    
    fltSpongeX += fltSpongeSpeedX;
    intCntAddToSpongeX ++;
    
    // declare limits for where SpongeBob changes direction and bounces off an edge and Squidward
    if (fltSpongeX < 120 || fltSpongeX > width - 80) {
      fltSpongeSpeedX *= -1;
    }

    image (imgMoney, fltMoneyX, fltMoneyY);

    // parabolic movement for money
    fltMoneyX -= fltMoneySpeed;
    float fltMoneyXTemp = fltMoneyX - 250;
    float fltMoneyYTemp = (float) Math.sqrt (10000 - Math.pow (fltMoneyXTemp, 2));
    fltMoneyY = 50 + fltMoneyYTemp;

    // declare limits for money to change direction 
    if (fltMoneyX == 150 || fltMoneyX == 350) {
      fltMoneySpeed *= -1;
    }  

  }
  
}