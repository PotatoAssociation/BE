function openPopup(points, itemName) {
    const totalPoints = 3500; // 보유 포인트 (예시)
    const remainingPoints = totalPoints - points; // 교환 후 잔여 포인트 계산

    // 팝업에 상품 정보와 포인트 정보 설정
    document.getElementById('popup-item').innerText = `상품: ${itemName}`;
    document.getElementById('popup-points').innerText = `총 결제 포인트: ${points}P`;
    document.getElementById('remaining-points').innerText = `보유 포인트: ${totalPoints}P`;
    document.getElementById('remaining-after').innerText = `교환 후 잔여 포인트: ${remainingPoints}P`;

    // 팝업 표시
    document.getElementById('popup').style.display = 'block';
}

function closePopup() {
    document.getElementById('popup').style.display = 'none';
}

function confirmExchange() {
    alert('교환이 완료되었습니다.');
    closePopup();
}
