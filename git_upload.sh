#!/bin/sh

# 1. 커밋 메시지를 입력받음
echo "✏️ 이 커밋에 대한 설명을 입력하세요:"
read commit_message

# 2. 메시지가 비어있는지 확인
if [ -z "$commit_message" ]; then
  echo "❌ 커밋 메시지가 비어있습니다. 작업을 중단합니다."
  exit 1
fi

# 3. 변경 사항 추가
echo " staged..."
git add .

# 4. (선택사항) 커밋할 내용이 있는지 확인
if git diff --quiet --cached; then
  echo "✅ 커밋할 변경 사항이 없습니다. 모든 것이 최신 상태입니다."
  exit 0
fi

# 5. 커밋 실행
echo " 커밋 중: '$commit_message'"
git commit -m "$commit_message"

# 6. 푸시 실행
echo "🚀 GitHub로 푸시합니다..."
git push

echo "✨ 완료!"