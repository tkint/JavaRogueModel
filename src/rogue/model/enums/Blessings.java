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
public enum Blessings implements Translations {
    AKKOR(new EnumMap<Characteristics, Integer>(Characteristics.class) {
        {
            put(Characteristics.HEALTH, 5);
            put(Characteristics.STRENGHT, 5);
        }
    }
    ),
    ILLUA(new EnumMap<Characteristics, Integer>(Characteristics.class) {
        {
            put(Characteristics.MANA, 5);
            put(Characteristics.INTELLIGENCE, 5);
        }
    }
    ),
    MAZIN(new EnumMap<Characteristics, Integer>(Characteristics.class) {
        {
            put(Characteristics.AGILITY, 5);
            put(Characteristics.STEALTH, 5);
        }
    }
    ),
    LUPIS(new EnumMap<Characteristics, Integer>(Characteristics.class) {
        {
            put(Characteristics.STRENGHT, 5);
            put(Characteristics.STEALTH, 5);
        }
    }
    );

    private final String name;
    private EnumMap<Characteristics, Integer> characteristics = new EnumMap<>(Characteristics.class);

    Blessings(EnumMap<Characteristics, Integer> characteristics) {
        this.name = BLESSINGS.getString(this.name());
        this.characteristics = characteristics;
    }

    public String getName() {
        return name;
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

    public boolean equals(Blessings blessing) {
        if (blessing == null) {
            return false;
        }
        return this.name.equals(blessing.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
