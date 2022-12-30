package score.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import score.ov.ScoreVO;

public class ScoreView extends JPanel{
	
	JTable table;
	DefaultTableModel model;
	ArrayList<ScoreVO> scoreList;
	String[] header = {"학년", "반", "번호", "이름", "국어","영어","수학","과학","총점","평균"};
	
	JPanel panS;
	JLabel[] lbls = new JLabel[header.length-2];
	JTextField[] tf = new JTextField[header.length-2];
	JButton btnAdd = new JButton("성적추가");
	
	public ScoreView() {
		setLayout(new BorderLayout());
		
		
		
		panS = new JPanel();
		panS.setLayout(new GridLayout(5,4));
		for(int i = 0; i<lbls.length; i++) {
			lbls[i] = new JLabel(header[i]);
			panS.add(lbls[i]);
			tf[i] = new JTextField();
			panS.add(tf[i]);
		}
		for(int i = 0; i<3; i++) {
			panS.add(new JLabel(" "));
		}
		panS.add(btnAdd);
	}
	
	public void inintView() {
		model = new DefaultTableModel(header, scoreList.size()) {
			@Override
			public boolean isCellEditable(int row, int column) {	
				return false;
			}
		};
		
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(50);
		table.getColumnModel().getColumn(8).setPreferredWidth(50);
		table.getColumnModel().getColumn(9).setPreferredWidth(50);
		
		JScrollPane scroll = new JScrollPane(table);
		
		putResult();
		
		add("Center", scroll);
		add("South", panS);
	}

	public void putResult() {
		model.setRowCount(scoreList.size());
		ScoreVO vo = null;
		for(int i = 0; i<scoreList.size(); i++) {
			vo = scoreList.get(i);
			
			model.setValueAt(vo.getGrade(), i, 0);//입력 순서
			model.setValueAt(vo.getGroup(), i, 1);
			model.setValueAt(vo.getStudentNum(), i, 2);
			model.setValueAt(vo.getStudentName(), i, 3);
			model.setValueAt(vo.getKor(), i, 4);
			model.setValueAt(vo.getEng(), i, 5);
			model.setValueAt(vo.getMat(), i, 6);
			model.setValueAt(vo.getSci(), i, 7);
			model.setValueAt(vo.getTotal(), i, 8);
			model.setValueAt(vo.getAverage(), i, 9);
		}
		
	}
	public void setScoreList (ArrayList<ScoreVO> scoreList) {
		this.scoreList = scoreList;
	}
	public JButton getBtnAdd() {
		return btnAdd;
	}
	public ScoreVO neededInsertData() {
		ScoreVO vo = new ScoreVO();
		vo.setGrade(Integer.parseInt(tf[0].getText())); //입력 순서
		vo.setGroup(Integer.parseInt(tf[1].getText()));
		vo.setStudentNum(Integer.parseInt(tf[2].getText()));
		vo.setStudentName(tf[3].getText());
		vo.setKor(Integer.parseInt(tf[4].getText()));
		vo.setEng(Integer.parseInt(tf[5].getText()));
		vo.setMat(Integer.parseInt(tf[6].getText()));
		vo.setSci(Integer.parseInt(tf[7].getText()));
		vo.setTotal();
		vo.setAverage();	
		return vo;
	}
	
	public void initInsertData() {
		for(int i = 0; i<tf.length; i++) {
			tf[i].setText("");
		}
	}
	

	public JTable getTable() {
		return table;
	}
	
}
