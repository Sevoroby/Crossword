package crossword;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Drawing extends JPanel{
static Dimension dim;
static boolean horizontal, first=true;
static int x, z, y, i, c=0, numberHor=0, numberVert=0, CellHeight, CellWidth, space=0;

void DrawCells(Graphics2D g2d,boolean horizontal,int length,int shiftX,int shiftY)
{
if (horizontal)
        {
        for (z=1;z<=length;z++)
            {      
            g2d.setColor(Color.BLACK);
            Line2D UpperEdge =  new Line2D.Double(c+CellWidth*shiftX,CellHeight*shiftY,CellWidth+c+CellWidth*shiftX,CellHeight*shiftY);
            Line2D BottomEdge= new Line2D.Double(c+CellWidth*shiftX,CellHeight+(CellHeight*shiftY),CellWidth+c+CellWidth*shiftX,CellHeight+(CellHeight*shiftY));
            Line2D RightEdge = new Line2D.Double(CellWidth+c+CellWidth*shiftX,CellHeight*shiftY,CellWidth+c+CellWidth*shiftX,CellHeight+(CellHeight*shiftY));
            Line2D LeftEdge = new Line2D.Double(c+CellWidth*shiftX,CellHeight*shiftY,c+CellWidth*shiftX,CellHeight+(CellHeight*shiftY));
            g2d.draw(UpperEdge);
            g2d.draw(BottomEdge);
            g2d.draw(LeftEdge);
            g2d.draw(RightEdge);
            if (z==1)
                {   
                g2d.setColor(Color.GREEN.darker());
                ++numberHor;
                System.out.println(numberHor);
                g2d.drawString(String.valueOf(numberHor), (int) LeftEdge.getP1().getX()+2, (int)UpperEdge.getP1().getX()+10);
                }
            c+=CellWidth;
            } 
        }
        else
        {
            numberVert++;
            for (z=1;z<=length;z++)
            {       
                g2d.setColor(Color.BLACK);
                Line2D UpperEdge =  new Line2D.Double(CellWidth*shiftX,c+CellHeight*shiftY,CellWidth+CellWidth*shiftX,c+CellHeight*shiftY);
                Line2D BottomEdge = new Line2D.Double(CellWidth*shiftX,c+CellHeight+(CellHeight*shiftY),CellWidth+CellWidth*shiftX,c+CellHeight+(CellHeight*shiftY));
                Line2D LeftEdge = new Line2D.Double(CellWidth+CellWidth*shiftX,c+CellHeight*shiftY,CellWidth+CellWidth*shiftX,c+CellHeight+(CellHeight*shiftY));
                Line2D RightEdge = new Line2D.Double(CellWidth*shiftX,c+CellHeight*shiftY,CellWidth*shiftX,c+CellHeight+(CellHeight*shiftY));
                g2d.draw(UpperEdge);
                g2d.draw(BottomEdge);
                g2d.draw(LeftEdge);
                g2d.draw(RightEdge);
            if (z==1) 
            {   
                g2d.setColor(Color.GREEN.darker());
                g2d.drawString(String.valueOf(z), (int) LeftEdge.getP1().getX()+1, (int)UpperEdge.getP1().getX()+9);
            }
            c+=CellHeight;
           }
       }
       c=0;
}

public Dimension getPreferredSize() {
Dimension d = new Dimension(640,480);
dim=d;
return d;
}

@Override
public void paintComponent(Graphics g){
super.paintComponent(g);
Graphics2D g2d = (Graphics2D)g;
g2d.setFont(new Font("Font", 1 ,11));
CellHeight=dim.height/16;
CellWidth=dim.width/25;
Random randI = new Random();
Random randY = new Random();
int randomI=0;
int randomY=0;
String[][] crossWords = new String[20][20];
char[][][] crossLetter = new char[20][20][5];
char[] word1;
char[] word2;
String[] words = new String[10];
words[0]= "стручок";
words[1]= "кисть";
words[2]= "четыре";
words[3]= "один";
words[4]= "редька";
words[5]= "капустные";
words[6]= "шесть";
words[7]= "ярутка";
words[8]= "хрен";
words[9]= "кольраби";
i=0;   
for (x=0;x<words.length;x++)
    {
    for(y=x;y<words.length;y++)
        {
        if (x!=y)
            {
            word1=words[x].toCharArray();
            word2=words[y].toCharArray();
            for (char letter1 :word1)
                {
                for (char letter2: word2)
                if (letter1 == letter2) 
                    {   
                    crossWords[x][y]=words[y];
                    crossLetter[x][y][i]=letter1;
                    i++;
                    }
                }
                i=0;
            }
        }
    }
y=0;x=0;i=0;
for (char crossLetterX[][]: crossLetter)
    {
    for (char crossLetterY[]: crossLetterX)
        {
        for (char crossLetterI: crossLetterY) if (crossLetterI!=0) i++;
        if (i==0) {y++;continue;}
        randomI=randI.nextInt(i);
        System.out.println(crossLetter[x][y][randomI] + " y=" + y + " " + words[x] + " " + words[y]);
        DrawCells(g2d, true,  words[y].length(), 0, 0);
        //DrawCells(g2d, true,  words[y].length(), 7, 6);
        //DrawCells(g2d, true,  words[y].length(), 4, 5);
        y++;
        i=0;
        }
    y=0;
    x++;
    }              
}   
}
