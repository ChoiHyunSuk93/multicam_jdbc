package 화면DB연결;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import 자바DB연결.PhraseDAO;

public class PhraseUpdate {

	public void open() {

		JFrame f = new JFrame();
		f.setTitle("게시글 수정");
		f.setSize(350, 700);

		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);

		JLabel l1 = new JLabel("게시판 번호");
		JLabel l2 = new JLabel("회원ID");
		JLabel l3 = new JLabel("게시판 제목");
		JLabel l4 = new JLabel("책ID");
		JLabel l5 = new JLabel("게시판 내용");

		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		JTextField t3 = new JTextField(10);
		JTextField t4 = new JTextField(10);
		JTextField t5 = new JTextField(10);

		JButton b1 = new JButton("게시글 수정");

		f.getContentPane().setBackground(Color.green);

		Font font = new Font("고딕", Font.BOLD, 30);
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		l5.setFont(font);
		t1.setFont(font);
		t2.setFont(font);
		t3.setFont(font);
		t4.setFont(font);
		t5.setFont(font);
		b1.setFont(font);

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (t1.getText().equals("")) {
					JOptionPane.showMessageDialog(f, "게시판 번호는 필수 입력 사항입니다.");
				} else {

					int no = Integer.parseInt(t1.getText());
					String id = t2.getText();
					String title = t3.getText();
					int book = Integer.parseInt(t4.getText());
					String content = t5.getText();

					PhraseDAO dao = new PhraseDAO();
					PhraseVO bag = new PhraseVO();

					bag.setNo(no);
					bag.setId(id);
					bag.setTitle(title);
					bag.setBook(book);
					bag.setContent(content);

					int result = dao.update(bag);

					if (result == 1) {
						JOptionPane.showMessageDialog(f, "게시글 수정 성공");
						f.dispose();
						PhraseMain main = new PhraseMain();
					} else {
						JOptionPane.showMessageDialog(f, "게시글 수정 실패. 재입력해주세요.");

					} // if-else
				} // if-else 전체
			} // action
		});// b2

		f.add(l1);
		f.add(t1);
		f.add(l2);
		f.add(t2);
		f.add(l3);
		f.add(t3);
		f.add(l4);
		f.add(t4);
		f.add(l5);
		f.add(t5);
		f.add(b1);

		f.setVisible(true);

	}

}
