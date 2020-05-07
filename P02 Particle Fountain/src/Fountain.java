//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P02 Particle Fountain
// Files: Fountain.java
// Course: CS300 Spring 2019
//
// Author: Austin Torres
// Email: artorres3@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: N/A
// Partner Email: N/A
// Partner Lecturer's Name: N/A
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons:
//
// Aaron Hernandez - ULC tutor. He helped me understand how to utilize the
// position/velocity methods that are within the particle class javadoc, and also how to implement
// transparency
//
// Online Sources:
//
// cs300-www.cs.wisc.edu/wp/wp-content/uploads/2019/01/p2javadocs/Utility.html
// #runApplication
// (Class utility reference)
//
// cs300-www.cs.wisc.edu/wp/wp-content/uploads/2019/01/p2javadocs/
// (Class Particle reference)
//
// https://docs.oracle.com/javase/8/docs/api/java/util/Random.html#nextInt--
// (Class Random reference)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Random;

/**
 * This program creates particles that flow out of the origin like a water fountain. The origin of
 * the fountain is moveable with the click of a mouse, and pressing the 'p' key allows the user to
 * take a screenshot of the screen. This program makes use of the Class Particle and Class Utility,
 * as well as randomly generated values.
 * 
 * @author Austin Torres
 *
 */
public class Fountain {

  /**
   * main entry point for application
   * 
   * @param args (unused)
   */
  public static void main(String[] args) {
    // Creates a new graphical window for this program, calls Fountain.setup() once, and then
    // repeated calls Fountain.update() until the program is terminated.
    Utility.runApplication();
  }


  // middle of the screen (left to right): 400
  private static int positionX;

  // middle of the screen (top to bottom): 300
  private static int positionY;

  // blue: Utility.color(23,141,235)
  private static int startColor;

  // lighter blue: Utility.color(23,200,255)
  private static int endColor;


  // private static Random field created to be able to utilize randomly generated values and
  // initializes field to new Random object
  private static Random randGen = new Random();


  // Creates a private static Particle array field named particles
  private static Particle particles[];



  /**
   * Sets the initial state for the particle locations, particle colors, and background color.
   */
  public static void setup() {
    // create particle array
    particles = new Particle[800];
    // implements tests to ensure particles are updating and being removed correctly
    testUpdateParticle();
    testRemoveOldParticles();
    // set color of background using color method to select a specific amount of RGB
    Utility.background(Utility.color(235, 213, 186));
    // middle of the screen (left to right)
    positionX = 400;
    // middle of the screen (top to bottom)
    positionY = 300;
    // blue
    startColor = Utility.color(23, 141, 235);
    // lighter blue
    endColor = Utility.color(23, 200, 255);
  }

  /**
   * This method is repeatedly called when Utility.runApplication() is ran to update the particles
   * constantly
   */
  public static void update() {
    // repreatedly fills background with specified color so that each drawn circle does not remain
    // after the next circle is drawn
    Utility.background(Utility.color(235, 213, 186));
    // If particle object exists, update the particle
    createNewParticles(10);
    for (int i = 0; i < particles.length; i++) {
      if (particles[i] != null) {
        updateParticle(i);
      }
    }
    // calls to remove particles once their age is 80
    removeOldParticles(80);

  }

  /**
   * Updates each newly created particle colors, positions, velocities, and ages
   * 
   * @param index of particle being updated
   */
  private static void updateParticle(int index) {
    // Set the color of the circle being drawn
    Utility.fill(particles[index].getColor(), particles[index].getTransparency());

    // draws the circle
    Utility.circle(particles[index].getPositionX(), particles[index].getPositionY(),
        particles[index].getSize());

    // set y velocity of circle
    particles[index].setVelocityY(particles[index].getVelocityY() + 0.3f);

    // set x position of circle
    particles[index]
        .setPositionX(particles[index].getVelocityX() + particles[index].getPositionX());

    // set y position
    particles[index]
        .setPositionY(particles[index].getVelocityY() + particles[index].getPositionY());

    // increment age with each update
    particles[index].setAge(particles[index].getAge() + 1);

  }

