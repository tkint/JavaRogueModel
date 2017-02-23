/* 
 * Everyone is authorized to read, copy and share the code below
 * if the authors are credited
 */
package rogue.model.boardobject.character;

import java.util.ArrayList;
import java.util.EnumMap;
import rogue.model.enums.Characteristics;
import rogue.model.enums.StuffPlaces;
import rogue.model.boardobject.BoardObject;
import rogue.model.boardobject.item.Item;
import rogue.model.boardobject.item.stuffpiece.StuffPiece;

/**
 *
 * @author Thomas
 */
public abstract class Character extends BoardObject {

    protected String characterClass;
    protected ArrayList<Item> inventory = new ArrayList<>();
    protected EnumMap<StuffPlaces, StuffPiece> stuffPieces = new EnumMap<>(StuffPlaces.class);
    protected EnumMap<Characteristics, Integer> characteristics = new EnumMap<>(Characteristics.class);

    public Character(String name) {
        super(name);
        for (Characteristics characteristic : Characteristics.values()) {
            this.characteristics.put(characteristic, 0);
        }
        for (StuffPlaces stuffPlace : StuffPlaces.values()) {
            this.stuffPieces.put(stuffPlace, null);
        }
    }

    @Override
    public abstract String defineObjectClass();

    public abstract int getFullCharacteristic(Characteristics characteristic);

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

    public StuffPiece getStuffPiece(StuffPlaces stuffPlace) {
        return this.stuffPieces.get(stuffPlace);
    }

    public void setStuffPiece(StuffPlaces stuffPlace, StuffPiece stuffPiece) {
        if (stuffPiece.getPiece().getPlace().equals(stuffPlace)) {
            this.stuffPieces.replace(stuffPlace, stuffPiece);
            if (this.getFullCharacteristic(Characteristics.CURRENT_HEALTH) == this.getFullCharacteristic(Characteristics.HEALTH) - stuffPiece.getCharacteristic(Characteristics.HEALTH)) {
                this.addCharacteristic(Characteristics.CURRENT_HEALTH, stuffPiece.getCharacteristic(Characteristics.HEALTH));
            }
            if (this.getFullCharacteristic(Characteristics.CURRENT_MANA) == this.getFullCharacteristic(Characteristics.MANA) - stuffPiece.getCharacteristic(Characteristics.MANA)) {
                this.addCharacteristic(Characteristics.CURRENT_MANA, stuffPiece.getCharacteristic(Characteristics.MANA));
            }
        } else {
            System.out.println("StuffPiece putted on the wrong place : tried putting " + stuffPiece.getPiece().getPlace().getName() + " into " + stuffPlace.getName());
        }
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getInventoryWeight() {
        int weight = 0;
        for (Item item : inventory) {
            weight += item.getWeight();
        }
        return weight;
    }

    public void moveUp() {
        this.posY--;
    }

    public void moveDown() {
        this.posY++;
    }

    public void moveLeft() {
        this.posX--;
    }

    public void moveRight() {
        this.posX++;
    }

    public abstract void addItemInInventory(Item item);

    @Override
    public String toString() {
        String str = super.toString() + ", ";
        str += "\n" + CHARACTERISTICS.getString("CHARACTERISTICS") + " : ";
        for (Characteristics characteristic : this.characteristics.keySet()) {
            str += characteristic.getName() + " = " + getFullCharacteristic(characteristic) + ", ";
        }
        str += "\n" + STUFFPIECES.getString("STUFFPIECES") + " : ";
        for (StuffPlaces stuffPlace : this.stuffPieces.keySet()) {
            if (getStuffPiece(stuffPlace) != null) {
                str += stuffPlace.getName() + " = " + getStuffPiece(stuffPlace).getName() + ", ";
            }
        }
        str += "\n" + ITEMS.getString("ITEMS") + " : ";
        for (int i = 0; i < this.inventory.size(); i++) {
            str += this.inventory.get(i).getName() + ", ";
        }
        str += "\n";
        return str;
    }
}
