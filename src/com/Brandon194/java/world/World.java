package com.Brandon194.java.world;

import com.Brandon194.java.core.Driver;
import com.Brandon194.java.core.ItemStack;
import com.Brandon194.java.entities.Entity;
import com.Brandon194.java.entities.EntityItemStack;
import com.Brandon194.java.references.Names;
import com.Brandon194.java.tiles.Tile;
import com.Brandon194.java.util.Sprites;
import misc.Logger;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Brandon194 on 11/3/2014.
 */
public class World {

    private long timeOfLastUpdate;
    private boolean loading = false;

    int seed = 0;

    private BufferedImage background;

    private Tile[][] worldTiles = null;

    private Entity[] entityList = new Entity[100];
    private EntityItemStack[] itemStacks = new EntityItemStack[100];

    public World(){

        bg();
        getWorldTiles();
    }

    public World(String seed){
        int serialize = 0;

        for (char c : seed.toCharArray()){
            serialize += (c *1000)+(c*194);
        }

        this.seed = Math.abs(serialize);

        bg();
        getWorldTiles();
    }
    private void bg(){
        try {
            background = Sprites.loadSprites(Sprites.BACKGROUND, Driver.RESOURCE_PACK, "background")[0];
        }catch(IOException e){}
    }
    public void removeEntity(int id){
        entityList[id] = null;
    }
    public int maxWorldHeight(){
        return 256;
    }
    public boolean canSpawnOre(){
        return true;
    }
    public void removeItem(int id){
        itemStacks[id] = null;
    }
    public void unload(){
        loading = true;
    }
    public boolean isLoading(){
        return loading;
    }
    public void spawnEntity(Entity e){
        for (int i=0;i<entityList.length;i++){
            if (entityList[i] ==null) entityList[i] = e;
            return;
        }
    }
    public void spawnItemStack(ItemStack stack, int x, int y){
        for (int i=0; i<itemStacks.length;i++){
            if (itemStacks[i] == null){
                itemStacks[i] = new EntityItemStack(stack, x, y);
                return;
            }
        }
    }
    public void update(){
        // ItemStacks
        for (int i = 0; i < itemStacks.length; i++) {
            itemStacks[i].update(this, i);

            if (itemStacks[i] != null && (timeOfLastUpdate/1000) != (System.currentTimeMillis()/1000)) {
                itemStacks[i].addSecond();
            }
        }
        // End Of ItemStacks

        timeOfLastUpdate = System.currentTimeMillis();
    }
    public void load(){
        timeOfLastUpdate = System.currentTimeMillis();

        if (worldTiles == null){
            generateWorld();
        }

        loading = true;
    }
    public Tile[][] getWorldTiles(){
        return worldTiles;
    }
    public void generateWorld(){
        if (seed == 0) seed = Math.abs((int)System.currentTimeMillis());
        worldTiles = new Tile[3000][this.maxWorldHeight()];



        Tile[] tiles = Driver.REGISTRY.getTiles();

        for (int x=0;x<3000;x++){
            for (int y=0;y<maxWorldHeight();y++){
                worldTiles[x][y] = Driver.REGISTRY.getRandomTile(y, seed);
            }
        }
    }
    public void render(Graphics G){
        if (worldTiles == null){ generateWorld(); }
        for(int i=0;i<1024;i++){
            G.drawImage(background, i, 0, null);
        }

        for (int i=-7;i<Driver.PLAYER.getTileX()+7;i++){
            for (int j=-4;j<Driver.PLAYER.getTileY()+4;j++){

                int tileX = (int)Driver.PLAYER.getTileX();
                int tileY = (int)Driver.PLAYER.getTileY();

                Logger.writeLog("i:"+ (tileX +i) + " j:" + (tileY+j), Logger.LOG_DEBUG);

                try {
                    if (worldTiles[tileX + i][j] != null) {
                        G.drawImage(worldTiles[0][0].getSprites()[0], tileX + (i * 32), tileY + (j * 32), null);
                        Logger.writeLog(worldTiles[i][j].getName(), Logger.LOG_DEBUG);
                    }
                }catch(Exception e){}
            }
        }
    }
}
