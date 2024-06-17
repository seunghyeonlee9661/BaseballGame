import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 1. 정답 생성
		String answer = getAnswer(3);
		Scanner scanner = new Scanner(System.in);
		System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

		// 2. 입력 초기화
		String input = "";
		int cnt = 0;

		// 3. 입력 확인
		while (!input.equals(answer)) {
			System.out.println(++cnt + "번째 시도 : ");
			input = scanner.nextLine();
			checkInput(input, answer);
		}

		// 4. 결과 출력
		System.out.println(cnt + "번만에 맞히셨습니다.");
		System.out.println("게임을 종료합니다.");
	}

	// 입력과 정답을 비교해 스트라이크와 볼을 출력하는 함수
	private static void checkInput(String input, String answer) {
		int ball = 0;
		int strike = 0;

		for (String s : input.split("")) {
			if (answer.indexOf(s) >= 0) {
				if (answer.indexOf(s) == input.indexOf(s))
					strike++;
				else
					ball++;
			}
		}

		if (ball == 0 && strike == 0)
			System.out.print("0B0S");
		else {
			if (ball > 0)
				System.out.print(ball + "B");
			if (strike > 0)
				System.out.print(strike + "S");
		}
		System.out.println();

	}

	// 중복없는 숫자 조합을 생성하는 함수
	private static String getAnswer(int size) {
		Random random = new Random();
		String answer = "";
		String number;
		while (answer.length() < size) {
			number = Integer.toString(random.nextInt(10));
			if (answer.indexOf(number) > 0)
				continue;
			answer = answer + number;
		}
		return answer;
	}

}
