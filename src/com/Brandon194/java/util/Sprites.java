package com.Brandon194.java.util;

import com.Brandon194.java.core.Driver;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;import java.lang.Override;import java.lang.String;

import javax.imageio.ImageIO;

public class Sprites {
	/**
	 * Loads all sprite files in the specified directory.
	 * @param FILE_PATH The directory from which to load the sprite files.
	 * @return The sprites.
	 * @throws IOException If an error occurs during reading.
	 */
	public static BufferedImage[] loadSprites(final String NAME) throws IOException {
		BufferedImage[] sprites;



		File f = new File(Driver.ROOT_FOLDER + "//reources/tiles//" + NAME);

		FilenameFilter filter = new FilenameFilter() {
			@Override
		    public boolean accept(File dir, String name) {
				name = name.toLowerCase();
				return (name.endsWith(".png") || name.endsWith(".jpg"));
		    }
		};

		File[] spriteFiles = f.listFiles(filter);
		sprites = new BufferedImage[spriteFiles.length];
		
		for(int i=0;i<spriteFiles.length;i++) {
			sprites[i] = ImageUtilities.toCompatibleImage(ImageIO.read(spriteFiles[i]));
		}
		
		return sprites;
	}
	
	/**
	 * Loads a single sprite from the specified path.
	 * @param FILE_PATH The path to the file to load.
	 * @return The sprite.
	 * @throws IOException If an error occurs during reading.
	 */
	public static BufferedImage loadSprite(final String FILE_PATH) throws IOException {
		return ImageUtilities.toCompatibleImage(ImageIO.read(new File(Driver.ROOT_FOLDER + FILE_PATH)));
	}
}
