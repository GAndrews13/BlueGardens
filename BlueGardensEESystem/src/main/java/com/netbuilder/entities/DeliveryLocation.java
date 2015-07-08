package com.netbuilder.entities;

public enum DeliveryLocation {

	SECTOR_A("A"),
	SECTOR_B("B"),
	SECTOR_C("C"),
	SECTOR_D("D"),
	SECTOR_E("E"),
	SECTOR_F("F"),
	SECTOR_G("G"),
	SECTOR_H("H"),
	SECTOR_I("I"),
	SECTOR_J("J"),
	SECTOR_K("K"),
	SECTOR_L("L");
	
	private final String name;       

    private DeliveryLocation(String s) {
        name = s;
    }

    public boolean equalsName(String otherName){
        return (otherName == null)? false:name.equals(otherName);
    }

    public String toString(){
       return name;
    }
}

