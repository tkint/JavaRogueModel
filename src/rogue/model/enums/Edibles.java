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
public enum Edibles implements Translations {
    LITTLE_HEALTH_FLASK(EdibleTypes.POTION, new EnumMap<Characteristics, Integer>(Characteristics.class) {
        {
            put(Characteristics.HEALTH, 1);
        }
    }
    ),
    LITTLE_MANA_FLASK(EdibleTypes.POTION, new EnumMap<Characteristics, Integer>(Characteristics.class) {
        {
            put(Characteristics.MANA, 1);
        }
    }
    );

    private final String name;
    private final EdibleTypes type;
    private EnumMap<Characteristics, Integer> bonuses = new EnumMap<>(Characteristics.class);

    private Edibles(EdibleTypes type, EnumMap<Characteristics, Integer> bonuses) {
        this.name = EDIBLES.getString(this.name());
        this.type = type;
        this.bonuses = bonuses;
    }

    public String getName() {
        return name;
    }

    public EdibleTypes getType() {
        return type;
    }

    public EnumMap<Characteristics, Integer> getBonuses() {
        return bonuses;
    }

    public int getCharacteristic(Characteristics bonus) {
        if (this.bonuses.get(bonus) != null) {
            return this.bonuses.get(bonus);
        }
        return 0;
    }

    public void setCharacteristic(Characteristics bonus, int value) {
        if (this.bonuses.get(bonus) != null) {
            this.bonuses.replace(bonus, value);
        } else {
            this.bonuses.put(bonus, value);
        }
    }

    public void addCharacteristic(Characteristics bonus, int value) {
        if (this.bonuses.get(bonus) != null) {
            this.bonuses.replace(bonus, this.bonuses.get(bonus) + value);
        }
    }

    public static Edibles getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

    @Override
    public String toString() {
        return name;
    }
}
