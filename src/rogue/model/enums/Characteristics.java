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
public enum Characteristics implements Translations {
    HEALTH,
    MANA,
    STRENGHT,
    INTELLIGENCE,
    AGILITY,
    STEALTH,
    PERCEIVE,
    CURRENT_HEALTH,
    CURRENT_MANA;

    private final String name;

    private Characteristics() {
        this.name = CHARACTERISTICS.getString(this.name());
    }

    public String getName() {
        return name;
    }
}
