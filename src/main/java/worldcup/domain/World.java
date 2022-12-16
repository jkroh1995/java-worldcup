package worldcup.domain;

public class World {

    String world;

    public World(String world) {
        this.world = world;
    }

    public String getWorld() {
        return world;
    }

    @Override
    public boolean equals(Object obj) {
        World world = (World) obj;
        return this.world.equals(world.world);
    }

    @Override
    public int hashCode() {
        if (world == null) {
            return 0;
        }
        return world.hashCode();
    }
}
