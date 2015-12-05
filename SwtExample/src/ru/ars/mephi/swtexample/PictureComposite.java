package ru.ars.mephi.swtexample;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class PictureComposite extends Canvas {

	
	private final static int DX = 2;
	
	protected static final int TIMER_INTERVAL = 10;
	
	
	
	Runnable runnable = new Runnable() {
		public void run() {
			animate();
			redraw();
			Display.getCurrent().timerExec(TIMER_INTERVAL, this);
		}
    };
    
    public void animate() {
		x += DX;
		
		final Rectangle bounds = PictureComposite.this.getBounds();
		
		if (x > bounds.width) {
			x = 0;
		}
	}
	
	private String text;
	
	public int x = 0;

	public PictureComposite(Composite parent) {
		super(parent, SWT.DOUBLE_BUFFERED);
		setLayout(new FillLayout());
		addPaintListener(new PGC());
		
	
		Display.getCurrent().timerExec(TIMER_INTERVAL, runnable);

		
	}

	private class PGC implements PaintListener {
		

		@Override
		public void paintControl(PaintEvent event) {
			if (text != null) {
				final GC gc = event.gc;
				
				final Rectangle bounds = PictureComposite.this.getBounds();
				final Point textSize = gc.textExtent(text);

//				final int x = (bounds.width - textSize.x) / 2;
				final int y = (bounds.height - textSize.y) / 2;

				
		//		Image img = 
				
				
				gc.drawText(text, x, y);
				
				
				
//				
//			gc.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
//				gc.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_YELLOW));
//				gc.setLineWidth(10);
//				gc.drawRoundRectangle(10, 10, 100, 100, 40, 20);
//				gc.fillOval(200, 200, 300, 500);	
			}
		}
		
		
	    
	    
	    
	    
	    
		
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
