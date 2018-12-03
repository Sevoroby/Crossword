/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crossword;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;


/**
 *
 * @author 1
 */
public class CrosswordFrame extends JFrame{
    Drawing jp;
	public CrosswordFrame() {
		setTitle("Crossword");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                /*
                JMenuBar bar = new JMenuBar();
                addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
                            //System.out.println(e.getKeyCode());
                                if (jp.alt==false && e.getKeyCode()==65) {jp.alt=true;jp.repaint();}
                                if (jp.alt==true && e.getKeyCode()==83) {jp.alt=false;jp.repaint();}
                                if (jp.alt==true && e.getKeyCode()==38) {jp.altI+=1;jp.repaint();}
                                if (jp.alt==true && e.getKeyCode()==40) {jp.altI-=1;jp.repaint();}
				if(jp.alt==false && e.getKeyCode()==40) {jp.inc+=1;jp.repaint();}
                                if(jp.alt==false && e.getKeyCode()==38) {jp.inc-=1;jp.repaint();}
				}
		});
                * */
		jp = new Drawing();
		jp.setBackground(Color.WHITE);
		add(jp);
                requestFocus();
                pack();
        }
}
