import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

class JSplashWindow extends JWindow implements Runnable {
	  
	  Thread splashThread=null;
	  private JProgressBar progress;
	 
	  public JSplashWindow() {
	    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
	    JPanel splash = new JPanel(new BorderLayout());
	    URL url = getClass().getClassLoader().getResource("plane.png");

	    if(url != null){
	      splash.add(new JButton(new ImageIcon(url)),
	      BorderLayout.CENTER);
	    }
	    progress = new JProgressBar(1,100);
	    progress.setStringPainted(true);
	    progress.setBorderPainted(false);
	    progress.setString("Program is Now Loading...");
	    progress.setBackground(Color.white);
	    splash.add(progress,BorderLayout.SOUTH);
	    setContentPane(splash);

	    Dimension screen = getToolkit().getScreenSize();
	    pack();
	    setLocation((screen.width - getSize().width) / 2,
		(screen.height - getSize().height) / 2);
	  }

	  public void start(){
	    this.toFront();
	    splashThread=new Thread(this);
	    splashThread.start();
	  }

	  public void run(){
	    show();
	    try {
	      for (int i=0;i<100;i++){
	        Thread.sleep(100);
	        progress.setValue(progress.getValue() + 1);
	      }
	    }
	    catch (Exception ex) {
	      ex.printStackTrace();
	    }
	    dispose();
	  }

	  static void begin() {
		  JSplashWindow splash = new JSplashWindow();
		  splash.start();

		  try {
		      Thread.sleep(10000);
		  } catch (Exception ex) {
		      ex.printStackTrace();
		  }
		  //JOptionPane.showMessageDialog(null,"ע����Դ�ɹ���");
	  }

	public static void main(String aggs[]) {
		begin();
	}
}

