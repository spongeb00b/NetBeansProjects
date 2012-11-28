/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package videoteca;

/**
 *
 * @author raffaele
 */
abstract class Film {

String titolo;
int anno;

Film(String titolo, int anno){
    this.titolo = titolo;
    this.anno = anno;
}
abstract int copie();

abstract void mostra();

}
