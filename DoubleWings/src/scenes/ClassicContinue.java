package scenes;
import java.util.Timer;

import constants.WindowConstants;
import game.GameController;
import jplay.GameImage;
import jplay.InputBase;
import jplay.Keyboard;
import jplay.Sprite;
import scenes.menu.MenuScene;
import scenes.stages.stage1.StageTest;
import util.CountDownTimer;
import util.CountDownTimerEnds;

public class ClassicContinue extends GameScene implements CountDownTimerEnds {
		
	// Sprites on scene
	private GameImage background;
	private Sprite wantToContinue;
	private Sprite counter;
	private Sprite enter;
	
	//Thread counter
	//static Thread thread = new Thread(); 
	
	
	public void initialSetup() {
		
		//Configure enter key and escape
		keyboard.setBehavior(Keyboard.ENTER_KEY, InputBase.DETECT_INITIAL_PRESS_ONLY);
		keyboard.setBehavior(Keyboard.ESCAPE_KEY, InputBase.DETECT_INITIAL_PRESS_ONLY);
		
		background = new GameImage("src/assets/img/temp_background.png");
		
		//Define scenes elements position
		//Continue sprite upper-center position
		wantToContinue = new Sprite("src/assets/img/continue/continue.png");
		wantToContinue.x = WindowConstants.WIDTH/2 - wantToContinue.width/2;
		wantToContinue.y = WindowConstants.HEIGHT/2 - wantToContinue.height;
		
		//Number sprite positions
		counter = new Sprite("src/assets/img/continue/number_9.png");
		counter.x = WindowConstants.WIDTH/2 - counter.width/2;
		counter.y = WindowConstants.HEIGHT/1.5 - counter.height/2;
		
		enter = new Sprite("src/assets/img/continue/Enter-Download-PNG.png");
		enter.x = WindowConstants.WIDTH/2 - enter.width/2;
		enter.y = WindowConstants.HEIGHT/500 - enter.height/20;
		
		timeWait();
	}
	
	@Override
	protected void viewSetup() {
		// TODO Auto-generated method stub
		
	}
	
	public void timeWait(){
		
		Timer timer = new Timer();
		CountDownTimer countDownn = new CountDownTimer();
		countDownn.delegate = this;
		long delay = 1000;
		timer.scheduleAtFixedRate(countDownn, delay, delay);
	
	}
	
	public void update() {
		
		background.draw();
		wantToContinue.draw();
		counter.draw();
		enter.draw();
		
		checkButtonSelection();
		
	}
	
	@Override
	public void terminate() {
		if (game != null){
			System.out.println("Timer Ended");
			GameScene gameOver = new GameOver();
			game.transitTo(gameOver);
		}
	}
	
	@Override
	public void updateImageForIndex(int index) {
		counter.loadImage("src/assets/img/continue/number_" + String.valueOf(index) + ".png");
	}
	
	private void checkButtonSelection () {
		
		if(game != null && keyboard != null){
			if (keyboard.keyDown(Keyboard.ENTER_KEY)) {
				//Transit to a continue state of the game
				MenuScene transitScene = new MenuScene();
				game.transitTo(transitScene.firstStage());
				
			} else if (keyboard.keyDown(Keyboard.ESCAPE_KEY)) {
				GameScene menu = new MenuScene();
				game.transitTo(menu);
			}
		}
	}

}
