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

public class PhraseMain {

	public static void main(String[] args) {
		PhraseMain phraseMain = new PhraseMain();
	}

	public PhraseMain() {
		JFrame f = new JFrame();
		f.setTitle("글귀 게시판");
		f.setSize(500, 700);

		JLabel top = new JLabel("좋은 글귀 게시판");

		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);

		PhraseDAO dao = new PhraseDAO();
		ArrayList<PhraseVO> list = dao.list();

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

		// 버튼
		JButton b1 = new JButton("글쓰기");
		JButton b2 = new JButton("수  정");
		JButton b3 = new JButton("삭  제");
		JButton b4 = new JButton("작성자로 검색");
		JButton b5 = new JButton("책 ID로 검색");

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PhraseInsert insert = new PhraseInsert();
				insert.open();
				f.dispose();
			}
		});

		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PhraseUpdate update = new PhraseUpdate();
				update.open();
				f.dispose();
			}
		});

		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String input = JOptionPane.showInputDialog(f, "삭제할 게시판 번호를 입력하세요.");
				if (input.equals("")) {
					JOptionPane.showMessageDialog(f, "게시판 번호는 필수 입력 사항입니다.");
				} else {

					int no = Integer.parseInt(input);
					PhraseDAO dao = new PhraseDAO();
					PhraseVO bag = new PhraseVO();
					bag.setNo(no);
					int result = dao.delete(bag);
					if (result == 1) {
						JOptionPane.showMessageDialog(f, "게시글 삭제 완료");
						f.dispose();
						PhraseMain phraseMain = new PhraseMain();
					} else {
						JOptionPane.showMessageDialog(f, "게시글 삭제 실패. 재입력해주세요.");

					} // if-else

				} // if-else전체
			} // action
		}); // b3
		
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PhraseSelect1 select1 = new PhraseSelect1();
				select1.open();
				f.dispose();
			}
		});
		
		b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PhraseSelect2 select2 = new PhraseSelect2();
				select2.open();
				f.dispose();
			}
		});

		Font font = new Font("고딕", Font.BOLD, 30);
		Font font2 = new Font("고딕", Font.BOLD, 20);
		top.setFont(font);
		b1.setFont(font2);
		b2.setFont(font2);
		b3.setFont(font2);
		b4.setFont(font2);
		b5.setFont(font2);
		table.setFont(font2);

		f.getContentPane().setBackground(Color.green);
		top.setForeground(Color.blue);

		f.add(top);
		f.add(scroll, BorderLayout.CENTER);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
