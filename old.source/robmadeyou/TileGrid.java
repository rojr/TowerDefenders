package old.com.gmail.robmadeyou;

public class TileGrid {

    private Tile[][] tiles = new Tile[World.BLOCKS_WIDTH][World.BLOCKS_HEIGHT];
    private Tile[][] tilesPath = new Tile[World.BLOCKS_WIDTH][World.BLOCKS_HEIGHT];

    public TileGrid() {
        for (int x = 0; x < World.BLOCKS_WIDTH - 1; x++) {
            for (int y = 0; y < World.BLOCKS_HEIGHT - 1; y++) {
                tiles[x][y] = new Tile(TileType.AIR, x * World.BLOCK_SIZE, y
                        * World.BLOCK_SIZE);
                tilesPath[x][y] = new Tile(TileType.PATHFINDING_EMPTY, x * World.BLOCK_SIZE, y * World.BLOCK_SIZE);
                tilesPath[x][y].isOP = true;
                tilesPath[x][y].op = 0.5f;
            }
        }
    }
    public void setAt(int x, int y, TileType b, int path) {
    	if(path == 0){
    		tiles[x][y] = new Tile(b, x * World.BLOCK_SIZE, y * World.BLOCK_SIZE);
    	}else if(path == 1){
    		tilesPath[x][y] = new Tile(b, x * World.BLOCK_SIZE, y * World.BLOCK_SIZE);
    	}
    }

    public Tile getAt(int x, int y, int path) {
    	if(path == 0){
    		return tiles[x][y];
    	}else if(path == 1){
    		return tilesPath[x][y];
    	}
        return tiles[x][y];
    }
    public void setRotation(int x, int y, int rotation){
    	tiles[x][y].rotation = rotation;
    }
    public void addRotation(int x, int y, int rotation){
    	tiles[x][y].rotation += rotation;
    }

    public void draw(int path) {
        for (int x = 0; x < World.BLOCKS_WIDTH - 1; x++) {
            for (int y = 0; y < World.BLOCKS_HEIGHT - 1; y++) {
            	if(path == 0){
            		tiles[x][y].draw();
            	}
                if(path == 1){
                	tilesPath[x][y].isOP = true;
                	tilesPath[x][y].draw();
                }
            }
        }
    }
    public void clear(int path) {
        for (int x = 0; x < World.BLOCKS_WIDTH - 1; x++) {
            for (int y = 0; y < World.BLOCKS_HEIGHT - 1; y++) {
            	if(path == 0)
                tiles[x][y] = new Tile(TileType.AIR, x * World.BLOCK_SIZE, y * World.BLOCK_SIZE);
            	else if(path == 1)
            		tilesPath[x][x] = new Tile(TileType.PATHFINDING_EMPTY, x * World.BLOCK_SIZE, y * World.BLOCK_SIZE);
            }
        }
    }
}