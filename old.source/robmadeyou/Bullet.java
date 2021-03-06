package old.com.gmail.robmadeyou;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.newdawn.slick.opengl.Texture;

public abstract class Bullet implements Entity{
	
	protected int x, y, w, h, enemyNum, toXc, toYc, tOO, ldX, ldY;
	protected double speed;
	protected int target;
	protected boolean hasTarget = false;
	protected boolean isActive = true;
	
	public Bullet(int x, int y, int w, int h, int enemyNum,double speed, int tOO){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.enemyNum = enemyNum;
		this.speed = speed;
		this.tOO = tOO;
		
	}
	@Override
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void setWidth(int width) {
		this.w = width;
	}

	@Override
	public void setHeight(int height) {
		this.h = height;
	}

	@Override
	public void number(int num) {
	}

	@Override
	public void setTexture(Texture tex) {
	}

	@Override
	public void setColor(String color) {
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getWidth() {
		return w;
	}

	@Override
	public int getHeight() {
		return h;
	}
	public void onUpdate(){
		
	}
	@Override
	public void draw() {
		if(Textures.enemy1 != null){
			Textures.enemy1.bind();
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
	
	public void shoot(Entity e, double speed){
		if(hasTarget){
			if(e != null){
			double s = speed * this.speed;
			double toX = 0;
			double toY = 0;
			toX = x -(e.getX() + (e.getWidth() / 2));
			toY = y - (e.getY() + (e.getHeight() / 2));
			toXc = (int) toX;
			toYc = (int) toY;
			double tan = (float) Math.atan2(toX,toY);
				  
			double dX = s*Math.sin(tan);
			double dY = s*Math.cos(tan);
			ldX = (int) dX;
			ldY = (int) dY;
			x -= dX;
			y -= dY;
			}
		}else{
			x -= ldX;
			y -= ldY;
		}
	}
	public void moveAfterShoot(int toX, int toY, double speed){
		x -= ldX;
		y -= ldY;
	}
}
