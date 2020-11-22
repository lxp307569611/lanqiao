import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

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
<<<<<<< HEAD
class MainCanvas extends Canvas implements Runnable
{	
	Thread thread;
	Image heroImage[][] = new Image[4][3];
	//Image image1,image2,image3,image4;
	Image currentImage;

	int heroX,heroY;
	int bossX,bossY;
	int upflag,downflag,leftflag,rightflag;
=======
class MainCanvas extends Canvas
{	

	Image image[][] = new Image[4][3];
	//Image image1,image2,image3,image4;
	Image currentImage;

	int x=120,y=100;

	int upflag=1,downflag=1,leftflag=1,rightflag=1;
>>>>>>> 2e192d1ca9c79ec37a84be8dd665c6048d6fbf8d

	public MainCanvas() {
		try{
			/*
			 i的含义：
			 0：up
			 1: down
			 2: left
			 3: right
			*/
<<<<<<< HEAD
			for(int i=0;i<heroImage.length;i++)
				for(int j=0;j<heroImage[i].length;j++){			
					heroImage[i][j] = Image.createImage("/sayo"+i+j+".png");
			}

			heroX=120;
			heroY=100;

			upflag=1;
			downflag=1;
			leftflag=1;
			rightflag=1;

			bossImg=Image.createImage("/zuzu000.png");
			//Boss线程启动
			thread=new Thread(this);
			thread.start();
=======
			for(int i=0;i<image.length;i++)
				for(int j=0;j<image[i].length;j++){
					
					image[i][j] = Image.createImage("/sayo"+i+j+".png");
			}
			
>>>>>>> 2e192d1ca9c79ec37a84be8dd665c6048d6fbf8d
		}catch(IOException e){
			e.printStackTrace();
		}

<<<<<<< HEAD
		currentImage = heroImage[1][1];
=======
		currentImage = image[1][1];
>>>>>>> 2e192d1ca9c79ec37a84be8dd665c6048d6fbf8d
		
	}
	
	public void keyPressed(int keyCode){

		int action = getGameAction(keyCode);
		
		//上
		if(action==UP) {
			
			if(upflag==1){
<<<<<<< HEAD
				currentImage = heroImage[0][0];
=======
				currentImage = image[0][0];
>>>>>>> 2e192d1ca9c79ec37a84be8dd665c6048d6fbf8d
				System.out.println(upflag);
				upflag--;
			}
			else{
<<<<<<< HEAD
				currentImage = heroImage[0][2];
=======
				currentImage = image[0][2];
>>>>>>> 2e192d1ca9c79ec37a84be8dd665c6048d6fbf8d
				System.out.println(upflag);
				upflag=1;
			}
			
<<<<<<< HEAD
			//currentImage = heroImage[0][0];
			heroY=heroY-1;
=======
			//currentImage = image[0][0];
			y=y-1;
>>>>>>> 2e192d1ca9c79ec37a84be8dd665c6048d6fbf8d
		}
		//下
		if(action==DOWN) {
			if(downflag==1){
<<<<<<< HEAD
				currentImage = heroImage[1][0];
				downflag--;
			}
			else{
				currentImage = heroImage[1][2];
				downflag=1;
			}
			heroY=heroY+1;
=======
				currentImage = image[1][0];
				downflag--;
			}
			else{
				currentImage = image[1][2];
				downflag=1;
			}
			y=y+1;
>>>>>>> 2e192d1ca9c79ec37a84be8dd665c6048d6fbf8d
		}
		//左
		if(action==LEFT) {
			if(leftflag==1){
<<<<<<< HEAD
				currentImage = heroImage[2][0];
				leftflag--;
			}
			else{
				currentImage = heroImage[2][2];
				leftflag=1;
			}
			heroX=heroX-1;
=======
				currentImage = image[2][0];
				leftflag--;
			}
			else{
				currentImage = image[2][2];
				leftflag=1;
			}
			x=x-1;
>>>>>>> 2e192d1ca9c79ec37a84be8dd665c6048d6fbf8d
		}
		//右
		if(action==RIGHT) {
			if(rightflag==1){
<<<<<<< HEAD
				currentImage = heroImage[3][0];
				rightflag--;
			}
			else{
				currentImage = heroImage[3][2];
				rightflag=1;
			}
			heroX=heroX+1;
=======
				currentImage = image[3][0];
				rightflag--;
			}
			else{
				currentImage = image[3][2];
				rightflag=1;
			}
			x=x+1;
>>>>>>> 2e192d1ca9c79ec37a84be8dd665c6048d6fbf8d
		}
		this.repaint();
	}

<<<<<<< HEAD
	//重写run方法
	public void run(){
		while(true){
			try
			{
				Thread.sleep(200);//FPS：屏幕刷新率
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
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
			repaint();
		}
	}

	public void paint(Graphics g) {
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImage,heroX,heroY,0);
=======
	public void paint(Graphics g) {
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImage,x,y,0);
>>>>>>> 2e192d1ca9c79ec37a84be8dd665c6048d6fbf8d
	}
}