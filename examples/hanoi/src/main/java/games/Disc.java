package games;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Klasse Disc: stellt eine Scheibe dar, die selektiert und 
 * gezeichnet werden kann. 
 */
class Disc {
    int _width=0;
    boolean _isSelected=false;

    /**
     * Konstruktor: erzeugt eine Scheibe mit der Breite w
     */
    public Disc( int w ){
	_width = w;
	_isSelected = false;
    }
    /**
     * selektiert die Scheibe
     */
    public void select(){
	_isSelected = true;
    }
    /**
     * macht die Selektion r�ckg�ngig
     */
    public void unselect(){
	_isSelected = false;
    }

    /**
     * Zeichnet die Scheibe neu
     * @param g java.awt.Graphics
     * @param hw HanoiWindow
     * @param hpos int horizontale Position
     * @param vpos int vertikale Position
     */
    public void paint( Graphics g, HanoiWindow hw,
		       int hpos, int vpos ){
	int x, y, w, h;
	x = hpos - _width/2;
	y = vpos;
	w = _width;
	h = 1;
	if( _isSelected )
	    hw.drawBar(g, x, y, w, h, Color.yellow);
	else
	    hw.drawBar(g, x, y, w, h, Color.blue);
    }
}
