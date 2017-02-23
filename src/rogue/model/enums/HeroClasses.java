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
public enum HeroClasses implements Translations {
    WARRIOR(15, new EnumMap<Characteristics, Integer>(Characteristics.class) {
        {
            put(Characteristics.HEALTH, 10);
            put(Characteristics.MANA, 5);
            put(Characteristics.STRENGHT, 10);
            put(Characteristics.AGILITY, 5);
            put(Characteristics.PERCEIVE, 5);
        }
    },
            new Blessings[]{
                Blessings.AKKOR,
                Blessings.LUPIS,
                Blessings.MAZIN
            }
    ),
    ARCHER(12, new EnumMap<Characteristics, Integer>(Characteristics.class) {
        {
            put(Characteristics.HEALTH, 5);
            put(Characteristics.MANA, 5);
            put(Characteristics.STRENGHT, 10);
            put(Characteristics.AGILITY, 10);
            put(Characteristics.PERCEIVE, 5);
        }
    },
            new Blessings[]{
                Blessings.AKKOR,
                Blessings.LUPIS,
                Blessings.MAZIN
            }
    ),
    THIEF(8, new EnumMap<Characteristics, Integer>(Characteristics.class) {
        {
            put(Characteristics.STRENGHT, 10);
            put(Characteristics.INTELLIGENCE, 0);
            put(Characteristics.AGILITY, 10);
            put(Characteristics.STEALTH, 10);
            put(Characteristics.PERCEIVE, 5);
        }
    },
            new Blessings[]{
                Blessings.LUPIS
            }
    ),
    MAGE(10, new EnumMap<Characteristics, Integer>(Characteristics.class) {
        {
            put(Characteristics.HEALTH, 5);
            put(Characteristics.MANA, 10);
            put(Characteristics.INTELLIGENCE, 10);
            put(Characteristics.AGILITY, 5);
            put(Characteristics.PERCEIVE, 5);
        }
    },
            new Blessings[]{
                Blessings.ILLUA,
                Blessings.LUPIS
            }
    );

    private final String name;
    private final int inventorySize;
    private final Blessings[] compatibleBlessings;
    private EnumMap<Characteristics, Integer> characteristics = new EnumMap<>(Characteristics.class
    );

    HeroClasses(int inventorySize, EnumMap<Characteristics, Integer> characteristics, Blessings[] compatibleBlessings) {
        this.name = HEROCLASSES.getString(this.name());
        this.inventorySize = inventorySize;
        this.compatibleBlessings = compatibleBlessings;
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

    public Blessings[] getCompatibleBlessings() {
        return compatibleBlessings;
    }

    public boolean isCompatibleBlessing(Blessings blessing) {
        boolean compatible = false;
        int i = 0;
        while (i < this.compatibleBlessings.length && !compatible) {
            if (this.compatibleBlessings[i].equals(blessing)) {
                compatible = true;
            }
            i++;
        }
        return compatible;
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

    @Override
    public String toString() {
        return name;
    }
}
