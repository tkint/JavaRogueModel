/* 
 * Everyone is authorized to read, copy and share the code below
 * if the authors are credited
 */
package rogue.model.boardobject.character.hero;

import rogue.model.enums.Blessings;
import rogue.model.enums.Characteristics;
import rogue.model.enums.HeroClasses;
import rogue.model.boardobject.character.Character;
import rogue.model.boardobject.item.Item;
import rogue.model.boardobject.item.stuffpiece.StuffPiece;
import rogue.model.translations.Translations;

/**
 *
 * @author Thomas
 */
public final class Hero extends Character implements Translations {

    private HeroClasses heroClass;
    private Blessings blessing;

    public Hero(String name, HeroClasses heroClass, Blessings blessing) {
        super(name);
        this.heroClass = heroClass;
        this.objectClass = defineObjectClass();
        this.setBlessing(blessing);
        this.setCharacteristic(Characteristics.CURRENT_HEALTH, this.getFullCharacteristic(Characteristics.HEALTH));
        this.setCharacteristic(Characteristics.CURRENT_MANA, this.getFullCharacteristic(Characteristics.MANA));
    }

    public HeroClasses getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(HeroClasses heroClass) {
        this.heroClass = heroClass;
    }

    public Blessings getBlessing() {
        return blessing;
    }

    public void setBlessing(Blessings blessing) {
        if (blessing != null) {
            if (this.heroClass.isCompatibleBlessing(blessing)) {
                this.blessing = blessing;
            } else {
                System.out.println("Blessing not compatible!");
            }
        }
    }

    @Override
    public int getFullCharacteristic(Characteristics characteristic) {
        int value = this.characteristics.get(characteristic);
        if (this.heroClass != null) {
            value += this.heroClass.getCharacteristic(characteristic);
        }
        if (this.blessing != null) {
            value += this.blessing.getCharacteristic(characteristic);
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
        return this.heroClass.getName();
    }

    @Override
    public void addItemInInventory(Item item) {
        if (this.getInventoryWeight() + item.getWeight() < this.heroClass.getInventorySize()) {
            this.inventory.add(item);
        } else {
            System.out.println("Item too heavy...");
        }
    }

    @Override
    public String toString() {
        String str = HEROCLASSES.getString("HERO") + "{" + super.toString();
        str += HEROCLASSES.getString("HEROCLASS") + " = " + heroClass + ", " + BLESSINGS.getString("BLESSING") + " = " + blessing + '}';
        return str;
    }
}
