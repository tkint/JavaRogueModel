/* 
 * Everyone is authorized to read, copy and share the code below
 * if the authors are credited
 */
package rogue.model.translations;

import java.util.ResourceBundle;

/**
 *
 * @author Thomas
 */
public interface Translations {

    final ResourceBundle CHARACTERISTICS = ResourceBundle.getBundle("rogue.model.translations.characteristics.characteristics");
    
    final ResourceBundle CHARACTERS = ResourceBundle.getBundle("rogue.model.translations.characters.characters");
    final ResourceBundle BLESSINGS = ResourceBundle.getBundle("rogue.model.translations.characters.blessings.blessings");
    final ResourceBundle HEROCLASSES = ResourceBundle.getBundle("rogue.model.translations.characters.heroclasses.heroclasses");
    final ResourceBundle ENEMYCLASSES = ResourceBundle.getBundle("rogue.model.translations.characters.enemyclasses.enemyclasses");
    
    final ResourceBundle ITEMS = ResourceBundle.getBundle("rogue.model.translations.items.items");
    final ResourceBundle EDIBLES = ResourceBundle.getBundle("rogue.model.translations.items.edibles.edibles");
    final ResourceBundle EDIBLETYPES = ResourceBundle.getBundle("rogue.model.translations.items.edibles.edibletypes.edibletypes");
    final ResourceBundle STUFFPIECES = ResourceBundle.getBundle("rogue.model.translations.items.stuffpieces.stuffpieces");
    final ResourceBundle STUFFPLACES = ResourceBundle.getBundle("rogue.model.translations.items.stuffpieces.stuffplaces.stuffplaces");
    
    final ResourceBundle WORDS = ResourceBundle.getBundle("rogue.model.translations.words.words");
}
