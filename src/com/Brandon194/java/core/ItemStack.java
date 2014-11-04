package com.Brandon194.java.core;

import com.Brandon194.java.items.Item;
import com.Brandon194.java.tiles.Tile;
import com.Brandon194.java.world.World;

/**
 * Created by Brandon194 on 11/3/2014.
 */
public class ItemStack {

    private int numOfStack;
    private Tile tile = null;
    private Item item = null;

    public ItemStack(Tile t, int numOfStack){
        tile = t;
        this.numOfStack = numOfStack;
    }

    public ItemStack(Item i, int numOfStack){
        item = i;
        this.numOfStack = numOfStack;
    }

    /*public void onDrop(Player player, World world, int x, int y){
        player.getSelectedItemStack().remove(1);
        if (tile == null) world.spawnItemStack(new  ItemStack(tile, 1), x, y);
        if (item == null) world.spawnItemStack(new ItemStack(item, 1), x, y);
    }*/

   /* public void onPlace(Inventory inv, Slot slot){

    }*/

}
