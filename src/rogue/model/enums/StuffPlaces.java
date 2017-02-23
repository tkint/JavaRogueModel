/*
 * Everyone is authorized to read, copy and share the code below
 * if the authors are credited
 */
package rogue.model.enums;

import rogue.model.translations.Translations;

/**
 *
 * @author Thomas
 */
public enum StuffPlaces implements Translations {
    HEAD(1),
    ARMOR(1),
    RIGHT_HAND(1),
    LEFT_HAND(1),
    BELT(1),
    LEGS(1),
    BOOTS(1);

    private final String name;
    private final int weight;

    StuffPlaces(int weight) {
        this.name = STUFFPLACES.getString(this.name());
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name;
    }
}
