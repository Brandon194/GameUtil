package com.Brandon194.java.entities;

import com.Brandon194.java.core.Driver;
import com.Brandon194.java.core.ItemStack;
import com.Brandon194.java.util.Sprites;
import com.Brandon194.java.world.World;

import java.awt.image.BufferedImage;

/**
 * Created by Brandon194 on 11/3/2014.
 */
public class Entity {

    protected int id;
    protected int hp = 100;
    protected int mana = 0;
    protected BufferedImage[] SPRITE = null;
    protected ItemStack[] drops = null;
    protected int x,y;
    protected boolean canJump = false;

    protected double magicResist = 0, armor = 0, ad = 0, ap = 0, speed = 1.0, attackSpeed = 0.5;

    public Entity (int id, int x, int y){
        this.id = id+100;
        this.x = x;
        this.y = y;
    }

    public void update(World world,int i){
        if (hp == 0){ onDeath(world, i); }
    }

    public void onDeath(World world, int i){

        for (int ii=0;ii<drops.length;ii++){
            world.spawnItemStack(drops[i],x,y);
        }

        world.removeEntity(i);
    }

    public void setTexture(){
        try {
            SPRITE = Sprites.loadSprites(Sprites.ENTITY, Driver.RESOURCE_PACK, "player");
        }catch(Exception e){}
    }

    public double getTileX(){
        return x/32;
    }

    public double getTileY(){
        return y/32;
    }
}
