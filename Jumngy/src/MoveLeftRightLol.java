
public class MoveLeftRightLol implements MovementMethod {

	private double curTime;
	private final double total;
	private boolean left;
	private double speed;
	
	public MoveLeftRightLol(double total, double speed) {
		curTime = 0;
		this.total = total;
		left = false;
		this.speed = speed;
	}

	@Override
	public void move(GameObject o, double dt) {
		curTime += dt;
		if(curTime >= total)
		{
			if(left)
			{
				o.setxV(-speed);
			}
			else
			{
				o.setxV(speed);
			}
			left = !left;
			curTime = 0;
		}
	}

}
