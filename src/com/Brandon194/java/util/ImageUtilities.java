package com.Brandon194.java.util;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;

/**
 * Methods that are commonly used throughout the program.
 * 
 * @author Valkryst
 * --- Last Edit 24-Oct-2013
 */
public class ImageUtilities {
	private static GraphicsConfiguration graphicsConfiguration = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
	
	/**
	 * Checks if the specified image is already compatible with the current display.
	 * If the image is compatible with the current display then return the image as-is.
	 * If the image isn't compatible with the current display then run the code to make it compatible then return the compatible image.
	 * 
	 * @param image The image to make compatible.
	 * @return Returns either the same image that came in or the compatible version of that image. 
	 */
	public static BufferedImage toCompatibleImage(BufferedImage image) {
		// Check if the image is compatible with the current display. If it is then return the image, else make the image compatible and return it.
		if(image.getColorModel().equals(graphicsConfiguration)) {
			return image;
		} else {
			// Create a Buffered Image compatible with the current display.
			BufferedImage newImage = graphicsConfiguration.createCompatibleImage(image.getWidth(), image.getHeight(), image.getTransparency());
			
			// Create a graphics context and render the incompatible image onto the compatible image.
			Graphics2D g = newImage.createGraphics();
			g.drawImage(image, 0, 0, null);
			
			// Dispose the old image and return the new compatible image.
			g.dispose();
			image.flush();
			
			return newImage;
		}
	}
}

