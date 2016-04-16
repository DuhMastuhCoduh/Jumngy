
public class GameObject {

	private float x, y;
	private float xV, yV;
	private float h, w;
	public GameObject(float w, float h) {
		this.w = w;
		this.h = h;
	}
	public void render() {
		
	}
	public void tick(float deltaTime) {
		x += xV * deltaTime;
		y += yV * deltaTime;
	}
	
	
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getxV() {
		return xV;
	}
	public void setxV(float xV) {
		this.xV = xV;
	}
	public float getyV() {
		return yV;
	}
	public void setyV(float yV) {
		this.yV = yV;
	}
	public float getH() {
		return h;
	}
	public void setH(float h) {
		this.h = h;
	}
	public float getW() {
		return w;
	}
	public void setW(float w) {
		this.w = w;
	}
}
