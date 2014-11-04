package com.Brandon194.java.entities;

import com.Brandon194.java.core.ItemStack;
import com.Brandon194.java.world.World;

/**
 * Created by Brandon194 on 11/3/2014.
 */
public class Entity {

    protected int id;
    protected int hp = 100;
    protected int mana = 0;
    protected ItemStack[] drops = null;
    protected int x,y;
    protected boolean canJump = false;

    protected double magicResist = 0, armor = 0, ad = 0, ap = 0, speed = 1.0, attackSpeed = 0.5;

    public Entity (int id, int x, int y){
        this.id = id;
        this.x = x;
        this.y = y;
    }

    protected void update(World world,int i){
        if (hp == 0){ onDeath(world, i); }
    }

    protected void onDeath(World world, int i){

        for (int ii=0;ii<drops.length;ii++){
            world.spawnItemStack(drops[i],x,y);
        }

        world.removeEntity(i);
    }
}
