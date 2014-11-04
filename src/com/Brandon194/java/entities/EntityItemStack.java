package com.Brandon194.java.entities;

import com.Brandon194.java.core.ItemStack;
import com.Brandon194.java.world.World;

/**
 * Created by Brandon194 on 11/3/2014.
 */
public class EntityItemStack extends Entity {

    private ItemStack stack;
    private int secondsPassed = 0;

    public EntityItemStack(ItemStack i, int x, int y){
        super(100, x, y);
        stack = i;
    }

    public void addSecond(){
        secondsPassed++;
    }

    @Override
    public void update(World world, int id){
        this.id = id;
        if (secondsPassed == 300) world.removeItem(id);
    }
}
