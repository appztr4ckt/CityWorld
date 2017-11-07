package me.daddychurchill.CityWorld.Support.Materials;

import org.bukkit.DyeColor;
import org.bukkit.Material;

public class Stained_Clay extends Stained_Block {

	public Stained_Clay()
	{
		super(Material.STAINED_CLAY);
	}

	public Stained_Clay(DyeColor color)
	{
		this();
		setColor(color);
	}

}
