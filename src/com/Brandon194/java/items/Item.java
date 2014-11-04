package com.Brandon194.java.items;

import com.Brandon194.java.core.ItemStack;
import misc.Logger;

import javax.swing.ImageIcon;

/**
 * Created by Brandon194 on 11/3/2014.
 */
public class Item {

    private String name;
    private int id;
    private short damageValue = 0;
    private ImageIcon texture = new ImageIcon("resources/textures/noTexture.png");
    private ItemStack drops = null;
    private String dictionaryType = null;
    private int tier = 0;
    private int maxStackSize;

    public Item(String name, int ID){
        this.name = name;
        this.id = ID;
    }

    public void setTexture(String textureName){
        try{
            texture = new ImageIcon(textureName);
        }catch(Exception e){
            Logger.writeLog("Texture not found, resorting to default", Logger.LOG_ERROR);
            texture = new ImageIcon("noTexture.png");
        }
    }

    public void setDamageValue(short damageValue){
        this.damageValue = damageValue;
    }

    public void setDrops(ItemStack i){
        drops = i;
    }

    public void setDictionaryType(String type){
        dictionaryType = type;
    }

    public void setTier(int tier){
        this.tier = tier;
    }

    public ImageIcon getTexture(){
        return texture;
    }

    public float getDamageValue(){
        return damageValue;
    }

    public ItemStack getDrops(){
        return drops;
    }
}
