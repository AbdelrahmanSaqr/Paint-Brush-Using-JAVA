import java.awt.Graphics;
import java.applet.Applet;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Label;
import java.awt.event.*;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.BasicStroke;



// Shapes Classes;

abstract class Shape{
	
		int px1;
		int py1;
		int px2;
		int py2;
		int color;
		boolean dott;
	
		
		abstract public void draw (Graphics e);
		
	}
	
class Line extends Shape {
	
	public Line(int x, int y, int x2, int y2, int c, boolean dot){
		
		px1= x;
		py1= y;
		px2= x2;
		py2= y2;
		color = c;
		dott = dot;
		
	}
	
	@Override
	public void draw (Graphics e){
		Graphics2D g2d = (Graphics2D)e;
		switch(color) {
				case 1:
					e.setColor(Color.RED);
				break;
				
				case 2:
					e.setColor(Color.GREEN);
				break;
				
				case 3:
					e.setColor(Color.BLUE);
				break;	
				default:
					e.setColor(Color.BLACK);
				break;
			}

			if(dott == true){
			
					  BasicStroke dotted = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
													  0, new float[]{9}, 0);
					  g2d.setStroke(dotted);
				}
				
			else{
					BasicStroke n = new BasicStroke();
					g2d.setStroke(n);
				}
		g2d.drawLine(px1,py1,px2,py2);	
	}
	
	
}

class Rectangle extends Shape {
	
	boolean solid ;
	 
	public Rectangle(int x, int y, int x2, int y2, int c , boolean so, boolean dot){
		
		px1= x;
		py1= y;
		px2= x2;
		py2= y2;
		color = c;
		solid = so;
		dott = dot;
	}
	
	@Override
	public void draw (Graphics e){
		
		Graphics2D g2d = (Graphics2D) e;
		
		if(dott == true){
		
					  BasicStroke dotted = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
													  0, new float[]{9}, 0);
					  g2d.setStroke(dotted);
				}
		else{
					BasicStroke n = new BasicStroke();
					g2d.setStroke(n);
				}
				
				
			switch(color) {
				case 1:
					e.setColor(Color.RED);
				break;
				
				case 2:
					e.setColor(Color.GREEN);
				break;
				
				case 3:
					e.setColor(Color.BLUE);
				break;	
				default:
					e.setColor(Color.BLACK);
				break;
			}
			
			
				
			
			
			if(solid == false){
				g2d.drawRect(px1,py1,px2,py2);
			}	
			else{
				g2d.fillRect(px1,py1,px2,py2);
			}
	}
	
	
}

class Oval extends Shape {
	
	boolean solid;
	
	public Oval(int x, int y, int x2, int y2, int c, boolean so, boolean dot){
		
		px1= x;
		py1= y;
		px2= x2;
		py2= y2;
		color = c;
		solid = so;
		dott = dot;
	}
	
	
	@Override
	public void draw (Graphics e){
		
		Graphics2D g2d = (Graphics2D) e;
		
		if(dott == true){
			
					  BasicStroke dotted = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
													  0, new float[]{9}, 0);
					  g2d.setStroke(dotted);
				}
		else{
					BasicStroke n = new BasicStroke();
					g2d.setStroke(n);
				}
				
			switch(color) {
				case 1:
					e.setColor(Color.RED);
				break;
				
				case 2:
					e.setColor(Color.GREEN);
				break;
				
				case 3:
					e.setColor(Color.BLUE);
				break;	
				default:
					e.setColor(Color.BLACK);
				break;
			}
			
			
		if(solid == false){
				g2d.drawOval(px1,py1,px2,py2);
			}	
			else{
				g2d.fillOval(px1,py1,px2,py2);
			}	
	}
	
	
}	

class Polygon extends Shape {
	
	 
	public Polygon(int x, int y, int x2, int y2, int c){
		
		px1= x;
		py1= y;
		px2= x2;
		py2= y2;
		color = c;
	}
	
	@Override
	public void draw (Graphics e){
		
			switch(color) {
				case 11:
					e.setColor(Color.WHITE);
				break;	
				
				case 1:
					e.setColor(Color.RED);
				break;
				
				case 2:
					e.setColor(Color.GREEN);
				break;
				
				case 3:
					e.setColor(Color.BLUE);
				break;	
				default:
					e.setColor(Color.BLACK);
				break;
			}
			
			e.fillRect(px1,py1,px2,py2);
			
	}
	
	
}


// main class of the program;
public class Painter extends Applet{
	
	int mode = 3; 
	final int line = 0;
	final int rec = 1;
	final int oval = 2;
	final int free = 3;
	final int eraser = 4;
	
	int cmode;
	final int blackm = 0; 
	final int redm = 1;
	final int greenm = 2;
	final int bluem = 3;
	
	int x1,y1,x2,y2;
	boolean s = false;
	boolean dot = false;
	boolean c = false;
	boolean un = false;
	boolean dr = false;
	
	
	
	
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	

	
	Button rectB;
	Button ovalB;
	Button lineB;
	Button freeB;
	Button eraserB;
	
	Button redB;
	Button greenB;
	Button blueB;
	Button blackB;
	
	Button clear;
	Button undo;
	
	Checkbox solid;
	Checkbox dotted;
	
	Label l1;
	Label l2;
	Label l3;
	
