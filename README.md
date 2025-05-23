# 📱 스마트폰 게임 프로그래밍 텀 프로젝트  
## 🎮 게임 제목: **내 손안의 아이돌:Celestia**

---

## 🌟 게임 컨셉

**내 손안의 아이돌**은 플레이어가 최애 아이돌의 열혈 팬이 되어 다양한 팬 활동을 통해 친밀도를 높이고 굿즈를 수집하며, 덕력을 키워 전국 1등 팬이 되는 것을 목표로 하는 **캐주얼 덕질 시뮬레이션 게임**입니다.

- **핵심 메커니즘**
  - 아이돌의 스케줄 참여 (팬미팅, 음악방송, 라이브 등)
  - 미니 요리게임을 통한 돈벌기 
  - 굿즈 수집 및 덕질등급 상승 
  - 번 하트(덕력)으로 굿즈/부스터 구매 및 이벤트 참가

---

## 🕹️ 게임 방법

1. 목표는 덕질 최고등급이되는것
2. 알바(요리미니게임)을 통해 돈을 벌기
3. 굿즈를 구입하거나 스케쥴에 참여하여 하트(덕력)을 받기
4. 하트를 많이 받아서 덕질등급을 올려 잠겨있는 스케쥴이도 참여할 수 있게 한다
5. 돈이나 하트로 자기 자신을 커스터마이징 할 수 있음   

---

## 🔄 게임 흐름

1. 로비 맵에서 요리미니게임이나 스케쥴에 들어갈 수 있는 버튼이 있음
2. 일정 시간 동안 미니게임을 통해 돈을 번다
3. 레벨에 맞는 스케쥴에 참여하여 하트를 번다  
4. 하트를 모아 상점에서부스터나 특별한 아이템 구매 
5. 덕력 목표를 달성하면 다음 단계 팬 활동 잠금 해제 (콘서트등)  

---

## 🛠️ 개발 범위 및 기능

| 기능 | 개발 범위 |
|------|------------|
|플레이어 인터랙션|터치, 탭, 드래그 등 기본 입력 처리|
|UI|로비, 스케줄 선택, 굿즈 수집, 팬랭킹 등|
|컬렉션 앨범|굿즈 수집 및 진열 UI|
|사운드|아이돌 음성, 팬미팅 배경음, 효과음 등|
|애니메이션|아이돌 등장 연출, 굿즈 연출 등|

---

## 📆 개발 일정

| 개발 일정 | 개발 내용 | 진행 |
|-----------|-----------|------|
|1주차 (4/4~4/10)|기획 확정 및 리소스 수집|✅ 100%|
|2주차 (4/11~4/17)|스케줄 선택 UI 및 덕력 시스템 구현|⬜ 40%|
|3주차 (4/18~4/24)| 굿즈 수집 시스템 구현|⬜ 0%|
|4주차 (4/25~5/1)||⬜ 0%|
|5주차 (5/2~5/8)|팬랭킹 시스템 및 상점 구현|⬜ 0%|
|6주차 (5/9~5/15)|미니게임 구현|⬜ 90%|
|7주차 (5/16~5/22)|사운드 및 애니메이션 적용|⬜ 0%|
|8주차 (5/23~5/29)|버그 수정 및 테스트|⬜ 0%|
|9주차 (5/30~6/5)|최종 마무리 및 발표 준비|⬜ 0%|

---

## 📈 주차별 Git Commit 횟수 (예시)

| 개발 일정 | 커밋 횟수 |
|-----------|------------|
|1주차 (4/4~4/10)|5|
|2주차 (4/11~4/17)|3|
|3주차 (4/18~4/24)|0|
|4주차 (4/25~5/1)|4|
|5주차 (5/2~5/9)|0|
|6주차 (5/10~5/17)|0|

---

## 📂 주요 클래스 구조 (예정)

- `MainScene.java`: 팬 활동 UI 및 흐름 관리  
- `MinigameActivity.java`: 요리미니게임  
- `GoodsManager.java`: 굿즈 생성, 등록, 교환 관리  
- `FanPointManager.java`: 덕력 포인트 처리 및 랭킹 연동  

# 🍳 MainScene GameObject 구성 및 동작

요리 미니게임 `MainScene`에 등장하는 주요 클래스 및 UI 요소들의 구성, 상호작용 방식, 핵심 코드 등을 설명합니다.

---

## 1. 👤 Customer

### 🎨 그림 구성
- 고객 캐릭터는 `TextView`로 주문 정보를 표시
- `LinearLayout`로 배경 UI 구성

### ⚙️ 동작 구성
- 5초 간격으로 최대 3명까지 등장
- 무작위로 `"hamburger"`, `"fries"`, `"coke"` 중 하나 주문

### 🤝 상호작용
- `제출` 버튼 클릭 시 가장 앞 고객의 주문과 플레이어 요리 비교
- 일치 시 고객 제거 및 500원 획득

### 💻 핵심 코드
```java
if (target.order.equals(playerCookedFood)) {
    customers.remove(target);
    money += 500;
}
```

---

## 2. 🍳 CookingLogic

### 🧠 책임 역할
- 요리 제작 로직 담당 (재료 선택, 굽기, 합치기 등)

### 🔧 주요 기능
- 재료 목록 `currentItems` 추적
- `굽기` 버튼: `"rawmeat"` → `"meat"`
- `합치기` 버튼: `"bread + meat + bread"` → `"hamburger"`

### 💻 핵심 코드
```java
public boolean checkAndClearOrder(String order) {
    if (order.equals("hamburger") && currentItems.containsAll(...)) {
        currentItems.clear();
        return true;
    }
    return false;
}
```

---

## 3. 📦 btnServe (제출 버튼)

### 🤝 상호작용
- 클릭 시:
  - 가장 앞 고객의 주문 확인
  - 현재 요리와 비교
  - 일치 시 고객 제거 및 돈 획득!

### 💻 핵심 코드
```java
btnServe.setOnClickListener(v -> {
    if (!customers.isEmpty()) {
        String order = customers.get(0).order;
        boolean correct = cookingLogic.checkAndClearOrder(order);
        if (correct) {
            customers.remove(0);
            money += 500;
            tvMoney.setText("₩ " + money);
        }
        updateCustomerView();
    }
});

```

---
### 😵 구현 중 어려웠던 점
재료 순서에 상관없는 조합 검사가 처음엔 "bread+meat+bread" 처럼 문자열 비교라서 실패함 → Set.containsAll() 로 해결



![image](https://github.com/user-attachments/assets/8e0d277f-43ce-4669-8dd2-6283b39d02bb)

![image](https://github.com/user-attachments/assets/3625a98b-e1ce-4003-a4a6-7319fce10a63)
![image](https://github.com/user-attachments/assets/a1bc4c40-2816-4008-aab4-90661fdf4b99)
![image](https://github.com/user-attachments/assets/3986635f-d956-43a7-bf82-af96511dc923)

## 🔗 발표 영상 링크 (예정)
추후 추가 예정
