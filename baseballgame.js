// 특정 길이 a만큼의 중복되지 않은 임의에 난수를 생성하는 함수
function getAnswer(size) {
    var answer = "";
    while(answer.length < size){
        number = Math.floor(Math.random() * 10);
        if(answer.indexOf(parseInt(number))>-1)
            continue;
        answer += parseInt(number);
    }
    return answer
}

// 입력값(input)을 정답(answer)과 비교해 결과를 출력하는 함수
function checkInput(input,answer){
    var ball = 0;
    var strike = 0;
    
    [...input].forEach(function(s) {
        if (answer.indexOf(s) >= 0) {           
            if (answer.indexOf(s) == input.indexOf(s))
                strike++;
            else
                ball++;
        }
    });
    result = ""
    if (ball == 0 && strike == 0)
        result = "0B0S"
    else {
        if (ball > 0)
            result += (ball + "B");
        if (strike > 0)
             result += (strike + "S");
    }
    console.log(result);
}

// 숫자 야구 게임의 과정을 진행하는 함수
function playball(){
    var answer = "280";
    var input = ""
    var cnt = 0;
    while (answer != input) {
        input = prompt(++cnt + "번째 시도 : ");    
        console.log(input);
        checkInput(input, answer);
    }
    console.log(cnt + "번만에 맞히셨습니다.");
    console.log("게임을 종료합니다.");
}


// 게임을 시작하는 함수
playball()