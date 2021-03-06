package old.com.gmail.robmadeyou;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.util.Random;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

public abstract class GuiButton implements Gui {
	
	protected int x, y, h, w, number;
	protected int oX, oY, oH, oW;
	protected String state, name;
	protected Texture tex;
	protected int cooldown = 0;
	
	public GuiButton(int x, int y, int w, int h, int number, String state, String name, Texture tex){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.number = number;
		this.state = state;
		this.name = name;
		this.tex = tex;
		this.oX = x;
		this.oY = y;
		this.oH = h;
		this.oW = w;
	}
	@Override
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;

	}

	@Override
	public void setWidth(int w) {
		this.w = w;

	}

	@Override
	public void setHeight(int h) {
		this.h = h;

	}

	@Override
	public boolean isMouseOver(){
		int mX = Mouse.getX();
		int mY = Display.getHeight() - Mouse.getY();
		if(mX > x && mX < x + w && mY > y && mY < y + h ){
			return true;
		}
		return false;
	}
	public void onUpdate(){
		isMouseOver();
	}
	public void expand(int tX, int tY, int tW, int tH){
		if(tX != -1 && x != tX){
			x = tX;
		}
		if(tY != -1 && y != tY){
			y = tX;
		}
		if(tH != -1 && h != tH){
			h = tH;
		}
		if(tW != -1 && w != tW){
			w = tW;
		}
	}
	public void returnToNormal(){
		x = oX;
		y = oY;
		h = oH;
		w = oW;
	}
	public void shakeButton(){
		cooldown++;
		if(cooldown >= 5){
		Random ran = new Random();
		int ranX = ran.nextInt(5);
		int ranY = ran.nextInt(5);
		if(x != oX){
			x = oX;
		}else if(y != oY){
			y = oY;
		}else if(x == oX){
			x += ranX;
		}else if(y == oY){
			y += ranY;
		}
		cooldown = 0;
		}
		
		
	}
	public void draw(){
		
		if(tex != null){
			tex.bind();
		}
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2f(x , y);
			glTexCoord2f(1, 0);
			glVertex2f(x + w, y);
			glTexCoord2f(1, 1);
			glVertex2f(x + w, y + h);
			glTexCoord2f(0, 1);
			glVertex2f(x , y + h);
		glEnd();
	}

}
