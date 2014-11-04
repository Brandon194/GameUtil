package com.Brandon194.java.core;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Driver {
	public static final Path ROOT_FOLDER = Paths.get(System.getenv("APPDATA") + "\\Brandon194\\" + Screen.FRAME_TITLE + "\\");
	
	public static void main(String[] args) {
		launch();
	}
	
	public static void launch() {
		if(Files.exists(ROOT_FOLDER) == false) {
			new FirstLaunch();
		}

		new Screen();
	}
}
