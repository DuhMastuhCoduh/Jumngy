import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class GameObject {

	protected double x, y;
	protected double xV, yV;
	protected double h, w;
	protected ID id;
	protected BufferedImage sprite;
	private MovementMethod m;
	
	public GameObject(double w, double h, ID id, String image)
	{
		this.w = w;
		this.h = h;
		this.id = id;
		try {
			sprite = ImageIO.read(new File(image));
		} catch (IOException e) {
			sprite = null;
			
		}
	}
	public GameObject(double w, double h, ID id, String image, MovementMethod m)
	{
		this(w, h, id, image);
		this.m = m;
	}
	public GameObject(double w, double h, ID id, BufferedImage i)
	{
		this.w = w;
		this.h = h;
		this.id = id;
		sprite = i;
	}
	
	public void render(Windex wind, Camera cam)
	{
		if(sprite == null)
			return;
		if(!cam.shouldRender(x, y, w, h))
			return;
		Graphics g = wind.getBufferGraphics();
		int x = (int) Math.round(cam.translateX(this.x));
		int y = (int) Math.round(cam.translateY(this.y));
		g.drawImage(sprite, x, y, (int)w, (int)h, null);
	}
	public void tick(double deltaTime)
	{
		if(m != null)
			m.move(this, deltaTime);
		x += xV * deltaTime;
		y += yV * deltaTime;
	}
	public boolean isColliding(GameObject other)
	{
		if(x + w <= other.x || x >= other.x + other.w) {
			return false;
		}
		if(y + h <= other.y || y >= other.y + other.h)
		{
			return false;
		}
		return true;
		
	}
	
	public void correctPositionX(double correction)
	{
		x += correction;
	}
	
	public void correctPositionY(double correction)
	{
		y += correction;
		yV = 0;
	}
	
	public double getPenetrationDepthX(GameObject other)
	{
		//if entire box is within
		if(x >= other.x && x + w <= other.x + other.w)
		{
			if(xV > 0)
			{
				return -(x + w - other.x);
			}
			if(xV < 0)
			{
				return other.x + other.w - x;
			}
			if(xV == 0)
			{
				double left = -(x + w - other.x);
				double right = other.x + other.w - x;
				
				if(Math.abs(left) < Math.abs(right))
					return left;
				return right;
			}
		}
		else if(x + w >= other.x && x <= other.x)
		{
			return -(x + w - other.x);
		}
		if(x <= other.x + other.w && x + w >= other.x + other.w)
		{
			return other.x + other.w - x;
		}
		return 0;
	}
	
	public double getPenetrationDepthY(GameObject other)
	{
		if(y >= other.y && y + h <= other.y + other.h)
		{
			if(yV > 0)
			{
				return -(y + h - other.y);
			}
			if(yV < 0)
			{
				return other.y + other.h - y;
			}
			if(yV == 0)
			{
				double top = -(y + h - other.y);
				double bot = other.y + other.h - y;
				if(Math.abs(top) < Math.abs(bot))
					return top;
				
				return bot;
			}
		}
		else if(y + h >= other.y && y < other.y)
		{
			return -(y + h - other.y);
		}
		if(y <= other.y + other.h && y + h > other.y + other.h)
		{
			return other.y + other.h - y;
		}
		return 0;
	}
	
	
	public ID getID() {
		return id;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getxV() {
		return xV;
	}
	public void setxV(double xV) {
		this.xV = xV;
	}
	public double getyV() {
		return yV;
	}
	public void setyV(double yV) {
		this.yV = yV;
	}
	public double getH() {
		return h;
	}
	public void setH(double h) {
		this.h = h;
	}
	public double getW() {
		return w;
	}
	public void setW(double w) {
		this.w = w;
	}
}
