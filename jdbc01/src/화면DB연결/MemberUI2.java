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

import 자바DB연결.MemberDAO3;

public class MemberUI2 {

	public static void main(String[] args) {

		JFrame f = new JFrame();
		f.setTitle("나의 회원가입 화면");
		f.setSize(400, 800);

		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);

		JButton top = new JButton("회원가입 화면");

		JLabel l1 = new JLabel("아이디");
		JLabel l2 = new JLabel("패스워드");
		JLabel l3 = new JLabel("이름");
		JLabel l4 = new JLabel("전화번호");

		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		JTextField t3 = new JTextField(10);
		JTextField t4 = new JTextField(10);

		JButton b1 = new JButton("회원가입 처리");
		JButton b2 = new JButton("회원탈퇴 처리");
		JButton b3 = new JButton("회원수정 처리");
		JButton b4 = new JButton("회원검색 처리");

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				String pw = t2.getText();
				String name = t3.getText();
				String tel = t4.getText();
				if (id.equals("")) {
					JOptionPane.showMessageDialog(f, "id는 필수입력 항목입니다.");
				}

				MemberDAO3 dao = new MemberDAO3();
				// 1. 가방을 만들어주기
				MemberVO bag = new MemberVO();
				// 2. 가방에 값을 넣어주기
				bag.setId(id);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
				// 3. 값들이 들어있는 가방을 전달하자.
				int result = dao.insert(bag);

				if (result == 1) {
					JOptionPane.showMessageDialog(f, "회원가입 성공");
				} else {
					JOptionPane.showMessageDialog(f, "회원가입 실패. 재입력해주세요.");
				}
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
			}// action
		});// b1

		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog(f, "삭제할 아이디를 입력하세요.");

				MemberDAO3 dao = new MemberDAO3();
				MemberVO bag = new MemberVO();
				// 2. 가방에 값을 넣어주기
				bag.setId(id);
				
				int result = dao.delete(bag);
				if (result == 1) {
					JOptionPane.showMessageDialog(f, "회원정보 삭제 완료");
				} else {
					JOptionPane.showMessageDialog(f, "회원정보 삭제 실패. 재입력해주세요.");
				}
			}// action
		});// b2

		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog(f, "수정할 아이디를 입력하세요");
				String tel = JOptionPane.showInputDialog(f, "수정할 전화번호를 입력하세요");

				MemberDAO3 dao = new MemberDAO3();
				MemberVO bag = new MemberVO();
				bag.setId(id);
				bag.setTel(tel);
				int result = dao.update(bag);
				if (result == 1) {
					JOptionPane.showMessageDialog(f, "전화번호 수정 완료");
				} else {
					JOptionPane.showMessageDialog(f, "전화번호 수정 실패. 재입력해주세요.");
				}

			}// action
		});// b3

		Font font = new Font("D2Coding", Font.BOLD, 40);
		Font font2 = new Font("D2Coding", Font.BOLD, 30);
		top.setFont(font);
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		t1.setFont(font);
		t2.setFont(font);
		t3.setFont(font);
		t4.setFont(font);
		b1.setFont(font2);
		b2.setFont(font2);
		b3.setFont(font2);
		b4.setFont(font2);

		f.getContentPane().setBackground(Color.green);

		f.add(top);
		f.add(l1);
		f.add(t1);
		f.add(l2);
		f.add(t2);
		f.add(l3);
		f.add(t3);
		f.add(l4);
		f.add(t4);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
