package libs.gui;

import javax.swing.JFrame;

public class MyWindow extends JFrame{

	private static final long serialVersionUID = 8418841008914832126L;

	public MyWindow() {
		// TODO Auto-generated constructor stub
		newWindow();
	}
	
	public MyWindow(String title, int hSize, int vSize, int closeOperation){
		newWindow(title, hSize, vSize, closeOperation);
	}
	
	/*public enum WindowPosition {
		TOP(), BOTTOM(), LEFT(), CENTER(), RIGHT(), TOP_LEFT(), TOP_RIGHT(), BOTTOM_LEFT(), BOTTOM_RIGHT();
		
		private value;
		private WindowPosition(value){
			
		}
	}*/
	
	private void newWindow(){
		newWindow("Test Title", 300, 200, EXIT_ON_CLOSE);
	}
	
	private void newWindow(String title, int hSize, int vSize, int closeOperation){
		setTitle(title);
		setSize(hSize, vSize);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(closeOperation);
	}

}
