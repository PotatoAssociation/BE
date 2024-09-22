window.onload = function() 
{
    // 테스트용 로그인 상태 설정
    sessionStorage.setItem("isLoggedIn", "true");  // 또는 "false"로 변경해서 로그아웃 상태 테스트
    sessionStorage.setItem("nickname", "환경지킴이");
    sessionStorage.setItem("email", "nature@naver.com");

    // 세션 스토리지에서 로그인 여부 확인
    const isLoggedIn = sessionStorage.getItem("isLoggedIn");
    const nickname = sessionStorage.getItem("nickname");
    const email = sessionStorage.getItem("email");

    // 로그인이 안 되어 있으면 로그인 페이지로 
    if (isLoggedIn !== "true") {
        window.location.href = "login";
    } else {
        // 로그인이 되어 있으면 마이페이지
        document.getElementById("profile-nickname").textContent = nickname;
        document.getElementById("profile-email").textContent = email;
    }
};

function logout() {
    // 로그아웃 시 세션 스토리지 초기화
    sessionStorage.clear();
    window.location.href = "login";
}
