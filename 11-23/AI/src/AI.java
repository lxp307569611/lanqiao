import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
import java.util.*;


public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas implements Runnable
{	

	//定义一个线程
	Thread thread;
	Image image[][] = new Image[4][3];
	//Image image1,image2,image3,image4;
	Image currentImage,bossImage;
	
	Random rd = new Random();

	int heroX,heroY;
	int bossX,bossY;
	int flag;

	public MainCanvas() {
		try{
			/*
			 i的含义：
			 0：up
			 1: down
			 2: left
			 3: right
			*/
			//图片初始化
			for(int i=0;i<image.length;i++)
				for(int j=0;j<image[i].length;j++){					
					image[i][j] = Image.createImage("/sayo"+i+j+".png");
			}
			bossImage = Image.createImage("/zuzu000.png");
			thread=new Thread(this);
			thread.start();

		}catch(IOException e){
			e.printStackTrace();
		}
		//其余变量初始化
		flag=1;

		heroX=120;
		heroY=100;

		bossX=0;
		bossY=0;

		currentImage = image[1][1];	
	}
	//方向按键方法
	public void keyPressed(int keyCode){
		int action = getGameAction(keyCode);	
		//上
		if(action==UP) {	
			changePicAndDirection(0);
			//currentImage = image[0][0];
			heroY=heroY-1;
		}
		//下
		if(action==DOWN) {
			changePicAndDirection(1);
			heroY=heroY+1;
		}
		//左
		if(action==LEFT) {
			changePicAndDirection(2);
			heroX=heroX-1;
		}
		//右
		if(action==RIGHT) {
			changePicAndDirection(3);
			heroX=heroX+1;
		}
		this.repaint();
	}
	//重写线程run方法
	public void run(){
		while(true){
			int ifMove = rd.nextInt(10);
			System.out.println(ifMove);
			try
			{
				Thread.sleep(200);//FPS：屏幕刷新率
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			if(ifMove%3==0){
				if(bossX<heroX){
					bossX++;
				}
				else{
					bossX--;
				}

				if(bossY<heroY){
					bossY++;
				}else{
					bossY--;
				}
			}
			repaint();
		}
	}
	//自定义方法
	public void changePicAndDirection(int direction){
		if(flag==1){
			currentImage = image[direction][0];
			flag--;
		}else{
			currentImage = image[direction][2];
			flag=1;
		}
	}
	public void paint(Graphics g) {
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImage,heroX,heroY,0);
		g.drawImage(bossImage,bossX,bossY,0);
	}
}