import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numArr[] = new int[3]; // 랜덤으로 생성된 숫자를 저장할 배열
        int inputArr[] = new int[3]; // 유저가 입력한 숫자를 저장할 배열

        int strike; // 스트라이크 개수
        int ball; // 볼 개수

        // 과정1: 랜덤으로 생성된 숫자 배열 초기화
        initNumArr(numArr);

        // 랜덤 숫자 확인용 출력
        System.out.println("컴퓨터가 생성한 숫자 답을 맞춰보세요! ");

         /*
        for (int x : numArr) {
            System.out.print(x + " ");
        }
        System.out.println();
         */

        // 횟수 카운트 다운
        Scanner sc = new Scanner(System.in);
        int cnt = 0;

        // while문 돌리기
        while (true) {
            strike = 0;
            ball = 0;
            cnt++;

            // 과정2: 유저로부터 숫자 입력 받기
            System.out.println(cnt + "번째 시도 : ");
            getUserInput(inputArr, sc);

            // 과정3: 스트라이크와 볼 계산
            calculateScore(numArr, inputArr, strike, ball);

            // 결과 출력
            System.out.println(strike + "S" + ball + "B");

            // 정답인 경우 게임 종료
            if (strike == 3) {
                System.out.println(cnt + "번 만에 맞혔습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
        // 입력 종료
        sc.close();
    }

    // 유저로부터 숫자 입력 받기
    private static void getUserInput(int[] inputArr, Scanner sc) {
        String input;
        boolean validInput = false;
        do {
            input = sc.nextLine();

            if (input.length() != 3) {
                System.out.println("세 자리 숫자를 입력해야 합니다.");
            } else {
                try {
                    for (int i = 0; i < inputArr.length; i++) {
                        inputArr[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
                    }
                    if (isValidInput(inputArr)) {
                        validInput = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력해야 합니다.");
                }
            }
        } while (!validInput);
    }

    // 입력된 숫자가 유효한지 검사 (중복 확인)
    private static boolean isValidInput(int[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            for (int j = i + 1; j < inputArr.length; j++) {
                if (inputArr[i] == inputArr[j]) {
                    System.out.println("중복된 숫자입니다. 다시 입력해주세요.");
                    return false;
                }
            }
        }
        return true;
    }

    // 스트라이크와 볼 계산 메서드
    private static void calculateScore(int[] numArr, int[] inputArr, int strike, int ball) {
        for (int i = 0; i < numArr.length; i++) {
            for (int j = 0; j < inputArr.length; j++) {
                if (numArr[i] == inputArr[j]) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }
    }

    // 랜덤 숫자 배열 초기화 메서드
    private static void initNumArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 9 + 1); // 1부터 9까지의 랜덤 숫자 생성
            for (int j = 0; j < i; j++) {
                if (arr[j] == arr[i]) {
                    i--; // 중복된 숫자가 있으면 다시 생성
                    break;
                }
            }
        }
    }
}
//
