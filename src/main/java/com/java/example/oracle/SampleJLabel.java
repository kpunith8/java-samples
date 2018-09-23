package com.java.example.oracle;

import java.awt.Container;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SampleJLabel {

    public static void main(String[] args) {
	JFrame f = new JFrame("Hello, World");
	JLabel label = new JLabel("Hello, World");
	Container cont = f.getContentPane();
	cont.add(label);
	f.setSize(400, 400);
	f.setVisible(true);

	label.addKeyListener(new KeyListener() {

	    @Override
	    public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	    }

	    @Override
	    public void keyReleased(KeyEvent e) {
		System.out.println(e.getKeyChar());
	    }

	    @Override
	    public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	    }
	});
	f.addComponentListener(new ComponentListener() {

	    @Override
	    public void componentShown(ComponentEvent e) {

	    }

	    @Override
	    public void componentResized(ComponentEvent e) {
		System.out.println(e.MOUSE_EVENT_MASK);
	    }

	    @Override
	    public void componentMoved(ComponentEvent e) {
		System.out.println(e.paramString());
	    }

	    @Override
	    public void componentHidden(ComponentEvent e) {

	    }
	});
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
