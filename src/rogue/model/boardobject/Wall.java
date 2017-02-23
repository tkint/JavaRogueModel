/*
 * Everyone is authorized to read, copy and share the code below
 * if the authors are credited
 */
package rogue.model.boardobject;

import rogue.model.translations.Translations;

/**
 *
 * @author Thomas
 */
public final class Wall extends BoardObject implements Translations {

    public Wall() {
        super(WORDS.getString("WALL"));
        this.objectClass = defineObjectClass();
    }

    @Override
    public String defineObjectClass() {
        return WORDS.getString("WALL");
    }

}
