public class Cell {
    private boolean alive;
    private int livingNeighbours;
    private String name;

    public Cell(){
        this.livingNeighbours = -1;
    }

    public void update(){
        if (!alive && livingNeighbours == 3){
            this.alive = true;
        }
        else if (alive && livingNeighbours == 2 || alive && livingNeighbours == 3){
            this.alive = true;
        }
        else
            this.alive = false;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public boolean getAlive() {
        return alive;
    }
    public int getLivingNeighbours() {
        return livingNeighbours;
    }
    public void setLivingNeighbours(int livingNeighbours) {
        this.livingNeighbours = livingNeighbours;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