	public void init(){
		
		// shapes Button:
		rectB = new Button(" Rectangle ");
		rectB.addActionListener(new rectangle());
		
		ovalB = new Button(" Oval ");
		ovalB.addActionListener(new oval());
		
		lineB = new Button(" Line ");
		lineB.addActionListener(new line());
		
		freeB = new Button(" Pencil ");
		freeB.addActionListener(new free());
		
		eraserB = new Button(" Eraser ");
		eraserB.addActionListener(new eraser());
		
		// colors Button:
		redB = new Button(" Red ");
		redB.addActionListener(new red());
		redB.setBackground(Color.red);

		greenB = new Button(" Green ");
		greenB.addActionListener(new green());
		greenB.setBackground(Color.green);
		
		blueB = new Button(" Blue ");
		blueB.addActionListener(new blue());
		blueB.setBackground(Color.blue);
		
		blackB = new Button(" Black ");
		blackB.addActionListener(new black());
		blackB.setBackground(Color.black);
		
		
		//Finctions Button:
		clear = new Button(" Clear ");
		clear.addActionListener(new clear());
		
		undo = new Button(" Undo ");
		undo.addActionListener(new undo());
		
		solid = new Checkbox("Solid");
		solid.addItemListener(new Solid());
		
		dotted = new Checkbox("Dotted");
		dotted.addItemListener(new dotted());
		
		l1 = new Label(" Functions:");
		l2 = new Label("  Paint Mode:");
		l3 = new Label("  Colors:");
		
		this.addMouseListener(new Click());
		this.addMouseMotionListener(new Drag());
		
		add(l1);
		add(clear);
		add(undo);
		
		add(l2);
		add(lineB);
		add(rectB);
		add(ovalB);
		add(freeB);
		add(eraserB);
		add(solid);
		add(dotted);
		
		add(l3);
		add(blackB);
		add(redB);
		add(greenB);
		add(blueB);
		
		
		
		
		}
	
		
	public void paint(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
		if(c == false){
			for (int i = 0; i < shapes.size(); i++) {
			shapes.get(i).draw(g);
			}
		
			switch(cmode) {
				case 1:
					g.setColor(Color.RED);
				break;
				
				case 2:
					g.setColor(Color.GREEN);
				break;
				
				case 3:
					g.setColor(Color.BLUE);
				break;	
				default:
					g. setColor(Color.BLACK);
				break;
			}
			
			int px = Math.min(x1,x2);
            int py = Math.min(y1,y2);
            int pw=Math.abs(x1-x2);
            int ph=Math.abs(y1-y2);
			
			
			
			 if (un == false){
				
				if(dot == true){
					
					  BasicStroke dotted = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
													  0, new float[]{9}, 0);
					  g2d.setStroke(dotted);
				}
				else{
					BasicStroke n = new BasicStroke();
					g2d.setStroke(n);
				}
				
				switch(mode) {
					case 0:
					
						g2d.drawLine(x1,y1,x2,y2);
				
					
					break;
					
					case 1:
						if(s == false){
							g2d.drawRect(px,py,pw,ph);
						}
						else{
							g2d.fillRect(px,py,pw,ph);
						}
					break;
					
					case 2:
						if(s == false){
							g2d.drawOval(px,py,pw,ph);
						}
						else{
							g2d.fillOval(px,py,pw,ph);
						}
					break;

				
				}
				
			}
			else{
					un = false;
				}
	}
	else{
		c = false; 
	}
	}
	
	
	
		
	// Mouse Listeners;
	class Click extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			
			if(mode == 3){}
			else{
			x1 = e.getX();
			y1 = e.getY();
			}
		}
		
		public void mouseReleased(MouseEvent e){

			x2 = e.getX();
			y2 = e.getY();
			
			if(dr==true){
			
			int px = Math.min(x1,x2);
            int py = Math.min(y1,y2);
            int pw = Math.abs(x1-x2);
            int ph = Math.abs(y1-y2);
			
				switch(mode) {
				case 0:
					shapes.add(new Line(x1,y1,x2,y2,cmode,dot));
				break;
				
				case 1:
					shapes.add(new Rectangle(px,py,pw,ph,cmode,s,dot));
				break;
				
				case 2:
					shapes.add(new Oval(px,py,pw,ph,cmode,s,dot));
				break;
				}
			}
				repaint();
		}
			
	}
		
	class Drag extends MouseMotionAdapter{
		public void mouseDragged(MouseEvent e){
			
			x2 = e.getX();
			y2 = e.getY();
			
			if(mode == 3){
				shapes.add(new Polygon(e.getX(),e.getY(),5,5,cmode));
			}
			else if(mode == 4){
				shapes.add(new Polygon(e.getX(),e.getY(),20,20,11));
			}
			
			dr = true;
			repaint();
		}
	}
	
	
	// checkbox Listeners;
	class Solid implements ItemListener{
		public void itemStateChanged(ItemEvent e){
			if(s != true){
				s = true;
			}
			else{
				s = false;
			}
		}
	}
	
	class dotted implements ItemListener{
		public void itemStateChanged(ItemEvent e){
			if(dot != true){
				dot = true;
			}
			else{
				dot = false;
			}
		}
	}
	
	
	// shapes button Listeners;
	class rectangle implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			mode = 1;
		}
	}
	
	class oval implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			mode = 2;
		}
	}
	
	class line implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			mode = 0;
		}
	}

	class free implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			mode = 3;
		}
	}
	
	class eraser implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			mode = 4;
		}
	}
	
	
	
	// clear and undo button listeners;
	class clear implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			shapes.clear();
			c = true;
			repaint();
		}
	}
	
	class undo implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			
			shapes.remove(shapes.size()-1);
			un = true;
			repaint();
					
		}
	}



	// colors button Listeners;
	class red implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			cmode = 1;  
		}	
	}
			
	class green implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			  cmode = 2;
		}	
	}
	
	class blue implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			cmode = 3;  
		}	
	}
	
	class black implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			cmode = 0;  
		}	
	}	
		
}
		
