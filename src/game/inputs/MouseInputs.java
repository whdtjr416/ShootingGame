package game.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import game.main.GamePanel;

public class MouseInputs implements MouseListener, MouseMotionListener {
    private GamePanel gamePanel;

    public MouseInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // 필요한 경우 여기에 마우스 클릭 이벤트 처리 코드 추가
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // 필요한 경우 여기에 마우스 누르기 이벤트 처리 코드 추가
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // 필요한 경우 여기에 마우스 떼기 이벤트 처리 코드 추가
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // 필요한 경우 여기에 마우스가 들어올 때 이벤트 처리 코드 추가
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // 필요한 경우 여기에 마우스가 나갈 때 이벤트 처리 코드 추가
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // 필요한 경우 여기에 마우스 드래그 이벤트 처리 코드 추가
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // 필요한 경우 여기에 마우스 이동 이벤트 처리 코드 추가
    }
}
