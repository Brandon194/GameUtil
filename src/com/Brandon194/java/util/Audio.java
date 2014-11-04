package com.Brandon194.java.util;

/**
 * This class allows a quick way to utilize TinySound to play music and sound clips.
 * 
 * @author Valkryst
 * --- Last Edit 14-Feb-2013
 */
import kuusisto.tinysound.Music;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;
import misc.Logger;

public class Audio {
    private static Music music; // The music file that is currently being played.

    /**
     * Prepares TinySound for use.
     */
    public static void initalize() {
    	TinySound.init();
    }
    
    /**
     * This method plays a music file.
     * @param path The path to the music file that is going to be played.
     * @param loop Whether the music file should be played on loop or not.
     */
    public static void playMusic(final String path, final boolean loop) {
		music = TinySound.loadMusic(Audio.class.getResource(path));
		
		if (loop) {
		    music.loop();
		    music.play(true);
		}
    }

    /**
     * Set the volume of the music file that is currently being played.
     * @param volume The volume level that the currently playing music file should be played at.
     */
    public static void setVolume(final double volume) {
    	music.setVolume(volume);
    }
    
    /**
     * Set the pan of the music file that is currently being played.
     * @param pan The pan that the currently playing music file should use.
     */
    public static void setPan(final double pan) {
    	music.setPan(pan);
    }

    /**
     * Stops the currently playing music file.
     */
    public static void stopMusic() {
    	music.stop();
    }
    
    /**
     * Pauses the currently playing music file.
     */
    public static void pauseMusic() {
    	music.pause();
    }
    
    /**
     * Resumes the currently playing music file.
     */
    public static void resumeMusic() {
    	music.resume();
    }
    
    /**
     * This method plays a sound file.
     * @param path The path to the music file that is going to be played.
     * @param loop Whether the music file should be played on loop or not.
     * @param loops The number of times to play the sound file.
     */
    public static void playSound(final String path, final boolean loop, final int loops) {
		Sound sound = TinySound.loadSound(Audio.class.getResource(path));
		
		if (loop) {
		    for (int i = 0; i < loops; i++) {
				sound.play();
				try {
				    Thread.sleep(1000);
				} catch (InterruptedException e) {
					Logger.writeLog(e.getMessage(), Logger.LOG_ERROR);
				}
		    }
		} else {
		    sound.play();
		}
    }

    /**
     * Shuts down TinySound.
     */
    public static void shutdown() {
    	TinySound.shutdown();
    }
}
