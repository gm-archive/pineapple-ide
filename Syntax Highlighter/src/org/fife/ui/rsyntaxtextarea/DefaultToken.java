/*
 * 10/28/2004
 *
 * DefaultToken.java - The default token used in syntax highlighting.
 * Copyright (C) 2004 Robert Futrell
 * robert_futrell at users.sourceforge.net
 * http://fifesoft.com/rsyntaxtextarea
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307 USA.
 */
package org.fife.ui.rsyntaxtextarea;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.text.Segment;
import javax.swing.text.TabExpander;


/**
 * The default token used in the <code>org.fife.ui.rsyntaxtextarea</code> syntax
 * package.  This token type paints itself as you would expect, and properly
 * accounts for rendering hints (anti-aliasing and fractional fontmetrics).<p>
 *
 * The current implementation paints as follows:
 * <ul>
 *   <li>The first tab, if any, is found in the token.</li>
 *   <li>All characters up to that tab, if it exists, are painted as a
 *       group.  If no tab was found, all characters in the token are
 *       painted.</li>
 *   <li>If a tab was found, its width is calculated and it is painted.</li>
 *   <li>Repeat until all characters are painted.</li>
 * </ul>
 * This method allows for rendering hints to be honored, since all possible
 * characters are painted in a group.  However, adjacent tokens will not have
 * their "touching" characters rendered with rendering hints.<p>
 *
 * A problem with this implementation is that FontMetrics.charsWidth() is still
 * used to calculate the width of a group of chars painted.  Thus, the group of
 * characters will be painted with the rendering hints specified, but the
 * following tab (or group of characters if the current group was the end of a
 * token) will not necessarily be painted at the proper x-coordinate (as
 * FontMetrics.charsWidth() returns an <code>int</code> and not a
 * <code>float</code>).  The way around this would be to calculate the token's
 * width in such a way that a float is returned (Font.getStringBounds()?).
 *
 * @author Robert Futrell
 * @version 0.3
 * @see Token
 * @see VisibleWhitespaceToken
 */
public class DefaultToken extends Token {


	/**
	 * Creates a "null token."  The token itself is not null; rather, it
	 * signifies that it is the last token in a linked list of tokens and
	 * that it is not part of a "multiline token."
	 */
	public DefaultToken() {
		super();
	}


	/**
	 * Constructor.
	 *
	 * @param line The segment from which to get the token.
	 * @param beg The first character's position in <code>line</code>.
	 * @param end The last character's position in <code>line</code>.
	 * @param startOffset The offset into the document at which this
	 *        token begins.
	 * @param type A token type listed as "generic" above.
	 */
	public DefaultToken(final Segment line, final int beg, final int end,
							final int startOffset, final int type) {
		this(line.array, beg,end, startOffset, type);
	}


	/**
	 * Constructor.
	 *
	 * @param line The segment from which to get the token.
	 * @param beg The first character's position in <code>line</code>.
	 * @param end The last character's position in <code>line</code>.
	 * @param startOffset The offset into the document at which this
	 *        token begins.
	 * @param type A token type listed as "generic" above.
	 */
	public DefaultToken(final char[] line, final int beg, final int end,
							final int startOffset, final int type) {
		super(line, beg,end, startOffset, type);
	}


