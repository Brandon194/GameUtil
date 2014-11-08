package com.Brandon194.java.util;

import com.Brandon194.java.world.World;
import com.Brandon194.java.entities.Entity;
import com.Brandon194.java.items.Item;
import com.Brandon194.java.tiles.Tile;
import misc.Logger;

import java.util.Random;

/**
 * Created by Brandon194 on 11/3/2014.
 */
public class GameRegistry {

    Tile[] tiles;
    Entity[] entities;
    Item[] items;
    World[] worlds;

    public GameRegistry(){
        tiles = new Tile[1];
        entities = new Entity[1];
        items = new Item[1];
        worlds = new World[1];
    }

    public void addItem(Item item){
        items[items.length-1] = item;
        Item[] temp = new Item[items.length+1];

        for (int i =0;i<items.length;i++){
            temp[i] = items[i];
        }

        items = temp;
    }
    public void addTile(Tile t){
        tiles[tiles.length-1] = t;
        Tile[] temp = new Tile[tiles.length+1];

        for (int i =0;i<tiles.length;i++){
            temp[i] = tiles[i];
        }

        tiles = temp;
    }
    public void addEntity(Entity e){
        entities[entities.length-1] = e;
        Entity[] temp = new Entity[entities.length+1];

        for (int i =0;i<entities.length;i++){
            temp[i] = entities[i];
        }

        entities = temp;
    }
    public void addWorld(World w){
        worlds[worlds.length-1] = w;
        World[] temp = new World[worlds.length+1];

        for (int i =0;i<worlds.length;i++){
            temp[i] = worlds[i];
        }

        worlds = temp;
    }

    public Item[] getItems() {
        return items;
    }
    public Tile[] getTiles(){
        return tiles;
    }
    public Entity[] getEntities(){
        return entities;
    }
    public World[] getWorlds(){
        return worlds;
    }

    public int getItemSize(){
        return items.length;
    }
    public int getTileSize(){
        return tiles.length;
    }
    public int getWorldSize(){
        return worlds.length;
    }
    public int getEntitySize(){
        return entities.length;
    }

    public Tile getRandomTile(int y, int seed){
        Tile[] temp = new Tile[tiles.length*100];
        int count = 0;

        for(int i=0;i<tiles.length;i++){
            if (tiles[i] != null) {
                tiles[i].getName();

                if (tiles[i].getSpawnLevelMax() >= y && tiles[i].getSpawnLevelMin() <= y) {
                    for (int j = 0; j < tiles[i].getSpawnRate(); j++) {
                        temp[count] = tiles[i];
                        count++;
                    }
                }
            }
        }

        int ran = Math.abs(seed) % count;
        //Logger.writeLog("" + Math.abs(seed) + "%" + count + " " + ran, Logger.LOG_DEBUG);
        return temp[ran];

        //return temp[0];
    }
}
