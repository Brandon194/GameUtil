package com.Brandon194.java.tiles;

import com.Brandon194.java.references.Names;
import com.Brandon194.java.util.Dictionary;
import com.Brandon194.java.util.GameRegistry;

/**
 * Created by Brandon194 on 11/3/2014.
 */
public class TileStone extends Tile{
    public TileStone(String name, int id){
        super(name, id);
        setTexture(Names.Tiles.STONE);
    }

    @Override
    public String getBreakableToolType(){ return Dictionary.Tools.PICKAXE; }

    @Override
    public int getBreakableToolTier(){ return 1; }

    @Override
    public String getDictionaryName(){ return Dictionary.Tile.STONE; }

    @Override
    public boolean doesSpawnInGen(){ return true; }

}
