package com.Brandon194.java.world;

import com.Brandon194.java.core.ItemStack;
import com.Brandon194.java.entities.Entity;
import com.Brandon194.java.entities.EntityItemStack;

/**
 * Created by Brandon194 on 11/3/2014.
 */
public class World {

    private int id;

    private long timeOfLastUpdate;
    private boolean loading;

    private Entity[] entityList = new Entity[100];
    private EntityItemStack[] itemStacks = new EntityItemStack[100];

    public World(int id){
        this.id = id;
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
        loading = true;
    }
}
