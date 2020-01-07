package com.practice.threads.taming;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Hang extends JFrame
{
	public Hang()
	{
		JButton b1 = new JButton("Sleep");
		JButton b2 = new JButton("Hello");
		
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					Thread.currentThread().sleep(5000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("Hello World!");
			}
		});
		
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(b1);
		getContentPane().add(b2);
		
		pack();
		setVisible(true);
	}
	
	public static void main(String args[])
	{
		Hang h = new Hang();
	}
	
}
