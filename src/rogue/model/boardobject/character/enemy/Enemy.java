/* 
 * Everyone is authorized to read, copy and share the code below
 * if the authors are credited
 */
package rogue.model.boardobject.character.enemy;

import rogue.model.enums.Characteristics;
import rogue.model.enums.EnemyClasses;
import rogue.model.boardobject.character.Character;
import rogue.model.boardobject.item.Item;
import rogue.model.boardobject.item.stuffpiece.StuffPiece;
import rogue.model.translations.Translations;

/**
 *
 * @author Thomas
 */
public final class Enemy extends Character implements Translations {

    private EnemyClasses enemyClass;

    public Enemy(String name, EnemyClasses enemyClass) {
        super(name);
        this.enemyClass = enemyClass;
        this.objectClass = defineObjectClass();
        this.setCharacteristic(Characteristics.CURRENT_HEALTH, this.getFullCharacteristic(Characteristics.HEALTH));
        this.setCharacteristic(Characteristics.CURRENT_MANA, this.getFullCharacteristic(Characteristics.MANA));
    }

    public EnemyClasses getEnemyClass() {
        return enemyClass;
    }

    public void setEnemyClass(EnemyClasses enemyClass) {
        this.enemyClass = enemyClass;
    }

    @Override
    public int getFullCharacteristic(Characteristics characteristic) {
        int value = this.characteristics.get(characteristic);
        if (this.enemyClass != null) {
            value += this.enemyClass.getCharacteristic(characteristic);
        }
        for (StuffPiece stuffPiece : this.stuffPieces.values()) {
            if (stuffPiece != null) {
                value += stuffPiece.getCharacteristic(characteristic);
            }
        }
        return value;
    }

    @Override
    public String defineObjectClass() {
        return this.enemyClass.getName();
    }

    @Override
    public void addItemInInventory(Item item) {
        if (this.getInventoryWeight() + item.getWeight() < this.enemyClass.getInventorySize()) {
            this.inventory.add(item);
        } else {
            System.out.println("Item too heavy...");
        }
    }

    @Override
    public String toString() {
        String str = ENEMYCLASSES.getString("ENEMY") + "{" + super.toString();
        str += ENEMYCLASSES.getString("ENEMYCLASS") + " = " + enemyClass + '}';
        return str;
    }
}
