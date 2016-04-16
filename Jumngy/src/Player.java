
public class Player extends GameObject {

	private double jumpSpeed = -900;
	private boolean canJump;
	
	public Player(double w, double h) {
		super(w, h, ID.PLAYER, "res/boy1.png");
		canJump = true;
	}

	@Override
	public void tick(double deltaTime)
	{ 
		yV += 1200 * deltaTime;
		super.tick(deltaTime);
	}

	public void jump()
	{
		yV = jumpSpeed;
		canJump = false;
	}
	
	public boolean canJump()
	{
		return canJump;
	}
	
	@Override
	public void correctPositionY(double correction)
	{
		if(correction < 0)
		{
			canJump = true;
		}
		super.correctPositionY(correction);
	}
}
