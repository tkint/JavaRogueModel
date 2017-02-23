/* 
 * Everyone is authorized to read, copy and share the code below
 * if the authors are credited
 */
package rogue.model.boardobject.item.edible;

import rogue.model.enums.Edibles;
import rogue.model.boardobject.item.Item;
import rogue.model.translations.Translations;

/**
 *
 * @author Thomas
 */
public final class Edible extends Item implements Translations {

    private Edibles edible;

    public Edible(Edibles edible) {
        super(EDIBLES.getString(edible.name()), edible.getType().getWeight());
        this.edible = edible;
        this.objectClass = defineObjectClass();
        this.characteristics = edible.getBonuses();
    }

    public Edibles getEdible() {
        return edible;
    }

    public void setEdible(Edibles edible) {
        this.edible = edible;
    }

    @Override
    public String defineObjectClass() {
        return this.edible.getName();
    }

    @Override
    public String toString() {
        String str = EDIBLES.getString("EDIBLE") + "{" + super.toString();
        str += "\n";
        str += EDIBLETYPES.getString("EDIBLETYPE") + " = " + edible.getType() + '}';
        return str;
    }
}
