<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>회원가입 - 대철이제철 게시판</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
    </head>

    <body>
        <div class="container">
            <h2>회원가입</h2>

            <form action="<%= request.getContextPath() %>/MemberServlet?command=join" method="post"
                onsubmit="return validateJoinForm()">
                <div class="form-group">
                    <label>아이디:</label>
                    <input type="text" name="id" id="id" required>
                    <button type="button" onclick="checkIdDuplicate()">중복확인</button>
                    <span id="id_check_status" style="margin-left: 10px; font-size: 0.9rem;"></span>
                </div>

                <div class="form-group">
                    <label>비밀번호:</label>
                    <input type="password" name="password" id="password" required>
                </div>

                <div class="form-group">
                    <label>비밀번호 확인:</label>
                    <input type="password" name="password_confirm" id="password_confirm" required>
                    <span id="password_match" style="display:none; color: var(--success-color); margin-left: 10px;">✓
                        비밀번호가 일치합니다</span>
                    <span id="password_mismatch" style="display:none; color: var(--danger-color); margin-left: 10px;">✗
                        비밀번호가 일치하지 않습니다</span>
                </div>

                <div class="form-group">
                    <label>이름:</label>
                    <input type="text" name="name" required>
                </div>

                <div class="form-group">
                    <label>이메일:</label>
                    <input type="email" name="email">
                </div>

                <div class="form-group">
                    <label>전화번호:</label>
                    <input type="text" name="phone">
                </div>

                <div class="form-group">
                    <label>회원 유형:</label>
                    <input type="radio" name="role" value="MEMBER" id="role_member" checked
                        onchange="toggleAdminPassword()"> 일반회원
                    <input type="radio" name="role" value="ADMIN" id="role_admin" onchange="toggleAdminPassword()"> 관리자
                </div>

                <div class="form-group" id="admin_password_group" style="display:none;">
                    <label>관리자 비밀번호:</label>
                    <input type="password" name="admin_password" id="admin_password"
                        placeholder="관리자 가입을 위한 비밀번호를 입력하세요">
                    <small style="color: var(--text-muted); display: block; margin-top: 5px;">관리자 가입을 위해서는 특별한 비밀번호가
                        필요합니다.</small>
                </div>

                <div class="form-group">
                    <button type="submit">가입하기</button>
                </div>
            </form>

            <div class="links">
                <a href="<%= request.getContextPath() %>/MemberServlet?command=login_form">로그인</a>
                <a href="<%= request.getContextPath() %>/index.jsp">메인으로</a>
            </div>
        </div>

        <script src="../script/common.js"></script>
        <script>
    <%
                String message = (String)request.getAttribute("message");
            if (message != null) {
    %>
                    alert("<%= message %>");
    <%
    	}
    %>
        </script>
        <script>
                // ID 중복 확인 함수 (contextPath 포함)
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
                    var contextPath = '<%= request.getContextPath() %>';
                    var url = contextPath + '/MemberServlet?command=id_check&id=' + encodeURIComponent(id);

                    // 팝업 창 옵션 설정 (팝업으로 열리도록 명확하게 설정)
                    var popupOptions = 'width=500,height=400,left=100,top=100,resizable=no,scrollbars=yes,toolbar=no,menubar=no,location=no,status=no';
                    var popup = window.open(url, 'idCheck', popupOptions);

                    // 팝업이 차단되었는지 확인
                    if (!popup || popup.closed || typeof popup.closed == 'undefined') {
                        alert('팝업이 차단되었습니다. 브라우저 설정에서 팝업을 허용해주세요.');
                        return;
                    }

                    // 팝업이 제대로 열렸는지 확인
                    try {
                        popup.focus();
                    } catch (e) {
                        console.error('팝업 포커스 오류:', e);
                    }
                }

            // 비밀번호 확인 실시간 체크
            document.getElementById('password_confirm').addEventListener('input', function () {
                var password = document.getElementById('password').value;
                var passwordConfirm = document.getElementById('password_confirm').value;
                var matchSpan = document.getElementById('password_match');
                var mismatchSpan = document.getElementById('password_mismatch');

                if (passwordConfirm.length > 0) {
                    if (password === passwordConfirm) {
                        matchSpan.style.display = 'inline';
                        mismatchSpan.style.display = 'none';
                    } else {
                        matchSpan.style.display = 'none';
                        mismatchSpan.style.display = 'inline';
                    }
                } else {
                    matchSpan.style.display = 'none';
                    mismatchSpan.style.display = 'none';
                }
            });

            // 관리자 비밀번호 필드 토글
            function toggleAdminPassword() {
                var adminRadio = document.getElementById('role_admin');
                var adminPasswordGroup = document.getElementById('admin_password_group');
                var adminPassword = document.getElementById('admin_password');

                if (adminRadio.checked) {
                    adminPasswordGroup.style.display = 'block';
                    adminPassword.required = true;
                } else {
                    adminPasswordGroup.style.display = 'none';
                    adminPassword.required = false;
                    adminPassword.value = '';
                }
            }

            // 아이디 입력 필드 변경 시 중복확인 상태 초기화
            document.getElementById('id').addEventListener('input', function () {
                var idInput = this;
                var checkBtn = document.querySelector('button[onclick*="checkIdDuplicate"]');
                var statusSpan = document.getElementById('id_check_status');

                // 읽기 전용이 아닐 때만 초기화
                if (!idInput.readOnly) {
                    // 중복확인 상태 초기화
                    idInput.removeAttribute('data-checked');
                    idInput.style.backgroundColor = '';
                    idInput.style.cursor = '';
                    if (checkBtn) {
                        checkBtn.disabled = false;
                        checkBtn.textContent = '중복확인';
                        checkBtn.style.opacity = '1';
                        checkBtn.style.cursor = 'pointer';
                    }
                    if (statusSpan) {
                        statusSpan.textContent = '';
                    }
                }
            });

            // 아이디 필드가 읽기 전용일 때 포커스 방지
            document.getElementById('id').addEventListener('focus', function () {
                if (this.readOnly) {
                    this.blur();
                    alert('아이디는 중복확인 후 변경할 수 없습니다. 다른 아이디를 사용하려면 페이지를 새로고침하세요.');
                }
            });

            // 폼 유효성 검사
            function validateJoinForm() {
                var idInput = document.getElementById('id');
                var password = document.getElementById('password').value;
                var passwordConfirm = document.getElementById('password_confirm').value;
                var role = document.querySelector('input[name="role"]:checked').value;
                var adminPassword = document.getElementById('admin_password').value;

                // 아이디 중복확인 체크
                if (!idInput.getAttribute('data-checked')) {
                    alert('아이디 중복확인을 해주세요.');
                    idInput.focus();
                    return false;
                }

                // 비밀번호 일치 확인
                if (password !== passwordConfirm) {
                    alert('비밀번호가 일치하지 않습니다.');
                    return false;
                }

                // 관리자 가입 시 관리자 비밀번호 확인
                if (role === 'ADMIN') {
                    if (!adminPassword || adminPassword.trim() === '') {
                        alert('관리자 가입을 위한 비밀번호를 입력해주세요.');
                        return false;
                    }
                    // 관리자 비밀번호는 "9876"으로 설정
                    if (adminPassword !== '9876') {
                        alert('관리자 비밀번호가 올바르지 않습니다.');
                        return false;
                    }
                }

                return true;
            }
        </script>
    </body>

    </html>