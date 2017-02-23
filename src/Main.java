/* 
 * Everyone is authorized to read, copy and share the code below
 * if the authors are credited
 */
import java.lang.reflect.Field;
import rogue.model.enums.Blessings;
import rogue.model.enums.EnemyClasses;
import rogue.model.enums.HeroClasses;
import rogue.model.enums.StuffPieces;
import rogue.model.enums.StuffPlaces;
import rogue.model.Board;
import rogue.model.boardobject.character.enemy.Enemy;
import rogue.model.boardobject.character.hero.Hero;
import rogue.model.boardobject.item.stuffpiece.StuffPiece;

/**
 *
 * @author Thomas
 */
public class Main {

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        Hero tom = new Hero("Tom", HeroClasses.WARRIOR, Blessings.AKKOR);

        Hero mag = new Hero("Mag", HeroClasses.ARCHER, Blessings.LUPIS);
        
        Enemy zombie = new Enemy("Zombie 1", EnemyClasses.ZOMBIE);
        
        tom.addItemInInventory(new StuffPiece(StuffPieces.LEATHER_HAT));
        tom.addItemInInventory(new StuffPiece(StuffPieces.LEATHER_BOOTS));
        
        tom.setStuffPiece(StuffPlaces.HEAD, new StuffPiece(StuffPieces.LEATHER_HAT));
        tom.setStuffPiece(StuffPlaces.ARMOR, new StuffPiece(StuffPieces.LEATHER_JACKET));
        tom.setStuffPiece(StuffPlaces.RIGHT_HAND, new StuffPiece(StuffPieces.WOODEN_SWORD));
        tom.setStuffPiece(StuffPlaces.LEFT_HAND, new StuffPiece(StuffPieces.WOODEN_SHIELD));
        tom.setStuffPiece(StuffPlaces.BELT, new StuffPiece(StuffPieces.LEATHER_BELT));
        tom.setStuffPiece(StuffPlaces.LEGS, new StuffPiece(StuffPieces.LEATHER_TROUSERS));
        tom.setStuffPiece(StuffPlaces.BOOTS, new StuffPiece(StuffPieces.LEATHER_BOOTS));

        System.out.println(tom);
        
        System.out.println("--------------------------------");
        
        System.out.println(mag);
        
        System.out.println("--------------------------------");
        
        System.out.println(zombie);
        
        System.out.println("--------------------------------");
        
        Board board = new Board(2, tom);
        
        System.out.println(board.showInArray());
        
        System.out.println("--------------------------------");
        
        Field[] fields = tom.getClass().getSuperclass().getDeclaredFields();
        
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName() + " -> " + field.get(tom));
        }
    }
}
