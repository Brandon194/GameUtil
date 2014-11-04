package com.Brandon194.java.init;

import com.Brandon194.java.core.Driver;
import com.Brandon194.java.references.Names;
import com.Brandon194.java.tiles.TileGrass;
import com.Brandon194.java.tiles.TileStone;
import com.Brandon194.java.util.GameRegistry;
import com.Brandon194.java.world.Overworld;
import com.Brandon194.java.world.World;

/**
 * Created by Brandon194 on 11/3/2014.
 */
public class Init {


    public static void preinit(){
        //Worlds
        {
            Driver.REGISTRY.addWorld(new Overworld());
        }
        //Tiles
        {
            Driver.REGISTRY.addTile(new TileGrass(Names.Tiles.GRASS, Driver.REGISTRY.getTileSize()));
            Driver.REGISTRY.addTile(new TileStone(Names.Tiles.STONE, Driver.REGISTRY.getTileSize()));
        }
        //Items
        {

        }
        //Entities
        {

        }
    }

    public static void init(){
        Driver.REGISTRY.getWorlds()[0].load();
    }

    public static void postinit(){

    }
}
