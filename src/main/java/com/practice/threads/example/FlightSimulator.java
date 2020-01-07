package com.practice.threads.example;
/**  Builds and starts threads for Airport and Airplanes. */
public final class FlightSimulator {

  public static void main(String... arguments) {
    System.out.println( "Running Flight Simulator." );

    //build an airport and start it running
    Airport charlesDeGaulle = new Airport("Charles de Gaulle");
    Thread airport = new Thread( charlesDeGaulle );
    airport.start();

    //build a plane and start it running
    Thread planeOne = new Thread( new Airplane(charlesDeGaulle, "Flight 7875") );
    planeOne.start();

    Thread planeTwo = new Thread( new Airplane(charlesDeGaulle, "Flight 8875") );
    planeTwo.start();
    
    Thread planeThree = new Thread( new Airplane(charlesDeGaulle, "Flight 9875") );
    planeThree.start();
    //notice that this user thread now ends, but the program itself does
    //NOT end since the threads created above are also user
    //threads. All user threads have equal status, and there
    //is nothing special about the thread which launches a program.
    System.out.println("Terminating the original user thread.");
  }
} 
