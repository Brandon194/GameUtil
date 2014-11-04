package com.Brandon194.java.init;

import com.Brandon194.java.references.Names;
import com.Brandon194.java.tiles.TileGrass;
import com.Brandon194.java.util.GameRegistry;

/**
 * Created by Brandon194 on 11/3/2014.
 */
public class Init {


    public static void preinit(GameRegistry registry){
        //Tiles
        {
            TileGrass grass = new TileGrass(Names.Tiles.GRASS, registry.getTileSize());

            registry.addTile(grass);
        }
    }

    public static void init(){

    }

    public static void postinit(){

    }
}
