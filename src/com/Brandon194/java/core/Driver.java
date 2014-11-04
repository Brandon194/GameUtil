package com.Brandon194.java.core;

import com.Brandon194.java.util.GameRegistry;
import com.Brandon194.java.init.Init;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Driver {
	public static final Path ROOT_FOLDER = Paths.get(System.getenv("APPDATA") + "\\Brandon194\\" + Screen.FRAME_TITLE + "\\");
    public static final GameRegistry REGISTRY = new GameRegistry();
	
	public static void main(String[] args) {
		launch();
	}
	
	public static void launch() {
		if(Files.exists(ROOT_FOLDER) == false) {
			new FirstLaunch();
		}

        Init.preinit();
        Init.init();
        Init.postinit();
		new Screen();
	}
}
