package games;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.Stack;

	/**
	 * Klasse Tower: stellt einen Turm dar, der mehrere Scheiben
	 * enthalten kann.
	 */
	class Tower {
	    HanoiWindow _hw;
	    int _id;
	    Stack _discs;

	    /** Konstruktor: erzeugt einen neuen Turm
	     *  @param num_discs int Anzahl Scheiben, die der Turm enth�lt
	     *  @param hw HanoiWindow
	     */
	    public Tower( int num_discs, HanoiWindow hw ){
		int i;
		_hw = hw;
		_discs = new Stack();
		for( i=0; i<num_discs; i++ ){
		    _discs.push( new Disc( 2*num_discs + 1 - 2*i ) );
		}
	    }
	    /** selektiert die oberste Scheibe
	     */
	    public void select(){
		int pos = _discs.size();
		if( pos > 0 ){
		    Disc d = (Disc)_discs.peek();
		    d.select();
		}
	    }
	    /** macht eine Selektion rückgängig
	     */
	    public void unselect(){
		int pos = _discs.size();
		if( pos > 0 ){
		    Disc d = (Disc)_discs.peek();
		    d.unselect();
		}
	    }
	    /** entnimmt die oberste Scheibe
	     * @return Scheibe
	     */
	    public Disc pop(){
		Disc d = (Disc) _discs.pop();
		d.unselect();
		return d;
	    }
	    /** legt eine Scheibe ab
	     *  @param d Disc
	     */
	    public  void push( Disc d ){
		_discs.push(d);
	    }
	    /** gibt true zur�ck, wenn keine Scheiben vorhanden sind
	     */
	    public boolean empty(){
		return _discs.empty();
	    }
	    /** zeichnet den Turm mit den vorhandenen Scheiben neu
	     *  @param g Graphics
	     *  @param hpos int horizontale Position
	     *  @param height int H�he
	     */
	    public void paint(Graphics g, int hpos, int height){
		Disc d;
		int vpos;
		_hw.drawBar( g, hpos, 1, 1, height, Color.lightGray );
		vpos=height-1;
		Iterator i=_discs.iterator();
		while( i.hasNext() ){
		    d = (Disc)i.next();
		    d.paint( g, _hw, hpos, vpos );
		    vpos -=2;
		}
	    }
	}
