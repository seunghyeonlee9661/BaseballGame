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
            for (int i = 0; i < inputArr.length; i++) {
                inputArr[i] = sc.nextInt();
                sc.nextLine(); // 개행 문자 소모

                // 중복 숫자 확인 및 처리
                for (int j = 0; j < i; j++) {
                    if (inputArr[j] == inputArr[i]) {
                        System.out.println("중복된 숫자입니다. 다시 입력해주세요.");
                        i--;
                        break;
                    }
                }
            }

            // 과정3: 스트라이크와 볼 계산
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
