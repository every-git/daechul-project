<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이디 중복 확인</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
    <style>
        body {
            padding: 20px;
            min-height: auto;
            background-color: #F7F9FA;
        }
        .container {
            margin: 0;
            padding: 30px;
            min-height: auto;
            max-width: 500px;
        }
        h2 {
            text-align: center;
            font-size: 20px;
            margin-bottom: 20px;
            color: #222222;
        }
        .id-check-result {
            text-align: center;
            padding: 24px;
            margin: 20px 0;
            border-radius: 8px;
        }
        .id-check-result.success {
            background-color: #E8F8F0;
            border: 2px solid #03C75A;
        }
        .id-check-result.success h3 {
            color: #03C75A;
        }
        .id-check-result.error {
            background-color: #FFE8E8;
            border: 2px solid #FF4747;
        }
        .id-check-result.error h3 {
            color: #FF4747;
        }
        .id-check-result h3 {
            margin: 0 0 12px 0;
            font-size: 18px;
            font-weight: 700;
        }
        .id-check-result p {
            margin: 8px 0;
            font-size: 14px;
            color: #666666;
        }
        .id-check-result strong {
            color: #222222;
            font-weight: 700;
        }
        .button-group {
            display: flex;
            gap: 10px;
            justify-content: center;
            margin-top: 20px;
        }
        .button-group button {
            padding: 12px 24px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-weight: 600;
            font-size: 14px;
            transition: all 0.2s;
        }
        .button-group button.primary {
            background-color: #03C75A;
            color: white;
        }
        .button-group button.primary:hover {
            background-color: #02B350;
        }
        .button-group button.secondary {
            background-color: #666666;
            color: white;
        }
        .button-group button.secondary:hover {
            background-color: #444444;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>아이디 중복 확인</h2>
        
        <c:if test="${result == 1}">
            <div class="id-check-result error">
                <h3>✗ 사용 불가능한 아이디입니다</h3>
                <p>입력하신 아이디 '<strong>${id}</strong>'는 이미 사용 중입니다.</p>
                <p>다른 아이디를 선택해주세요.</p>
            </div>
        </c:if>
        
        <c:if test="${result == 0}">
            <div class="id-check-result success">
                <h3>✓ 사용 가능한 아이디입니다</h3>
                <p>입력하신 아이디 '<strong>${id}</strong>'는 사용 가능합니다.</p>
            </div>
        </c:if>
        
        <c:if test="${result == -1}">
            <div class="id-check-result error">
                <h3>오류가 발생했습니다</h3>
                <p>${message != null ? message : '아이디 확인 중 오류가 발생했습니다.'}</p>
            </div>
        </c:if>
        
        <div class="button-group">
            <c:if test="${result == 0}">
                <button type="button" class="primary" onclick="useId()">사용하기</button>
            </c:if>
            <button type="button" class="secondary" onclick="window.close()">닫기</button>
        </div>
    </div>
    
    <script>
        function useId() {
            // 부모 창의 아이디 입력 필드에 값 설정하고 중복확인 완료 표시
            try {
                // opener가 있는지 확인 (팝업 창인지 확인)
                if (typeof opener === 'undefined' || opener === null) {
                    // 새 탭으로 열린 경우 parent를 사용
                    var parentWindow = window.parent;
                    if (parentWindow && parentWindow !== window) {
                        setParentId(parentWindow);
                    } else {
                        alert('팝업 창이 아닌 새 탭으로 열렸습니다. 팝업으로 열어주세요.');
                    }
                    return;
                }
                
                if (opener && !opener.closed) {
                    setParentId(opener);
                    alert('아이디가 설정되었습니다.');
                    window.close();
                } else {
                    alert('부모 창을 찾을 수 없습니다.');
                }
            } catch (e) {
                console.error('오류 발생:', e);
                alert('아이디 설정 중 오류가 발생했습니다: ' + e.message);
            }
        }
        
        function setParentId(parentWin) {
            var idInput = parentWin.document.getElementById('id');
            var checkBtn = parentWin.document.querySelector('button[onclick*="checkIdDuplicate"]');
            var statusSpan = parentWin.document.getElementById('id_check_status');
            
            if (idInput) {
                // 아이디 값 설정
                idInput.value = '${id}';
                // 읽기 전용으로 고정
                idInput.readOnly = true;
                idInput.style.backgroundColor = 'var(--bg-accent)';
                idInput.style.cursor = 'not-allowed';
                
                // 중복확인 완료 플래그 설정
                idInput.setAttribute('data-checked', 'true');
            }
            
            // 중복확인 버튼 비활성화 및 텍스트 변경
            if (checkBtn) {
                checkBtn.disabled = true;
                checkBtn.textContent = '확인완료';
                checkBtn.style.opacity = '0.5';
                checkBtn.style.cursor = 'not-allowed';
            }
            
            // 상태 메시지 표시
            if (statusSpan) {
                statusSpan.textContent = '✓ 사용 가능한 아이디입니다';
                statusSpan.style.color = '#03C75A';
            }
        }
    </script>
</body>
</html>
