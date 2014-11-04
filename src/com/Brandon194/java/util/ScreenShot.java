package com.Brandon194.java.util;

import misc.Logger;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


/**
 * This class allows for taking screenshots of what's inside the JFrame.
 * 
 * @author Valkryst
 * --- Last Edit 14-Feb-2013
 */
public class ScreenShot {
	private static Robot robot;
	
	public static void initialize() {
		// Set the robot.
		try {
			robot = new Robot();
		} catch (AWTException e) {
            Logger.writeLog(e.getMessage(),Logger.LOG_WARNING);
		}
		
		// Check if the screenshots folder exists, if it does not then create it.
		File screendirectory = new File("screenshots/");
		if (!screendirectory.exists()) {
			screendirectory.mkdirs();
		}
	}

	public static void screenshot(final KeyboardInputHandler KEY_INPUT, final JFrame frameIn) {
		if(KEY_INPUT.isKeyPressed(KeyEvent.VK_F12)) {
			String screenname = "screenshots/" + "screenshot_";
			String format = ".png";
			int i = 0;

			File file = null;

			do {
				file = new File(screenname + i + format);
				i++;
			} while (file.exists());

			try {
				file.createNewFile();
			} catch (IOException e) {
				Logger.writeLog(e.getMessage(),Logger.LOG_ERROR);
			}

			Rectangle window = new Rectangle(frameIn.getX(), frameIn.getY(), frameIn.getWidth(), frameIn.getHeight());

			BufferedImage img = robot.createScreenCapture(window);
			try {
				ImageIO.write(img, "PNG", file);
			} catch (IOException e) {
				Logger.writeLog(e.getMessage(), Logger.LOG_ERROR);
			}
		}
	}
}
