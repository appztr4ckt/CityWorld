package me.daddychurchill.CityWorld.Plats.Flooded;

import org.bukkit.Material;

import me.daddychurchill.CityWorld.WorldGenerator;
import me.daddychurchill.CityWorld.Plats.PlatLot;
import me.daddychurchill.CityWorld.Plats.Urban.UnfinishedBuildingLot;
import me.daddychurchill.CityWorld.Plugins.ShapeProvider_Flooded;
import me.daddychurchill.CityWorld.Support.PlatMap;

public class FloodedUnfinishedBuildingLot extends UnfinishedBuildingLot {

	private int floodY;
	
	public FloodedUnfinishedBuildingLot(PlatMap platmap, int chunkX, int chunkZ) {
		super(platmap, chunkX, chunkZ);
		
		floodY = platmap.generator.shapeProvider.findHighestFloodY(platmap.generator);
	}

	@Override
	public PlatLot newLike(PlatMap platmap, int chunkX, int chunkZ) {
		return new FloodedUnfinishedBuildingLot(platmap, chunkX, chunkZ);
	}
	
	@Override
	protected byte getAirId(WorldGenerator generator, int y) {
		if (y <= floodY)
			return ShapeProvider_Flooded.floodId;
		else
			return super.getAirId(generator, y);
	}

	@Override
	protected Material getAirMaterial(WorldGenerator generator, int y) {
		if (y <= floodY)
			return ShapeProvider_Flooded.floodMat;
		else
			return super.getAirMaterial(generator, y);
	}
}
