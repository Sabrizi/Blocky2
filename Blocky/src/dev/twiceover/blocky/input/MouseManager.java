package dev.twiceover.blocky.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.twiceover.blocky.ui.UIManager;

public class MouseManager implements MouseListener, MouseMotionListener {

	private Boolean leftPressed, rightPressed;
	private int mousex, mousey;
	private UIManager uiManager;

	public MouseManager() {
		leftPressed = false;
		rightPressed = false;
	}
	
	public void setUIManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}
	
	public Boolean isLeftPressed() {
		return leftPressed;
	}
	
	public Boolean isRightPressed() {
		return rightPressed;
	}
	
	public int getMouseX() {
		return mousex;
	}
	
	public int getMouseY() {
		return mousey;
	}
	
	//Implemented Methods
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) leftPressed = true;
		else if(e.getButton() == MouseEvent.BUTTON3) rightPressed = true;

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) leftPressed = false;
		else if(e.getButton() == MouseEvent.BUTTON3) rightPressed = false;
		
		if(uiManager != null) {
			uiManager.onMouseRelease(e);
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mousex = e.getX();
		mousey = e.getY();
		
		if(uiManager != null) {
			uiManager.onMouseMove(e);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
