package brickGamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;



public class Gamepanel extends JPanel implements KeyListener, ActionListener{
	private boolean play = false;
	private int score =0;
	
	private int totalBricks =21;
	
	private Timer timer;
	private int delay = 8;
	
	private int playerX =300;
	
	private int ballposX =120;
	private int ballposY = 200;
	private int ballXdir =1;
	private int ballYdir =2;
	private MapGenerator map;
	public Gamepanel ()
	{
		map = new MapGenerator(3,7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		timer = new Timer(delay, this);
		timer.start();
	}
	 
public void paint(Graphics g)

{
	//background
	g.setColor(Color.black);
	g.fillRect(1, 1, 692, 592);
	
	//drawing blocks
	map.draw((Graphics2D) g);
	
	
	//borders
	g.setColor(Color.YELLOW);
	g.fillRect(0, 0, 3, 592);
	g.fillRect(0, 0, 692, 3);
	g.fillRect(691, 0, 3, 592);

	//paddle
	g.setColor(Color.green);
	g.fillRect(playerX, 550, 100, 8);
	
	//ball
	g.setColor(Color.blue);
	g.fillOval(ballposX, ballposY, 20, 20);
	
	g.dispose();
	
}


@Override
public void actionPerformed(ActionEvent e) {
	timer.start();
	if(play)
	{
		if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX, 550,100,8)))
		{
			ballYdir=-ballYdir;
		}
		ballposX+=ballXdir;
		ballposY+=ballYdir;
		
		if(ballposX < 0)
		{
			ballXdir=-ballXdir;
		}
		
		if(ballposY < 0)
		{
			ballYdir=-ballYdir;
		}
		if(ballposX >670)
		{
			ballXdir=-ballXdir;
		}
	
	}
	repaint();
}


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if(playerX >=600)
			{
				playerX =600;
			}
			else
			{
				moveRight();
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(playerX <10)
			{
				playerX =10;
			}
			else
			{
				moveLeft();
			}
			
		}
		
		
	}
	
@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void moveRight()
	{
		this.play=true;
		this.playerX+=20;
	}
	
	public void moveLeft()
	{
		this.play=true;
		this.playerX-=20;
	}


}
