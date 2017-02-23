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
public enum StuffPieces implements Translations {

    LEATHER_HAT(StuffPlaces.HEAD, new EnumMap<Characteristics, Integer>(Characteristics.class) {
        {
            put(Characteristics.HEALTH, 1);
            put(Characteristics.MANA, 1);
            put(Characteristics.STRENGHT, 1);
            put(Characteristics.INTELLIGENCE, 1);
            put(Characteristics.AGILITY, 1);
            put(Characteristics.STEALTH, 1);
            put(Characteristics.PERCEIVE, 1);
        }
    }
    ),
    LEATHER_JACKET(StuffPlaces.ARMOR, new EnumMap<Characteristics, Integer>(Characteristics.class) {
        {
            put(Characteristics.HEALTH, 1);
            put(Characteristics.MANA, 1);
            put(Characteristics.STRENGHT, 1);
            put(Characteristics.INTELLIGENCE, 1);
            put(Characteristics.AGILITY, 1);
            put(Characteristics.STEALTH, 1);
            put(Characteristics.PERCEIVE, 1);
        }
    }
    ),
    WOODEN_SWORD(StuffPlaces.RIGHT_HAND, new EnumMap<Characteristics, Integer>(Characteristics.class) {
        {
            put(Characteristics.HEALTH, 1);
            put(Characteristics.MANA, 1);
            put(Characteristics.STRENGHT, 1);
            put(Characteristics.INTELLIGENCE, 1);
            put(Characteristics.AGILITY, 1);
            put(Characteristics.STEALTH, 1);
            put(Characteristics.PERCEIVE, 1);
        }
    }
    ),
    WOODEN_SHIELD(StuffPlaces.LEFT_HAND, new EnumMap<Characteristics, Integer>(Characteristics.class) {
        {
            put(Characteristics.HEALTH, 1);
            put(Characteristics.MANA, 1);
            put(Characteristics.STRENGHT, 1);
            put(Characteristics.INTELLIGENCE, 1);
            put(Characteristics.AGILITY, 1);
            put(Characteristics.STEALTH, 1);
            put(Characteristics.PERCEIVE, 1);
        }
    }
    ),
    LEATHER_BELT(StuffPlaces.BELT, new EnumMap<Characteristics, Integer>(Characteristics.class) {
        {
            put(Characteristics.HEALTH, 1);
            put(Characteristics.MANA, 1);
            put(Characteristics.STRENGHT, 1);
            put(Characteristics.INTELLIGENCE, 1);
            put(Characteristics.AGILITY, 1);
            put(Characteristics.STEALTH, 1);
            put(Characteristics.PERCEIVE, 1);
        }
    }
    ),
    LEATHER_TROUSERS(StuffPlaces.LEGS, new EnumMap<Characteristics, Integer>(Characteristics.class) {
        {
            put(Characteristics.HEALTH, 1);
            put(Characteristics.MANA, 1);
            put(Characteristics.STRENGHT, 1);
            put(Characteristics.INTELLIGENCE, 1);
            put(Characteristics.AGILITY, 1);
            put(Characteristics.STEALTH, 1);
            put(Characteristics.PERCEIVE, 1);
        }
    }
    ),
    LEATHER_BOOTS(StuffPlaces.BOOTS, new EnumMap<Characteristics, Integer>(Characteristics.class) {
        {
            put(Characteristics.HEALTH, 1);
            put(Characteristics.MANA, 1);
            put(Characteristics.STRENGHT, 1);
            put(Characteristics.INTELLIGENCE, 1);
            put(Characteristics.AGILITY, 1);
            put(Characteristics.STEALTH, 1);
            put(Characteristics.PERCEIVE, 1);
        }
    }
    );

    private final String name;
    private final StuffPlaces place;
    private EnumMap<Characteristics, Integer> characteristics = new EnumMap<>(Characteristics.class);

    private StuffPieces(StuffPlaces place, EnumMap<Characteristics, Integer> characteristics) {
        this.name = STUFFPIECES.getString(this.name());
        this.place = place;
        this.characteristics = characteristics;
    }

    public String getName() {
        return name;
    }

    public StuffPlaces getPlace() {
        return place;
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

    public static StuffPieces getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

    @Override
    public String toString() {
        return name;
    }
}
