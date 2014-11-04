package com.Brandon194.java.tiles;

import com.Brandon194.java.references.Names;
import com.Brandon194.java.util.Dictionary;

/**
 * Created by Brandon194 on 11/3/2014.
 */
public class TileBrick extends Tile{
    public TileBrick(String name, int id){
        super(name, id);
        setTexture(Names.Tiles.BRICK);
    }

    @Override
    public String getBreakableToolType(){ return Dictionary.Tools.PICKAXE; }

    @Override
    public int getBreakableToolTier(){ return 1; }
}
