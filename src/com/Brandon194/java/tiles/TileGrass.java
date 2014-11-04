package com.Brandon194.java.tiles;

import com.Brandon194.java.references.Names;
import com.Brandon194.java.util.Dictionary;

/**
 * Created by Brandon194 on 11/3/2014.
 */
public class TileGrass extends Tile{

    public TileGrass(String name, int id){
        super(name, id);
        setTexture(name);
    }

    @Override
    public String getBreakableToolType(){ return Dictionary.Tools.SHOVEL; }

    @Override
    public boolean doesSpawnInGen(){ return true; }
}
