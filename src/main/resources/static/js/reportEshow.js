// URL에서 쿼리 파라미터로 전달된 ID를 가져오는 함수
function getPostId() {
    const params = new URLSearchParams(window.location.search);
    return params.get('id');
}

// 게시물 정보 설정 함수
function setPostContent(post) {
    document.getElementById('post-title').textContent = post.title;
    document.getElementById('post-author').textContent = post.author;
    document.getElementById('post-date').textContent = post.date;
    document.getElementById('like-count').textContent = post.likes;
    document.getElementById('post-content').innerHTML = post.content;
    document.getElementById('post-image').src = post.image;
}

// 예시 데이터 (실제 데이터베이스나 서버에서 가져와야 함)
const posts = {
    '001': {
        title: '2024 공원 유원지 현황',
        author: '혜진이',
        date: '2024-07-24',
        likes: 180,
        liked: false, // 좋아요 상태를 추가 (false로 초기화)
        content: `<p>안녕하세요.</p><p>환경민원포털 시스템에서 안내해드립니다.</p><p>환경민원포털의 안정적인 운영을 위한 서버 점검이 예정되어있습니다.</p><p>감사합니다.</p>`,
        image: './img/trash.jpeg'
    },
    '002': {
        title: '2024년 2분기 먹는 물 공통 시설',
        author: '홍길동',
        date: '2024-07-10',
        likes: 171,
        liked: false, // 좋아요 상태를 추가 (false로 초기화)
        content: `<p>2024년 2분기 먹는 물 공통 시설에 대한 상세 내용입니다.</p>`,
        image: './img/water.jpg'
    }
};

// 현재 게시물 ID와 데이터를 전역 변수
let currentPostId = '';
let currentPostData = {};

// 페이지 로드 후 게시물 ID에 따라 내용을 표시하는 함수
window.onload = function() {
    const postId = getPostId();
    currentPostId = postId;
    if (posts[postId]) {
        currentPostData = posts[postId];
        setPostContent(posts[postId]);
    }
};

var btn = document.getElementById("like");
btn.addEventListener('click', function() {
    if (!currentPostData.liked) {
        // 좋아요를 누르지 않은 상태일 때
        currentPostData.likes++; // 좋아요 수 증가
        currentPostData.liked = true; // 좋아요 상태로 변경
        btn.classList.add('active'); // 버튼을 활성화 상태로 변경
    } else {
        // 좋아요를 누른 상태일 때
        currentPostData.likes--; // 좋아요 수 감소
        currentPostData.liked = false; // 좋아요 상태 해제
        btn.classList.remove('active'); // 버튼 비활성화 상태로 변경
    }
    // 업데이트된 좋아요 숫자를 화면에 반영
    document.getElementById('like-count').textContent = currentPostData.likes;
});
