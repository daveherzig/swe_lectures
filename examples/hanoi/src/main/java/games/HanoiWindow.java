/* $Id: HanoiWindow.java,v 1.1 2003/09/26 06:44:07 tar Exp $
 *                      The Towers of Hanoi 
 *
 * 
 *                      All Rights Reserved.
 *
 * WE DO NOT MAKE ANY REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY
 * OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. WE SHALL NOT BE LIABLE FOR ANY
 * DAMAGES SUFFERED BY USERS AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *
 * Author: Ronald Tanner                   Date: 2001/1/23
 */

package games;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Klasse HanoiWindow: stellt ein Fenster dar, das die Türme mit den Scheiben
 * enthält und auf Druckknopf-Ereignisse des Mauszeigers reagiert.
 */
public class HanoiWindow extends Canvas implements MouseListener {
	Tower[] _towers;
	final int NumDiscs = 5;
	final int NumTowers = 3;
	int _selectedTower;
	int moves;
	private boolean isRunning = false;

	/**
	 * Konstruktor: erzeugt ein neues Fenster
	 */
	public HanoiWindow() {
		setSize(new Dimension(600, 300));
		setBackground(Color.white);
		addMouseListener(this);
		reset();
	}

	/**
	 * stellt die Anfangssituation wieder her
	 */
	public void reset() {
		_selectedTower = -1;
		_towers = new Tower[NumTowers];
		_towers[0] = new Tower(NumDiscs, this);
		int i;
		for (i = 1; i < NumTowers; i++) {
			_towers[i] = new Tower(0, this);
		}
		moves = 0;
		repaint();
	}

	/**
	 * reagiert auf Druckknopf-Ereignisse des Mauszeigers
	 */
	public void mouseClicked(MouseEvent evt) {
		int width = getWidth() / NumTowers;
		int tower = evt.getX() / width;
		if (_selectedTower == -1) {
			if (!_towers[tower].empty()) {
				_selectedTower = tower;
				_towers[_selectedTower].select();
			}
		} else {
			Disc d = _towers[_selectedTower].pop();
			_towers[tower].push(d);
			_selectedTower = -1;
		}
		repaint();
	}

	public void mousePressed(MouseEvent evt) {
	}

	public void mouseEntered(MouseEvent evt) {
	}

	public void mouseExited(MouseEvent evt) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	/**
	 * gibt die Anzahl Zeilen zur�ck
	 */
	public int getRows() {
		return 2 * NumDiscs + 1;
	}

	public int getColumns() {
		return (2 * NumDiscs + 2) * NumTowers;
	}

	public int getNumDiscs() {
		return NumDiscs;
	}

	public int getNumTowers() {
		return NumTowers;
	}

	public void paint(Graphics g) {
		int i;
		int width = getColumns() / NumTowers;
		int height = getRows() - 1;
		for (i = 0; i < NumTowers; ++i) {
			int hpos = i * width + width / 2;
			_towers[i].paint(g, hpos, height);
		}
		drawBar(g, 0, getRows() - 1, getColumns() + 1, getRows(),
				Color.lightGray);
	}

	public void drawBar(Graphics g, int x, int y, int w, int h, Color c) {
		int tx = getWidth() / getColumns();
		int ty = getHeight() / getRows();
		g.setColor(c);
		g.fill3DRect(x * tx, y * ty, w * tx, h * ty, false);
	}

	public void stop() {
		isRunning = false;
	}

	public void moveDiscs() {
		isRunning = true;
		moveDisc(getNumDiscs(), 0, 1, 2);
	}

	void moveDisc(int h, int fromTower, int toTower, int withTower) {
		if (!isRunning || h < 1)
			return;

		moveDisc(h - 1, fromTower, withTower, toTower);
		if (!isRunning)
			return;

		moves++;
		Disc d = _towers[fromTower].pop();
		_towers[toTower].push(d);

		try {
			update(getGraphics());
			Thread.sleep(500);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		moveDisc(h - 1, withTower, toTower, fromTower);
	}
}
