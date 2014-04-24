package se.antonnyman.solarsystemgrid;

public class Planet {
	
	public static final String NAME = "name";
	public static final String IMAGE_ID = "imageId";
	public static final String PLANET_RADIUS = "radius";
	public static final String ORBITAL_PERIOD = "orbital";
	public static final String DESCRIPTION = "description";
	
	public String name;
	public int imageId;
	public double planetRadius;
	public int orbitalPeriod;
	public String description;
	
	
	
	
	public Planet(String name, int imageId, double imageRadius,
			int orbitalPeriod, String description) {
		super();
		this.name = name;
		this.imageId = imageId;
		this.planetRadius = imageRadius;
		this.orbitalPeriod = orbitalPeriod;
		this.description = description;
	}


	public String getName() {
		return name;
	}

	public int getImageId() {
		return imageId;
	}

	public double getPlanetRadius() {
		return planetRadius;
	}

	public int getOrbitalPeriod() {
		return orbitalPeriod;
	}
	
	public String getDescription() {
		return description;
	}

}
