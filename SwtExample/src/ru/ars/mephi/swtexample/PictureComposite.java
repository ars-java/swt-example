package ru.ars.mephi.swtexample;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class PictureComposite extends Canvas {

	private String text;

	public PictureComposite(Composite parent) {
		super(parent, SWT.DOUBLE_BUFFERED);
		setLayout(new FillLayout());
		addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent event) {
				if (text != null) {
					final GC gc = event.gc;
	
					final Rectangle bounds = PictureComposite.this.getBounds();
					final Point textSize = gc.textExtent(text);
	
					final int x = (bounds.width - textSize.x) / 2;
					final int y = (bounds.height - textSize.y) / 2;

					gc.drawText(text, x, y);
				}
			}
		});
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