	/**
	 * Determines the offset into this token list (i.e., into the
	 * document) that covers pixel location <code>x</code> if the token list
	 * starts at pixel location <code>x0</code><p>.
	 * This method will return the document position "closest" to the
	 * x-coordinate (i.e., if they click on the "right-half" of the
	 * <code>w</code> in <code>awe</code>, the caret will be placed in
	 * between the <code>w</code> and <code>e</code>; similarly, clicking on
	 * the left-half places the caret between the <code>a</code> and
	 * <code>w</code>).  This makes it useful for methods such as
	 * <code>viewToModel</code> found in <code>javax.swing.text.View</code>
	 * subclasses.
	 *
	 * @param textArea The text area from which the token list was derived.
	 * @param e How to expand tabs.
	 * @param x0 The pixel x-location that is the beginning of
	 *        <code>tokenList</code>.
	 * @param x The pixel-position for which you want to get the corresponding
	 *        offset.
	 * @return The position (in the document, NOT into the token list!) that
	 *         covers the pixel location.  If <code>tokenList</code> is
	 *         <code>null</code> or has type <code>Token.NULL</code>, then
	 *         <code>-1</code is returned; the caller should recognize this and
	 *         return the actual end position of the (empty) line.
	 */
	public int getListOffset(RSyntaxTextArea textArea, TabExpander e,
								float x0, float x) {

		// If the coordinate in question is before this line's start, quit.
		if (x0 >= x)
			return offset;

		float currX = x0;	// x-coordinate of current char.
		float nextX = x0;	// x-coordinate of next char.
		float stableX = x0;	// Cached ending x-coord. of last tab or token.
		Token token = this;
		int last = offset;
		FontMetrics fm = null;

		while (token!=null && token.isPaintable()) {

			fm = textArea.getFontMetricsForTokenType(token.type);
			char[] text = token.text;
			int start = token.textOffset;
			int end = start + token.textCount;

			for (int i=start; i<end; i++) {
				currX = nextX;
				if (text[i] == '\t') {
					nextX = e.nextTabStop(nextX, 0);
					stableX = nextX;	// Cache ending x-coord. of tab.
					start = i+1;		// Do charsWidth() from next char.
				}
				else {
					nextX = stableX + fm.charsWidth(text, start, i-start+1);
				}
				if (x>=currX && x<nextX) {
					if ((x-currX) < (nextX-x))
						return last + i-token.textOffset;
					else
						return last + i+1-token.textOffset;
				}
			}

			stableX = nextX;		// Cache ending x-coordinate of token.
			last += token.textCount;
			token = token.getNextToken();

		}

		// If we didn't find anything, return the end position of the text.
		return last;

	}


	/**
	 * Returns the width of a specified number of characters in this token.
	 * For example, for the token "while", specifying a value of <code>3</code>
	 * here returns the width of the "whi" portion of the token.<p>
	 *
	 * @param numChars The number of characters for which to get the width.
	 * @param textArea The text area in which this token is being painted.
	 * @param e How to expand tabs.  This value cannot be <code>null</code>.
	 * @param x0 The pixel-location at which this token begins.  This is needed
	 *        because of tabs.
	 * @return The width of the specified number of characters in this token.
	 * @see #getWidth
	 */
	public float getWidthUpTo(int numChars, RSyntaxTextArea textArea,
							TabExpander e, float x0) {
		float width = x0;
		FontMetrics fm = textArea.getFontMetricsForTokenType(type);
		if (fm!=null) {
			int w;
			int currentStart = textOffset;
			int endBefore = textOffset + numChars;
			for (int i=currentStart; i<endBefore; i++) {
				if (text[i] == '\t') {
					// Since TokenMaker implementations usually group all
					// adjacent whitespace into a single token, there
					// aren't usually any characters to compute a width
					// for here, so we check before calling.
					w = i-currentStart;
					if (w>0)
						width += fm.charsWidth(text, currentStart, w);
					currentStart = i+1;
					width = e.nextTabStop(width, 0);
				}
			}
			// Most (non-whitespace) tokens will have characters at this
			// point to get the widths for, so we don't check for w>0 (mini-
			// optimization).
			w = endBefore-currentStart;
			width += fm.charsWidth(text, currentStart, w);
		}
		return width - x0;
	}


