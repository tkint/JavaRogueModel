/* 
 * Everyone is authorized to read, copy and share the code below
 * if the authors are credited
 */
package rogue.model.boardobject.item;

import java.util.EnumMap;
import rogue.model.enums.Characteristics;
import rogue.model.boardobject.BoardObject;

/**
 *
 * @author Thomas
 */
public abstract class Item extends BoardObject {

    protected int weight;
    protected EnumMap<Characteristics, Integer> characteristics = new EnumMap<>(Characteristics.class);

    public Item(String name, int weight) {
        super(name);
        this.weight = weight;
        for (Characteristics characteristic : Characteristics.values()) {
            if (!(characteristic.equals(Characteristics.CURRENT_HEALTH) || characteristic.equals(Characteristics.CURRENT_MANA))) {
                this.characteristics.put(characteristic, 0);
            }
        }
    }

    public int getWeight() {
        return weight;
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

    @Override
    public abstract String defineObjectClass();

    @Override
    public String toString() {
        String str = super.toString() + ", ";
        str += "\n" + CHARACTERISTICS.getString("CHARACTERISTICS") + " : ";
        for (Characteristics characteristic : this.characteristics.keySet()) {
            str += characteristic.getName() + " = " + getCharacteristic(characteristic) + ", ";
        }
        return str;
    }
}