  /**
   * This creates new particles by checking if there are more null spaces in the particles array
   * that can be turned to particles
   * 
   * @param numParticles is the number of particles that can be created given the space left in the
   *                     particles array
   */
  private static void createNewParticles(int numParticles) {
    // number of particles created
    int count = 0;
    // for all indexes, if the index has no value (particle not created), create a new particle
    for (int i = 0; i < particles.length; i++) {
      if (particles[i] == null) {
        count++;
        particles[i] = new Particle();
        // The following lines allow for variances in the position, velocity, color, and size of
        // the newly created particles
        particles[i].setPositionX((randGen.nextFloat() * 6) - 3 + positionX);
        particles[i].setPositionY((randGen.nextFloat() * 6) - 3 + positionY);
        particles[i].setSize((randGen.nextFloat() * 7) + 4);
        particles[i].setColor(Utility.lerpColor(startColor, endColor, randGen.nextFloat()));
        particles[i].setVelocityX((randGen.nextFloat() * 2) - 1);
        particles[i].setVelocityY(-(randGen.nextFloat() * 5) - 5);//
        particles[i].setAge(randGen.nextInt(41));
        particles[i].setTransparency(randGen.nextInt(96) + 32);

        if (count >= numParticles) {
          return;
        }
      }
    }
  }


  /**
   * search through the particles array for references to particles with an age that is greater than
   * the specified max age. The references to any such particles should be replaced with null
   * references in the particles array
   * 
   * @param maxAge is the oldest a particle can be before being removed
   */
  private static void removeOldParticles(int maxAge) {
    for (int i = 0; i < particles.length; i++) {
      if (particles[i] != null && particles[i].getAge() >= maxAge)
        particles[i] = null;
    }
  }


  /**
   * move the Fountain.positionX and Fountain.positionY to match the position of the mouse whenever
   * the mouse button is pressed to move the origin of the fountain
   * 
   * @param x coordinate of mouse
   * @param y coordinate of mouse
   */
  public static void mousePressed(int x, int y) {
    positionX = x;
    positionY = y;
  }

  /**
   * Whenever designated key is pressed, call Utility.Save() to save a screenshot
   * 
   * @param key that is being pressed on keyboard
   */
  public static void keyPressed(char key) {
    if (key == 'p')
      Utility.save("screenshot.png");
  }



  ///////////////////////////////// tests /////////////////////////////////////

  /**
   * Creates a single particle at position (3,3) with velocity (-1,-2). Then checks whether calling
   * updateParticle() on this particle's index correctly results in changing its position to
   * (2,1.3).
   * 
   * @return true when no defect is found, and false otherwise
   */
  private static boolean testUpdateParticle() {

    particles[0] = new Particle();
    // set initial position and velocity of particle
    particles[0].setPositionX(3.0f);
    particles[0].setPositionY(3.0f);
    particles[0].setVelocityX(-1.0f);
    particles[0].setVelocityY(-2.0f);

    updateParticle(0);
    if (particles[0].getPositionX() == 2.0f && particles[0].getPositionY() == 1.3f) {
      // reset value of particles[0]
      particles[0] = null;
      return true;
    }
    // print error message if test fails
    System.out.println("FAILED");
    // reset value of particles[0]
    particles[0] = null;
    return false;


  }

  /**
   * Calls removeOldParticles(6) on an array with three particles (two of which have ages over six
   * and another that does not). Then checks whether the old particles were removed and the young
   * particle was left alone.
   * 
   * @return true when no defect is found, and false otherwise
   */
  private static boolean testRemoveOldParticles() {
    for (int i = 0; i < 3; i++) {
      particles[i] = new Particle();
    }
    // create new particles in the array with set ages
    particles[0].setAge(10);
    particles[1].setAge(3);
    particles[2].setAge(7);
    // check that only the old particles are removed
    removeOldParticles(6);
    if (particles[0] == null && particles[1] != null && particles[2] == null) {
      particles[1] = null;
      return true;
    }
    particles[0] = null;
    particles[1] = null;
    particles[2] = null;
    // print error message if test fails
    System.out.println("FAILED");
    return false;
  }



}
