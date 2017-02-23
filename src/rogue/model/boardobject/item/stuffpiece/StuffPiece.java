/*
 * Everyone is authorized to read, copy and share the code below
 * if the authors are credited
 */
package rogue.model.boardobject.item.stuffpiece;

import rogue.model.enums.StuffPieces;
import rogue.model.boardobject.item.Item;
import rogue.model.translations.Translations;

/**
 *
 * @author Thomas
 */
public final class StuffPiece extends Item implements Translations {

    private StuffPieces piece;

    public StuffPiece(StuffPieces piece) {
        super(STUFFPIECES.getString(piece.name()), piece.getPlace().getWeight());
        this.piece = piece;
        this.objectClass = defineObjectClass();
        this.characteristics = piece.getCharacteristics();
    }

    public StuffPieces getPiece() {
        return piece;
    }

    public void setPiece(StuffPieces piece) {
        this.piece = piece;
    }

    @Override
    public String defineObjectClass() {
        return this.piece.getName();
    }

    @Override
    public String toString() {
        String str = STUFFPIECES.getString("STUFFPIECE") + "{" + super.toString();
        str += "\n";
        str += STUFFPLACES.getString("STUFFPLACE") + " = " + piece.getPlace() + '}';
        return str;
    }
}
