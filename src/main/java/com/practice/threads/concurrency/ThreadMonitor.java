package com.practice.threads.concurrency;
//  A real-time thread monitor.

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class ThreadMonitor {

  JSpinner jspSampleRate;
  JLabel jlabName;  // shows name of thread
  JLabel jlabState; // shows thread state
  JLabel jlabAlive; // shows isAlive() result
  JLabel jlabPri;   // shows priority
  JLabel jlabRate;  // label for sample rate spinner

  Thread thrd; // reference to thread being monitored

  Timer thrdTimer; // timer for updating thread status

  // Pass in the thread to be monitored.
  ThreadMonitor(Thread t) {
    // Create a new JFrame container.
    JFrame jfrm = new JFrame("Thread Monitor");

    // Specify FlowLayout manager.
    jfrm.getContentPane().setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(240, 160);

    // Terminate the program when the user closes the application.
    // Remove or change this if you like.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    // Store the thread reference.
    thrd = t;

    // Create an integer spinner model.
    SpinnerNumberModel spm =
           new SpinnerNumberModel(100, 1, 5000, 10);

    // Create a JSpinner using the model.
    jspSampleRate = new JSpinner(spm);

    // Set the preferred size of the spinner.
    jspSampleRate.setPreferredSize(new Dimension(50, 20));

    // Add change listener for the Sample Rate spinner.
    jspSampleRate.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent ce) {
        thrdTimer.setDelay((Integer)jspSampleRate.getValue());
      }
    });

    // Make and initialize the labels.
    jlabName = new JLabel("Thread Name: " + thrd.getName());
    jlabName.setPreferredSize(new Dimension(200, 22));
    jlabState = new JLabel("Current State: " + thrd.getState());
    jlabState.setPreferredSize(new Dimension(200, 22));
    jlabAlive = new JLabel("Thread Alive: " + thrd.isAlive());
    jlabAlive.setPreferredSize(new Dimension(200, 22));
    jlabPri = new JLabel("Current Priority: " + thrd.getPriority());
    jlabPri.setPreferredSize(new Dimension(200, 22));
    jlabRate = new JLabel("Sample Rate: ");

    // Create an action listener for the timer.
    // Each time the timer goes off, update the
    // monitor's display.
    ActionListener timerAL = new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        updateStatus();
      }
    };

    // Create the refresh time using timerAL.
    thrdTimer = new Timer(100, timerAL);

    // Use two Boxes to hold the components.
    Box vbox = Box.createVerticalBox();
    vbox.add(jlabName);
    vbox.add(jlabPri);
    vbox.add(jlabState);
    vbox.add(jlabAlive);
    jfrm.add(vbox);

    Box hbox = Box.createHorizontalBox();
    hbox.add(jlabRate);
    hbox.add(jspSampleRate);
    jfrm.add(hbox);

    // Display the frame.
    jfrm.setVisible(true);

    // Start the timer. Each time the timer goes off
    // the monitor display is updated.
    thrdTimer.start();
  }

  // Update the information about the thread.
  void updateStatus() {
    jlabName.setText("Thread Name: " + thrd.getName());
    jlabState.setText("Current State: " + thrd.getState());
    jlabAlive.setText("Thread Alive: " + thrd.isAlive());
    jlabPri.setText("Current Priority: " + thrd.getPriority());
  }
}