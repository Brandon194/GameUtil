package com.Brandon194.java.core;

import misc.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FirstLaunch {
	
	public static final Path ROOT_FOLDER = Driver.ROOT_FOLDER;
	
	public FirstLaunch() {
		createFolders();
		createREADMEFile();
		//moveResources();
	}

	private void createFolders(){
		try { Files.createDirectories(Paths.get(System.getenv("APPDATA") + "\\Brandon194\\" + Screen.FRAME_TITLE + "\\"));} catch(IOException e){}
		try { Files.createDirectory(ROOT_FOLDER); } catch(IOException e) {}
		try { Files.createDirectory(Paths.get(ROOT_FOLDER + "\\levels\\")); } catch(IOException e) {}
		try { Files.createDirectory(Paths.get(ROOT_FOLDER + "\\config\\")); } catch(IOException e) {}
		try { Files.createDirectory(Paths.get(ROOT_FOLDER + "\\resources\\")); } catch(IOException e) {}
		try { Files.createDirectory(Paths.get(ROOT_FOLDER + "\\resources\\entities")); } catch(IOException e) {}
		try { Files.createDirectory(Paths.get(ROOT_FOLDER + "\\resources\\tiles")); } catch(IOException e) {}
	}
	
	private void createREADMEFile(){
		try { // Write a readme for the game.
			PrintWriter out = new PrintWriter(new FileWriter(ROOT_FOLDER + "\\README.txt", false));
			out.println("TILES:");
			out.println("\tWhen creating new tiles and adding them to the game, make sure that");
			out.println("\tthere are no spaces in the sprite paths. If there are spaces in the");
			out.println("\tpaths the game will mostlikely crash.\n");
			out.println("\tThis may be fixed in the future, but for now the code is being kept");
			out.println("\tas simple as I can possibly make it.");
			out.println("\nSPRITES:");
			out.println("\tAll sprites must be in .png or .jpg format.");
			out.close();
		} catch(IOException e) {
			misc.Logger.writeLog(e.getMessage(), Logger.LOG_WARNING);
		}
	}
	
	private void moveResources() {
	}
}
