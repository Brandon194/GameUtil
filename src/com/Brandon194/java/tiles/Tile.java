package com.Brandon194.java.tiles;

import com.Brandon194.java.core.Driver;
import com.Brandon194.java.core.ItemStack;
import com.Brandon194.java.util.Dictionary;
import com.Brandon194.java.util.Sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import com.Brandon194.java.util.Sprites;
import com.Brandon194.java.world.World;
import misc.Logger;

/**
 * Created by Brandon194 on 11/3/2014.
 */
public class Tile {

    private String name;
    private int id;
    private BufferedImage[] SPRITES;

    public Tile(String name, int ID){
        this.name = name;
        this.id = ID;
    }

    protected void setTexture(String textureName){
        try {
            SPRITES = Sprites.loadSprites(Sprites.TILE, textureName);
        }catch(IOException e){
            Logger.writeLog("Texture not found", Logger.LOG_WARNING);
        }
    }

    public String getName(){ return name; }

    public float getHardness(){
        return 0.1F;
    }

    public BufferedImage[] getSprites(){ return SPRITES; }

    public ItemStack getDrops(){
        return new ItemStack(this, 1);
    }

    public String getBreakableToolType(){
        return null;
    }

    public int getBreakableToolTier(){
        return 0;
    }

    public String getDictionaryName() { return Dictionary.Tile.DIRT; }

    public int getSpawnLevelMin() { return 0; }

    public int getSpawnLevelMax() { return 256; }

    public int getSpawnRate() { return 70; }

    public boolean doesSpawnInGen(){ return false; }

    public void onBreak(World world, int x, int y){
        world.spawnItemStack(getDrops(), x, y);
    }
}
