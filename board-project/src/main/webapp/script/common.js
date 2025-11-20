/**
 * 공통 자바스크립트 함수
 */

// ID 중복 확인 함수
function checkIdDuplicate() {
    var id = document.getElementById('id').value;
    
    if (!id) {
        alert('아이디를 입력해주세요.');
        return;
    }
    
    // TODO: 실제 ID 중복 체크 로직 구현
    // 팝업 창으로 idCheck.jsp 호출
    var url = 'idCheck.jsp?id=' + id;
    window.open(url, 'idCheck', 'width=400,height=300');
}

// 폼 유효성 검사
function validateForm() {
    // TODO: 필요한 유효성 검사 로직 추가
    return true;
}
