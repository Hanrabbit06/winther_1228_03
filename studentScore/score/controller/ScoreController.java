package score.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import info.vo.BookVO;
import score.ov.ScoreDAO;
import score.ov.ScoreVO;
import score.view.ScoreView;

public class ScoreController extends JFrame{
	ScoreDAO dao;
	ArrayList<ScoreVO> scoreList;
	ScoreView view;
	JTable table;
	
	public ScoreController() {
		dao = new ScoreDAO();
		view = new ScoreView();
		scoreList = dao.select();
		view.setScoreList(scoreList);
		view.inintView();
		JButton btnAdd = view.getBtnAdd();
		btnAdd.addActionListener(btnAddL);
		table = view.getTable();
		table.addMouseListener(tableL);
		add(view,"Center");
		setTitle("성적처리 프로그램");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(200, 200);
		setSize(600, 500);
		setVisible(true);
	}
	
	public static void main (String[] args) {
		new ScoreController();
	}
	ActionListener btnAddL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ScoreVO vo = view.neededInsertData();
			dao.insert(vo);
			scoreList = dao.select();
			view.setScoreList(scoreList);
			view.putResult();
			view.initInsertData();
		}
	};
	
	MouseAdapter tableL = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int state = 1;
			if(e.getClickCount()==2) {
				state = JOptionPane.showConfirmDialog(ScoreController.this, "정말 삭제하세겠습니까?", "삭제여부", JOptionPane.YES_NO_OPTION);
				if(state == JOptionPane.YES_NO_OPTION) {
					dao.delete(table.getSelectedRow());
					scoreList = dao.select();
					view.setScoreList(scoreList);
					view.putResult();
				}
			}
		}
	};

}
