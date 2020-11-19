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
	public void startApp(){}
	public void destroyApp(boolean unc){}
	public void pauseApp(){}
}

class MainCanvas extends Canvas
{	
	Image img_up[] = new Image[3];
	Image img_down[] = new Image[3];
	Image img_left[]= new Image[3];
	Image img_right[] = new Image[3];
	Image currentImage = Image.createImage("sayo00.png");
	
	int upflag=1,downflag=1,leftflag=1,rightflag=1;

	int x=120;
	int y=100;

	public MainCanvas(){
		try{
			
			for(int i=0;i<img_up.length;i++){
				img_up[i] = Image.createImage("/sayo"+i+"4.png");
			}
			//上
			/*
			img_up0=Image.createImage("/sayo04.png");
			img_up2=Image.createImage("/sayo24.png");
			*/


			for(int i=0;i<img_down.length;i++){
				img_down[i] = Image.createImage("/sayo"+i+"0.png");
			}
			//下
			/*
			img_down0=Image.createImage("/sayo00.png");
			img_down2=Image.createImage("/sayo20.png");
			*/


			for(int i=0;i<img_left.length;i++){
				img_left[i] = Image.createImage("/sayo"+i+"2.png");
			}
			//左
			/*
			img_left0=Image.createImage("/sayo02.png");
			img_left2=Image.createImage("/sayo22.png");
			*/


			for(int i=0;i<img_right.length;i++){
				img_right[i] = Image.createImage("/sayo"+i+"6.png");
			}
			//右
			/*
			img_right0=Image.createImage("/sayo06.png");
			img_right2=Image.createImage("/sayo26.png");
			*/
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	//上下左右键信息的获取
	public void keyPressed(int keyCode){

		int action=getGameAction(KeyCode);

		if(action == UP) {
			if(upflag==1){
				currentImage = img_up[0];
				upflag++;
			}else {
				currentImage = img_up[2];
				upflag = 1;
			}
			y=y-1;
		} 

		if (action == DOWN)
		{
			if(upflag==1){
				currentImage = img_down[0];
				downflag++;
			}else {
				currentImage = img_down[2];
				downflag = 1;
			}
			y=y+1
		}

		if (action == LEFT)
		{
			if(leftflag==1){
				currentImage = img_left[0];
				leftflag++;
			}else {
				currentImage = img_left[2];
				leftflag = 1;
			}
			x=x-1;
		} 

		if (action == RIGHT)
		{
			if(upflag==1){
				currentImage = img_up[0];
				upflag++;
			}else {
				currentImage = img_up[2];
				upflag = 1;
			}
			x=x+1;
		}
		//刷新页面
		this.repaint();
	}

	
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImage,120,100,0);
	}
}