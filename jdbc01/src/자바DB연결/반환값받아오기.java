package 자바DB연결;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;

public class 반환값받아오기 {

	public static void main(String[] args) {
		반환값연습 re = new 반환값연습(); // 메서드 12개
		re.add2();
		
		int result1 = re.add(1, 2);
		System.out.println(result1);
		
		double result2 = re.add(1.5, 2);
		System.out.println(result2);
		
		String result3 = re.add("안녕", "하세요");
		System.out.println(result3);
		
		String result4 = re.add(1, "살");
		System.out.println(result4);
		
		int[] result5 = re.add();
		result5[0] = 100;
		System.out.println(result5[0]);
		System.out.println(result5[1]);
		System.out.println(result5[2]);
		
		Date result6 = re.getDate();
		System.out.println(result6.getMinutes());
		System.out.println(result6.getSeconds());
		System.out.println(result6.getDay()); // 요일 : 0-일요일, 1-월요일 ... 
		
		int result7 = re.getHour();
		System.out.println(result7 + "시 입니다. 수업중.");
		
		int result8 = re.getRandom2();
		System.out.println("랜덤한 정수는 " + result8);
		
		ArrayList result9 = re.getList();
		System.out.println(result9.get(0) + " " + result9);
		result9.set(0, "양파");
		System.out.println(result9);
		
		HashSet result10 = re.getSet();
		System.out.println(result10);
		
		
		
		
			
	}

}
