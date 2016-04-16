import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {

	private Camera cam;
	private GameObjectList list;

	public Main()
	{
		list = new GameObjectList(); 
		cam = new Camera(800, 800);
	}

	public void makeBoundaries()
	{
		GameObject floor = new GameObject(1600 * 2, 3000, ID.TILE, "");
		GameObject wallDos = new GameObject(3000, 900 * 20, ID.TILE, "");
		GameObject wallTres = new GameObject(3000, 900 * 20, ID.TILE, "");
		floor.setY(900 * 2 - 230);
		wallDos.setX(-3000);
		wallTres.setX(1600 * 2);
		list.addObject(floor);
		list.addObject(wallDos);
		list.addObject(wallTres);
	}

	public void makepoopyMap()
	{
		Player player = new Player(75 , 75);

		list.addObject(player);
		player.setX(300);
		player.setY(700 * 2);
		MoveLeftRightLol fast = new MoveLeftRightLol(1, 1000);
		MoveLeftRightLol med = new MoveLeftRightLol(1, 100);
		MoveLeftRightLol med2 = new MoveLeftRightLol(1, 100);
		MoveLeftRightLol med3 = new MoveLeftRightLol(1, 100);
		MoveLeftRightLol med4 = new MoveLeftRightLol(1, 100);
		MoveLeftRightLol med5 = new MoveLeftRightLol(1, 100);
		MoveLeftRightLol med6 = new MoveLeftRightLol(1, 100);
		MoveLeftRightLol med7 = new MoveLeftRightLol(1, 100);
		MoveLeftRightLol med8 = new MoveLeftRightLol(1, 100);
		MoveLeftRightLol slow = new MoveLeftRightLol(1, 10);
		MoveLeftRightLol slow2 = new MoveLeftRightLol(1, 10);
		MoveLeftRightLol slow3 = new MoveLeftRightLol(1, 10);
		MoveLeftRightLol slow4 = new MoveLeftRightLol(1, 10);
		MoveLeftRightLol slow5 = new MoveLeftRightLol(1, 10);

		GameObject a = new GameObject(100, 30, ID.TILE, "res/platform.png", fast);
		GameObject b = new GameObject(100, 30, ID.TILE, "res/platform.png", med);
		GameObject c = new GameObject(100, 30, ID.TILE, "res/platform.png", slow);
		GameObject d = new GameObject(100, 30, ID.TILE, "res/platform.png", med2);
		GameObject e = new GameObject(100, 30, ID.TILE, "res/platform.png", med3);
		GameObject f = new GameObject(100, 30, ID.TILE, "res/platform.png", slow2);
		GameObject g = new GameObject(100, 30, ID.TILE, "res/platform.png", slow3);
		GameObject h = new GameObject(100, 30, ID.TILE, "res/platform.png", med4);
		GameObject i = new GameObject(100, 30, ID.TILE, "res/platform.png", med5);
		GameObject j = new GameObject(100, 30, ID.TILE, "res/platform.png", med6);
		GameObject k = new GameObject(100, 30, ID.TILE, "res/platform.png", slow4);
		GameObject l = new GameObject(100, 30, ID.TILE, "res/platform.png", slow5);
		GameObject m = new GameObject(100, 30, ID.TILE, "res/platform.png", med);
		GameObject n = new GameObject(100, 30, ID.TILE, "res/platform.png", med);

		list.addObject(a);
		list.addObject(b);
		list.addObject(c);
		list.addObject(d);
		list.addObject(e);
		list.addObject(f);
		list.addObject(g);
		list.addObject(h);
		list.addObject(i);
		list.addObject(j);
		list.addObject(k);
		list.addObject(l);
		list.addObject(m);
		list.addObject(n);

		a.setX(50); a.setY(1500);
		b.setX(400); b.setY(1400);
		c.setX(750); c.setY(1300);
		d.setX(1100); d.setY(1200);
		e.setX(1450); e.setY(1100);
		f.setX(1800); f.setY(1000);
		g.setX(2150); g.setY(900);
		h.setX(2500); h.setY(800);
		i.setX(2850); i.setY(700);
		j.setX(3200); j.setY(600);
		k.setX(2850 ); k.setY(500);
		l.setX(3200); l.setY(400);
		m.setX(2850); m.setY(300);
		n.setX(2500); n.setY(200);
		//		g.setY(a * (((600 * 2 - 230))/10.f));
		//		g.setX(500);
		//
		//		list.addObject(g);

	}
	private GameObject trump;
	private GameObject trumpHand;
	public void trumpThePlayer()
	{
		trump = new GameObject(100, 100, ID.TRUMPLER, "res/head.png");
		list.addObject(trump);
		trump.setY(100);

		trumpHand = new GameObject(100, 100, ID.TRUMPLER, "res/hand.png");
		list.addObject(trumpHand);
		trump.setY(100);
	}

	public void run()
	{
		BufferedImage firedHand;
		try {
			firedHand = ImageIO.read(new File("res/firedHand.png"));
		} catch (IOException e) {
			return;

		}
		Windex w = new Windex(800, 800, new KeyInput(list));
		Clip c;
		Clip china;
		try {
			c = AudioSystem.getClip();
			china = AudioSystem.getClip();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			return;
		}
		try {
			c.open(AudioSystem.getAudioInputStream(new File("res/churro.wav")));
			china.open(AudioSystem.getAudioInputStream(new File("res/china.wav")));
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		c.loop(Clip.LOOP_CONTINUOUSLY);
		c.start();
		BufferedImage background;
		makeBoundaries();
		makepoopyMap();
		trumpThePlayer();
		try {background = ImageIO.read(new File("res/wall.png"));} catch (IOException e){return;}
		double dt = 0;
		w.setVisible(true);
		float timer = 0;
		boolean shouldSayChina = true;
		while(true)
		{
			long start = System.currentTimeMillis();
			w.getBufferGraphics().drawImage(background, (int)cam.translateX(0), (int)cam.translateY(0), 1600 * 2, 900 * 2, null);
			list.tickAll(dt, cam, 1600 * 2, 900 * 2);
			list.renderAll(w, cam);
			trump.setX(list.getPlayer().getX()+ 100);
			trumpHand.setX(list.getPlayer().getX());
			trump.setY(list.getPlayer().getY()- 400);
			trumpHand.setY(list.getPlayer().getY() - 400);

			if(timer > 0.75f)
			{
				if(shouldSayChina)
				{

					china.stop();
					china.setFramePosition(0);
					china.start();
				}
				shouldSayChina = !shouldSayChina;
				timer = 0;
				GameObject fired = new GameObject(100, 100, ID.TRUMPLETS, firedHand);
				list.addObject(fired);
				fired.setX(trumpHand.getX());
				fired.setY(trumpHand.getY());
				fired.setyV(300);
			}
			if(list.getPlayer().getY() < 50)
			{
				System.out.println("winner!!");
				System.exit(0);
			}

			timer += dt;
			w.swap();
			try 
			{
				Thread.sleep(16);
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			dt = (double)(System.currentTimeMillis() - start) / 1000.f;
		}
	}

	public static void main(String[] args)
	{
		new Main().run();
	}

}