
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.HealthFrame;

public class MyPageController {
	private HealthFrame myFrame;
	
	public MyPageController(HealthFrame myFrame) {
		this.myFrame = myFrame;
		myFrame.setMyPageController(this);
	}

}

