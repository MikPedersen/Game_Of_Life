import java.util.Random;

public class Game {
    private final int ANTAL_FELTER = 20;

    public Cell[][] getSpilleplade() {
        return spilleplade;
    }

    public void setSpilleplade(Cell[][] spilleplade) {
        this.spilleplade = spilleplade;
    }

    private Cell [][] spilleplade;
    private int omgange;

    public Game(){
        spilleplade = new Cell[getANTAL_FELTER()][getANTAL_FELTER()];
        omgange = 0;
        for (int x = 0; x < getANTAL_FELTER(); x++) {
            for (int y = 0; y < getANTAL_FELTER(); y++) {
                int r = (int) Math.round(Math.random());
                Cell c = new Cell();
                c.setName("X:" + x + " Y: "+ y);
                System.out.println(c.getName());
                if (r == 1){
                    c.setAlive(true);
                }
                else c.setAlive(false);
                spilleplade[x][y] = c;
            }
        }
    }
    public void update(){
        omgange++;
        for (int x = 0; x < getANTAL_FELTER(); x++) {
            for (int y = 0; y < getANTAL_FELTER(); y++) {
                if (x == 0 || x == spilleplade.length -1 || y == 0 || y == spilleplade.length -1 ){
                    spilleplade[x][y].setLivingNeighbours(spilleplade[x][y].getLivingNeighbours());
                }
                else spilleplade[x][y].setLivingNeighbours(countNeighbors(spilleplade, x, y));
            }
        }
        for (int x = 0; x < spilleplade.length; x++) {
            for (int y = 0; y < spilleplade.length; y++) {
                spilleplade[x][y].update();
            }
        }
    }
    public int countNeighbors(Cell[][] spilleplade, int x, int y) {
        int sum = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (spilleplade[x+i][y+j].getAlive()) {
                    sum += 1;
                }
            }
        }
        if (spilleplade[x][y].getAlive()) {
            sum = sum - 1;
        }
        return sum;

    }

    public int getANTAL_FELTER() {
        return ANTAL_FELTER;
    }
}


