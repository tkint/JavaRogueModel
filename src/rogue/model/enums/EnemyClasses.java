/* 
 * Everyone is authorized to read, copy and share the code below
 * if the authors are credited
 */
package rogue.model.enums;

import java.util.EnumMap;
import rogue.model.translations.Translations;

/**
 *
 * @author Thomas
 */
public enum EnemyClasses implements Translations {
    ZOMBIE(5, new EnumMap<Characteristics, Integer>(Characteristics.class) {
        {
            put(Characteristics.HEALTH, 5);
            put(Characteristics.MANA, 5);
            put(Characteristics.STRENGHT, 5);
            put(Characteristics.PERCEIVE, 10);
        }
    }
    ),
    RAT(5, new EnumMap<Characteristics, Integer>(Characteristics.class) {
        {
            put(Characteristics.HEALTH, 5);
            put(Characteristics.MANA, 5);
            put(Characteristics.STRENGHT, 5);
            put(Characteristics.PERCEIVE, 10);
        }
    }
    );

    private final String name;
    private final int inventorySize;
    private EnumMap<Characteristics, Integer> characteristics = new EnumMap<>(Characteristics.class);

    EnemyClasses(int inventorySize, EnumMap<Characteristics, Integer> characteristics) {
        this.name = ENEMYCLASSES.getString(this.name());
        this.inventorySize = inventorySize;
        this.characteristics = characteristics;
    }

    public String getName() {
        return name;
    }

    public int getInventorySize() {
        return inventorySize;
    }

    public EnumMap<Characteristics, Integer> getCharacteristics() {
        return characteristics;
    }

    public int getCharacteristic(Characteristics characteristic) {
        if (this.characteristics.get(characteristic) != null) {
            return this.characteristics.get(characteristic);
        }
        return 0;
    }

    public void setCharacteristic(Characteristics characteristic, int value) {
        if (this.characteristics.get(characteristic) != null) {
            this.characteristics.replace(characteristic, value);
        } else {
            this.characteristics.put(characteristic, value);
        }
    }

    public void addCharacteristic(Characteristics characteristic, int value) {
        if (this.characteristics.get(characteristic) != null) {
            this.characteristics.replace(characteristic, this.characteristics.get(characteristic) + value);
        }
    }

    public static EnemyClasses getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

    @Override
    public String toString() {
        return name;
    }
}
