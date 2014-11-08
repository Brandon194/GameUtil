package com.Brandon194.java.core;

import com.Brandon194.java.tiles.Tile;
import com.Brandon194.java.util.Audio;
import com.Brandon194.java.util.KeyboardInputHandler;
import com.Brandon194.java.world.World;
import misc.Logger;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Screen extends Canvas implements Runnable {
	private static final long serialVersionUID = 4532836895892068039L;
	
	private static JFrame frame;
	private Thread gameThread;
	private boolean isGameRunning = true;
	
	private static boolean isGameFullScreen = false;
	public static final String FRAME_TITLE = "GameUtil";
	
	private final KeyboardInputHandler KEY_INPUT = new KeyboardInputHandler();
	private BufferStrategy BS = getBufferStrategy();
	
	private World currentLevel;
	
	private static Dimension screenSize = new Dimension(1024, 548);
	
	public Screen() {
		// Test code:
		 //try {currentLevel = new World(0, "Test", new Dimension(1024, 512)); } catch(IOException e) { e.printStackTrace(); }
		// End test code.
		this.addKeyListener(KEY_INPUT);
		
		frame = new JFrame();
		frame.setTitle(FRAME_TITLE);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setSize(new Dimension(1024, 512));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.requestFocus();
		frame.addWindowListener(new WindowAdapter() { // Runs before the game exits.
			public void windowClosing(WindowEvent e) {
				Audio.shutdown();
				System.exit(0);
			}
		});
		
		setSize(screenSize);
		setFocusable(true);
		setVisible(true);
		
		frame.add(this);
		frame.setVisible(true);
		
		start();
	}

	public void run() {
		long lastLoopTime = System.nanoTime();
	    final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;   
		double delta = 0;
		
		// Keep looping until the game ends.
		while(isGameRunning) {
				long now = System.nanoTime();
				long updateLength = now - lastLoopTime;
				lastLoopTime = now;
			    delta += updateLength / ((double)OPTIMAL_TIME); // Work out how long its been since the last update. This will be used to calculate how far the entities should move this loop.
			    
			    //Update the game's logic and then render the screen.
			    while(delta >= 1) {
			    	updateLogic(delta);
			    	delta--;
			    }


			    render();
			    // we want each frame to take 10 milliseconds, to do this
			    // we've recorded when we started the frame. We add 10 milliseconds
			    // to this and then factor in the current time to give 
			    // us our final value to wait for
			    // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
			    try {
			    	long tempLong = (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000;
			    	if(tempLong <= 0) { continue; } // Skips the sleep()
					Thread.sleep(tempLong);
				} catch (InterruptedException e) {
					continue;
				}
		}
		
		stop();
	}
	
	public synchronized void start() {
		setBackground(Color.black);
		isGameRunning = true;
		gameThread = new Thread(this, "Display");
		gameThread.start();
	}

	public synchronized void stop() {
		try {
			gameThread.join();
		} catch(InterruptedException e) {
			Logger.writeLog(e.getMessage(), Logger.LOG_WARNING);
		}
	}

	// When called this updates all of the game's logic.
	public void updateLogic(double delta) {
		//currentLevel.update(KEY_INPUT);
		// Check whether to take screenshot or not.
		//ScreenShot.screenshot(KEY_INPUT, frame);
	}

	// When called this updates the screen.
	public void render() {
		// Forces the canvas to use triple buffering.
		BS = getBufferStrategy();
        if (BS == null) {
        	SwingUtilities.invokeLater(new Runnable() {
        	    public void run() {
        	        createBufferStrategy(3);
        	    }
        	});
        	return;
        }
		
        // Creates the graphics object and then clears the screen.
        Graphics g = BS.getDrawGraphics();
        g.clearRect(0, 0, getWidth(), getHeight());

        World[] worlds = Driver.REGISTRY.getWorlds();
        for (int i = 0;i<worlds.length;i++){
            if (worlds[i] != null){
                if (worlds[i].isLoading()){
                    worlds[i].render(g);
                }
            }
        }

        //HUD.render(g);
        g.dispose();
		BS.show();
	}
	
	public static void setFullScreen(){
		/*isGameFullScreen = !isGameFullScreen;
		
		if (isGameFullScreen)	FullScreenToggle.setWindowFullScreen(frame, isGameFullScreen);
		else					FullScreenToggle.restoreWindow();
		*/
	}
	
	public static Dimension getScreenSize(){ return screenSize; }
}
