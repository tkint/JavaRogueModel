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
public enum EdibleTypes implements Translations {
    POTION(1),
    PAPER(1);

    private final String name;
    private final int weight;

    EdibleTypes(int weight) {
        this.name = EDIBLETYPES.getString(this.name());
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
