package ru.ars.mephi.swtexample;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class Main {
	
	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		
		shell.setLayout(new FillLayout(SWT.VERTICAL));
		
//		final Label l = new Label(shell, SWT.NONE);
//		l.setText("adsfasdfasdfasfd");
//		final Button b = new Button(shell, SWT.PUSH);
//		b.setText("ASDFADFAFSF");
//		b.setText("1234124 9809808 09809 8098080809808098 098 098 09 809 809809 809 809 ");
//		
//		final Button b2 = new Button(shell, SWT.CHECK);
//		b2.setText("1234124 9809808 09809 8098080809808098 098 098 09 809 809809 809 809 ");

		
//
		final PictureComposite pictureComposite = new PictureComposite(shell);
		new SelectorComposite(pictureComposite, shell);
	
//		Browser br = new Browser(shell, SWT.WEBKIT);
//		br.setUrl("http://yandex.com");
		shell.pack();
		shell.open();
		

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		display.dispose();
	}
}
