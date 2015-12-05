package ru.ars.mephi.swtexample;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class SelectorComposite extends Composite {
	
	private final static String DEFAULT_SELECT_FONT_TEXT       = "Выберите шрифт";
	private final static String DEFAULT_SELECT_FONT_COLOR_TEXT = "Выберите цвет шрифта";
	private final static String DEFAULT_SELECT_BG_COLOR_TEXT   = "Выберите цвет фона";
	
	private final PictureComposite pictureComposite;
	
	public SelectorComposite(PictureComposite pictureComposite, Composite composite) {
		super(composite, SWT.NONE);
		this.pictureComposite = pictureComposite;
		
		setLayout(new GridLayout(2, false));
		
		createFontSelector();
		createFontColorSelector();
		createBgColorSelector();
		
		final Label label = new Label(this, SWT.NONE);
		label.setText("Текст:");
		label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		
		final Text text = new Text(this, SWT.NONE);
		text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				pictureComposite.setText(text.getText());
				pictureComposite.redraw();
			}
		});
	}

	private void createBgColorSelector() {
		createSelector(DEFAULT_SELECT_BG_COLOR_TEXT, new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				final ColorDialog colorDialog = new ColorDialog(getShell());
				colorDialog.setRGB(pictureComposite.getBackground().getRGB());
				
				final RGB rgb = colorDialog.open();
				if (rgb != null) {
					final Color prevColor = pictureComposite.getForeground();
					
					pictureComposite.setBackground(createColor(rgb));
					pictureComposite.redraw();
					
					prevColor.dispose();
				}
			}
		});
	}

	private void createFontColorSelector() {
		createSelector(DEFAULT_SELECT_FONT_COLOR_TEXT, new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				final ColorDialog colorDialog = new ColorDialog(getShell());
				colorDialog.setRGB(pictureComposite.getForeground().getRGB());
				
				final RGB rgb = colorDialog.open();
				if (rgb != null) {
					final Color prevColor = pictureComposite.getForeground();
					
					pictureComposite.setForeground(createColor(rgb));
					pictureComposite.redraw();
					
					prevColor.dispose();
				}
			}
		});
	}

	private void createFontSelector() {
		createSelector(DEFAULT_SELECT_FONT_TEXT, new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				final FontDialog fontDialog = new FontDialog(getShell());
				fontDialog.setFontList(pictureComposite.getFont().getFontData());
				
				final FontData fontData = fontDialog.open();
				if (fontData != null) {
					final Font prevFont = pictureComposite.getFont();
					
					pictureComposite.setFont(createFont(fontData));
					pictureComposite.redraw();
					
					prevFont.dispose();
				}
			}
		});
	}
	
	private void createSelector(String labelText, SelectionListener listener) {
		final Label label = new Label(this, SWT.NONE);
		label.setText(labelText);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, false, 2, 1));
		
		final Label label1 = new Label(this, SWT.NONE);
		label1.setText(labelText + "-----");
		label1.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
		gd.horizontalIndent = 20;
		
		label1.setLayoutData(gd);
		
		final Button button = new Button(this, SWT.PUSH);
		button.setText("Выбрать...");
		
		gd = new GridData(SWT.FILL, SWT.FILL, true, false);
		gd.horizontalIndent = 50;
		
		
		button.setLayoutData(gd);
		button.addSelectionListener(listener);
	}
	
	private Font createFont(FontData fontData) {
		return new Font(getShell().getDisplay(), fontData);
	}
	
	private Color createColor(RGB rgb) {
		return new Color(getShell().getDisplay(), rgb);
	}
}














