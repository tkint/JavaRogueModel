/* 
 * Everyone is authorized to read, copy and share the code below
 * if the authors are credited
 */
package rogue.model;

import java.util.ArrayList;
import rogue.Config;
import rogue.model.enums.Edibles;
import rogue.model.enums.EnemyClasses;
import rogue.model.enums.StuffPieces;
import rogue.model.boardobject.BoardObject;
import rogue.model.boardobject.Wall;
import rogue.model.boardobject.character.enemy.Enemy;
import rogue.model.boardobject.character.hero.Hero;
import rogue.model.boardobject.item.edible.Edible;
import rogue.model.boardobject.item.stuffpiece.StuffPiece;

/**
 *
 * @author Thomas
 */
public final class Board implements Config {

    private int width;
    private int height;
    private int walls;
    private int enemies;
    private int stuffPieces;
    private int edibles;
    private final int level;
    private final ArrayList<BoardObject> objects = new ArrayList<>();

    public Board(int level, Hero hero) {
        this.level = level;
        generateBoard(hero);
    }

    private void generateBoard(Hero hero) {
        if (this.level > -1 && this.level < Config.LEVELS.length) {
            this.width = Config.LEVELS[this.level][0] + 2;
            this.height = Config.LEVELS[this.level][1] + 2;
            this.walls = Config.LEVELS[this.level][2];
            this.enemies = Config.LEVELS[this.level][3];
            this.stuffPieces = Config.LEVELS[this.level][4];
            this.edibles = Config.LEVELS[this.level][5];

            placeHero(hero);
            placeWalls();
            placeEnemies();
            placeStuffPieces();
            placeEdibles();
        } else {
            System.out.println("Level not found!");
        }
    }

    private void placeHero(Hero hero) {
        hero.setPosX(width / 2);
        hero.setPosY(height / 2);
        this.objects.add(hero);
    }

    private void placeWalls() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                if (i == 0 || i == this.width - 1 || j == 0 || j == this.height - 1) {
                    Wall wall = new Wall();
                    wall.setPosX(i);
                    wall.setPosY(j);
                    this.objects.add(wall);
                }
            }
        }
        for (int i = 0; i < this.walls; i++) {
            if (!isFull()) {
                Wall wall = new Wall();
                placeBoardObject(wall);
                this.objects.add(wall);
            } else {
                System.out.println("Board is full!");
            }
        }
    }

    private void placeEnemies() {
        for (int i = 0; i < this.enemies; i++) {
            if (!isFull()) {
                EnemyClasses enemyClass = EnemyClasses.getRandom();
                Enemy enemy = new Enemy(enemyClass.getName().substring(0, 1) + " " + countEnemyClass(enemyClass), enemyClass);
                placeBoardObject(enemy);
                this.objects.add(enemy);
            } else {
                System.out.println("Board is full!");
            }
        }
    }

    private void placeStuffPieces() {
        for (int i = 0; i < this.stuffPieces; i++) {
            if (!isFull()) {
                StuffPieces stuffPiece = StuffPieces.getRandom();
                StuffPiece piece = new StuffPiece(stuffPiece);
                placeBoardObject(piece);
                this.objects.add(piece);
            } else {
                System.out.println("Board is full!");
            }
        }
    }

    private void placeEdibles() {
        for (int i = 0; i < this.edibles; i++) {
            if (!isFull()) {
                Edibles edible = Edibles.getRandom();
                Edible item = new Edible(edible);
                placeBoardObject(item);
                this.objects.add(item);
            } else {
                System.out.println("Board is full!");
            }
        }
    }

    private int countEnemyClass(EnemyClasses enemyClass) {
        int i = 0;
        for (BoardObject object : objects) {
            if (object.getObjectClass().equals(enemyClass.getName())) {
                i++;
            }
        }
        return i + 1;
    }

    private void placeBoardObject(BoardObject object) {
        Integer[] positions = definePositions((int) (Math.random() * (this.width - 2) + 1), (int) (Math.random() * (this.height - 2) + 1));
        object.setPosX(positions[0]);
        object.setPosY(positions[1]);
    }

    private Integer[] definePositions(int posX, int posY) {
        if (getObjectInPosition(posX, posY) != null) {
            System.out.println("Position " + posX + "-" + posY + " occupée");
            return definePositions((int) (Math.random() * (this.width - 2) + 1), (int) (Math.random() * (this.height - 2) + 1));
        }
        Integer[] positions = {posX, posY};
        return positions;
    }

    public BoardObject getObjectInPosition(int posX, int posY) {
        BoardObject object = null;
        int i = 0;
        while (i < this.objects.size() && object == null) {
            if (this.objects.get(i).getPosX() == posX && this.objects.get(i).getPosY() == posY) {
                object = this.objects.get(i);
            }
            i++;
        }
        return object;
    }

    private boolean isFull() {
        if (objects.size() == width * height) {
            return true;
        }
        return false;
    }

    public ArrayList<BoardObject> getObjects() {
        return objects;
    }

    public Hero getHero() {
        Hero hero = null;
        int i = 0;
        while (i < this.objects.size() && hero == null) {
            if (this.objects.get(i).getClass().getSimpleName().equals("Hero")) {
                hero = (Hero) this.objects.get(i);
            }
            i++;
        }
        return hero;
    }

    public ArrayList<Enemy> getEnemies() {
        ArrayList<Enemy> listEnemies = new ArrayList<>();
        for (BoardObject object : this.objects) {
            if (object.getClass().getSimpleName().equals("Enemy")) {
                listEnemies.add((Enemy) object);
            }
        }
        return listEnemies;
    }

    public String showInArray() {
        String str = "";

        for (int i = 0; i < this.height; i++) {
            str += "|";
            for (int j = 0; j < this.width; j++) {
                if (getObjectInPosition(j, i) != null) {
                    switch (getObjectInPosition(j, i).getClass().getSimpleName()) {
                        case "Hero":
                            str += "H";
                            break;
                        case "Enemy":
                            str += getObjectInPosition(j, i).getObjectClass().substring(0, 1);
                            break;
                        case "Edible":
                            str += "o";
                            break;
                        case "StuffPiece":
                            str += "+";
                            break;
                        case "Wall":
                            str += "=";
                            break;
                        default:
                            str += " ";
                            break;
                    }
                } else {
                    str += " ";
                }
                str += "|";
            }
            str += "\n";
        }
        return str;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int countWalls() {
        return walls;
    }

    public int countEnemies() {
        return enemies;
    }

    public int countStuffPieces() {
        return stuffPieces;
    }

    public int countEdibles() {
        return edibles;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        String str = "Board{" + "level=" + level + ", width=" + width + ", height=" + height + ", enemies=" + enemies + ", stuffPieces=" + stuffPieces + ", edibles=" + edibles + ", objects=\n" + objects + '}';
        return str;
    }
}
