/*
 * Everyone is authorized to read, copy and share the code below
 * if the authors are credited
 */
package rogue;

/**
 *
 * @author Thomas
 */
public interface Config {

    // Tableau des niveaux : {longueur, hauteur, murs, ennemis, nombre d'equipements, nombre de consommables}
    final Integer[][] LEVELS = {
        {3, 3, 1, 1, 1, 1},
        {5, 5, 2, 2, 3, 3},
        {9, 9, 5, 5, 6, 6}
    };
}
