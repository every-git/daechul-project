/**
 * 공통 자바스크립트 함수
 */

// ID 중복 확인 함수
function checkIdDuplicate() {
    var idInput = document.getElementById('id');
    var id = idInput.value.trim();
    
    if (!id) {
        alert('아이디를 입력해주세요.');
        idInput.focus();
        return;
    }
    
    // 아이디 유효성 검사 (영문, 숫자, 4-20자)
    var idPattern = /^[a-zA-Z0-9]{4,20}$/;
    if (!idPattern.test(id)) {
        alert('아이디는 영문과 숫자만 사용 가능하며, 4-20자 사이여야 합니다.');
        idInput.focus();
        return;
    }
    
    // 팝업 창으로 아이디 중복 확인 페이지 호출
    // contextPath를 동적으로 가져오기 위해 현재 페이지의 경로를 사용
    var contextPath = window.location.pathname.split('/')[1] || '';
    var url = '/' + contextPath + '/MemberServlet?command=id_check&id=' + encodeURIComponent(id);
    window.open(url, 'idCheck', 'width=500,height=350,left=100,top=100,resizable=no,scrollbars=yes');
}

// 폼 유효성 검사
function validateForm() {
    // TODO: 필요한 유효성 검사 로직 추가
    return true;
}
