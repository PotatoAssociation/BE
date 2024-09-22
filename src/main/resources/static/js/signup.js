document.addEventListener('DOMContentLoaded', function () {
    const signupForm = document.getElementById('signupForm');

    signupForm.addEventListener('submit', function (event) {
        event.preventDefault(); // 폼 제출 방지

        const username = document.getElementById('username').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;

        fetch('/join', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                'username': username,
                'email': email,
                'password': password,
            }),
        })
        .then(response => response.text()) // 서버로부터 받은 응답을 텍스트로 처리
        .then(result => {
            alert(result); // 회원가입 성공 또는 실패 메시지를 alert로 표시
             if(result === "회원가입성공") {
                 window.location.href = "/login"; // 회원가입 성공 시 로그인 페이지로 이동
             }
        })
        .catch(error => {
            console.error('회원가입 오류:', error);
             alert('회원가입 중 오류가 발생했습니다.'); // 네트워크 오류 처리
         });
    });
});
