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
public abstract class BoardObject implements Translations {

    private int id;
    protected int posX;
    protected int posY;
    private String name;
    private static int idStatus;
    protected String objectClass;

    public BoardObject(String name) {
        this.id = idStatus;
        this.name = name;
        idStatus++;
    }

    public abstract String defineObjectClass();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjectClass() {
        return objectClass;
    }

    public void setObjectClass(String objectClass) {
        this.objectClass = objectClass;
    }

    @Override
    public String toString() {
        return "Id = " + id + ", PosX = " + posX + ", PosY = " + posY + ", " + CHARACTERISTICS.getString("NAME") + " = " + name;
    }
}
