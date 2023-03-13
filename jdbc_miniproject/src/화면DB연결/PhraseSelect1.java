package 화면DB연결;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import 자바DB연결.PhraseDAO;

public class PhraseSelect1 { // 작성자 아이디로 검색

	public void open() {

		JFrame f = new JFrame();
		f.setTitle("글귀 게시판");
		f.setSize(500, 700);
		
		JLabel top = new JLabel("좋은 글귀 게시판");

		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);

		PhraseDAO dao = new PhraseDAO();
		String input = JOptionPane.showInputDialog(f, "검색할 아이디를 입력하세요.");

		ArrayList<PhraseVO> list = dao.list2(input);

		String[] header = { "번호", "작성자", "제목", "책ID", "내용" }; // 테이블 컬럼
		Object[][] all = new Object[list.size()][header.length]; // 테이블 데이터

		// 데이터 가져오기
		if (list.size() == 0) {
			JOptionPane.showMessageDialog(f, "게시글 없음");
		} else {
			for (int i = 0; i < all.length; i++) {
				all[i][0] = list.get(i).getNo();
				all[i][1] = list.get(i).getId();
				all[i][2] = list.get(i).getTitle();
				all[i][3] = list.get(i).getBook();
				all[i][4] = list.get(i).getContent();
			}
		}

		// 테이블 생성 후 모델 설정
		JTable table = new JTable(all, header);

		// 테이블 크기 조정
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(25);
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn column0 = columnModel.getColumn(0);
		TableColumn column1 = columnModel.getColumn(1);
		TableColumn column2 = columnModel.getColumn(2);
		TableColumn column3 = columnModel.getColumn(3);
		TableColumn column4 = columnModel.getColumn(4);
		column0.setPreferredWidth(45);
		column1.setPreferredWidth(60);
		column2.setPreferredWidth(120);
		column3.setPreferredWidth(45);
		column4.setPreferredWidth(200);

		// 스크롤
		JScrollPane scroll = new JScrollPane(table);

		JButton b1 = new JButton("전체 목록으로");

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.dispose();
				PhraseMain name = new PhraseMain();
			}
		});

		Font font = new Font("고딕", Font.BOLD, 30);
		Font font2 = new Font("고딕", Font.BOLD, 20);
		top.setFont(font);
		table.setFont(font2);
		b1.setFont(font2);

		f.getContentPane().setBackground(Color.green);
		top.setForeground(Color.blue);

		f.add(top);
		f.add(scroll, BorderLayout.CENTER);
		f.add(b1);

		f.setVisible(true);
	}

}
