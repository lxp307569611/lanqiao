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
class MainCanvas extends Canvas
{	

	Image image[][] = new Image[4][3];
	//Image image1,image2,image3,image4;
	Image currentImage;

	int x=120,y=100;

	int upflag=1,downflag=1,leftflag=1,rightflag=1;

	public MainCanvas() {
		try{
			/*
			 i的含义：
			 0：up
			 1: down
			 2: left
			 3: right
			*/
			for(int i=0;i<image.length;i++)
				for(int j=0;j<image[i].length;j++){
					
					image[i][j] = Image.createImage("/sayo"+i+j+".png");
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}

		currentImage = image[1][1];
		
	}
	
	public void keyPressed(int keyCode){

		int action = getGameAction(keyCode);
		
		//上
		if(action==UP) {
			
			if(upflag==1){
				currentImage = image[0][0];
				System.out.println(upflag);
				upflag--;
			}
			else{
				currentImage = image[0][2];
				System.out.println(upflag);
				upflag=1;
			}
			
			//currentImage = image[0][0];
			y=y-1;
		}
		//下
		if(action==DOWN) {
			if(downflag==1){
				currentImage = image[1][0];
				downflag--;
			}
			else{
				currentImage = image[1][2];
				downflag=1;
			}
			y=y+1;
		}
		//左
		if(action==LEFT) {
			if(leftflag==1){
				currentImage = image[2][0];
				leftflag--;
			}
			else{
				currentImage = image[2][2];
				leftflag=1;
			}
			x=x-1;
		}
		//右
		if(action==RIGHT) {
			if(rightflag==1){
				currentImage = image[3][0];
				rightflag--;
			}
			else{
				currentImage = image[3][2];
				rightflag=1;
			}
			x=x+1;
		}
		this.repaint();
	}

	public void paint(Graphics g) {
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImage,x,y,0);
	}
}