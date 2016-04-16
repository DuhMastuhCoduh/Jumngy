import java.util.ArrayList;


public class GameObjectList {

	private ArrayList<GameObject> list = new ArrayList<GameObject>();
	public GameObjectList()
	{
	}
	
	public int addObject(GameObject g)
	{
		list.add(g);
		return list.size()-1;
	}
	public void removeObject(int index)
	{
		list.remove(index);
	}
	public void removeObject(GameObject g)
	{
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) == g) {
				list.remove(i);
				break;
			}
		}
	}
	
	public Player getPlayer()
	{
		for(GameObject go : list)
		{
			if(go.getID() == ID.PLAYER)
				return (Player) go;
		}
		return null;
	}

	public void renderAll(Windex wind, Camera cam)
	{
		for(GameObject go : list)
		{
			go.render(wind, cam);
		}
	}
	
	public void tickAll(double deltaTime, Camera cam, double w, double h)
	{
		for(GameObject go : list)
		{
			go.tick(deltaTime);
			if(go.getID() == ID.PLAYER)//add more later
			{
				for(GameObject g2 : list)
				{
					if(go == g2)
					{
						continue;
					}
					if(go.isColliding(g2))
					{
						double depthX = go.getPenetrationDepthX(g2);
						double depthY = go.getPenetrationDepthY(g2);
						if(Math.abs(depthX) < Math.abs(depthY))
						{
							go.correctPositionX(depthX);
						}
						else
						{
							go.correctPositionY(depthY);
						}
					}
				}
			}
			if(go.getID() == ID.PLAYER)
				cam.centerOnObject(go, w, h);
		}
	}
	
	public int size()
	{
		return list.size();
	}
}