	/**
	 * Returns the bounding box for the specified document location.  The
	 * location must be in the specified token list.
	 *
	 * @param textArea The text area from which the token list was derived.
	 * @param e How to expand tabs.
	 * @param pos The position in the document for which to get the bounding
	 *        box in the view.
	 * @param x0 The pixel x-location that is the beginning of
	 *        <code>tokenList</code>.
	 * @param rect The rectangle in which we'll be returning the results.  This
	 *        object is reused to keep from frequent memory allocations.
	 * @return The bounding box for the specified position in the model.
	 */
	public Rectangle listOffsetToView(RSyntaxTextArea textArea,
								TabExpander e, int pos, int x0,
								Rectangle rect) {

		float stableX = x0;	// Cached ending x-coord. of last tab or token.
		Token token = this;
		FontMetrics fm = null;

		while (token!=null && token.isPaintable()) {

			fm = textArea.getFontMetricsForTokenType(token.type);
			if (fm==null) {
				return rect; // Don't return null as things'll error.
			}
			char[] text = token.text;
			int start = token.textOffset;
			int end = start + token.textCount;
			int i;

			// If this token contains the position for which to get the
			// bounding box...
			if (token.containsPosition(pos)) {
				end = start + (pos-token.offset);
				for (i=start; i<end; i++) {
					if (text[i] == '\t') {
						stableX += fm.charsWidth(text, start, i-start+1);
						stableX = e.nextTabStop(stableX, 0);
						start = i+1;	// Do charsWidth() from next char.
					}
				}
				int temp = fm.charsWidth(text, start, i-start);
				rect.x = (int)stableX + temp;
				if (text[i]=='\t')
					rect.width = fm.charWidth(' ');
				else
					rect.width = fm.charsWidth(text, start,i-start+1) - temp;
				return rect;
			}

			// If this token does not contain the position for which to get
			// the bounding box...
			else {
				for (i=start; i<end; i++) {
					if (text[i] == '\t') {
						stableX += fm.charsWidth(text, start, i-start+1);
						stableX = e.nextTabStop(stableX, 0);
						start = i+1;	// Do charsWidth() from next char.
					}
				}
				stableX += fm.charsWidth(text, start, i-start);
			}

			token = token.getNextToken();

		}

		// If we didn't find anything, we're at the end of the line.  Return
		// a width of 1 (so selection highlights don't extend way past line's
		// text).  A ConfigurableCaret will know to paint itself with a larger
		// width.
		rect.x = (int)stableX;
		rect.width = 1;
		return rect;

	}


	/**
	 * Makes this token start at the specified offset into the document.
	 *
	 * @param pos The offset into the document this token should start at.
	 *        Note that this token must already contain this position; if
	 *        it doesn't, an exception is thrown.
	 * @throws IllegalArgumentException If pos is not already contained by
	 *         this token.
	 */
	public void makeStartAt(int pos) {
		if (pos<offset || pos>=(offset+textCount)) {
			throw new IllegalArgumentException("pos " + pos +
				" is not in range " + offset + "-" + (offset+textCount-1));
		}
		int shift = pos - offset;
		offset = pos;
		textOffset += shift;
		textCount -= shift;
	}


	/**
	 * Paints this token.
	 *
	 * @param g The graphics context in which to paint.
	 * @param x The x-coordinate at which to paint.
	 * @param y The y-coordinate at which to paint.
	 * @param host The text area this token is in.
	 * @param e How to expand tabs.
	 * @param clipStart The left boundary of the clip rectangle in which we're
	 *        painting.  This optimizes painting by allowing us to not paint
	 *        when this token is "to the left" of the clip rectangle.
	 * @return The x-coordinate representing the end of the painted text.
	 */
	public float paint(Graphics2D g, float x, float y, RSyntaxTextArea host,
								TabExpander e, float clipStart) {

		int origX = (int)x;
		int end = textOffset + textCount;
		float nextX = x;
		int flushLen = 0;
		int flushIndex = textOffset;
		Color fg = host.getForegroundForToken(this);
		Color bg = host.getBackgroundForTokenType(type);
		g.setFont(host.getFontForTokenType(type));
		FontMetrics fm = host.getFontMetricsForTokenType(type);

		for (int i=textOffset; i<end; i++) {
			switch (text[i]) {
				case '\t':
					nextX = e.nextTabStop(
						x+fm.charsWidth(text, flushIndex,flushLen), 0);
					if (bg!=null) {
						paintBackground(x,y, nextX-x,fm.getHeight(),
										g, fm.getAscent(), host, bg);
					}
					if (flushLen > 0) {
						g.setColor(fg);
						g.drawString(
							new String(text, flushIndex, flushLen), x,y);
						flushLen = 0;
					}
					flushIndex = i + 1;
					x = nextX;
					break;
				default:
					flushLen += 1;
					break;
			}
		}

		nextX = x+fm.charsWidth(text, flushIndex,flushLen);

		if (flushLen>0 && nextX>=clipStart) {
			if (bg!=null) {
				paintBackground(x,y, nextX-x,fm.getHeight(),
								g, fm.getAscent(), host, bg);
			}
			g.setColor(fg);
			g.drawString(new String(text, flushIndex, flushLen), x,y);
		}

		if (host.getUnderlineForToken(this)) {
			g.setColor(fg);
			int y2 = (int)(y+1);
			g.drawLine(origX,y2, (int)nextX,y2);
		}

		return nextX;

	}


}