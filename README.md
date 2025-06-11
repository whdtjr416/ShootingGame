# 🎮 Java 2D 게임 프로젝트

[![Java](https://img.shields.io/badge/Java-17+-brightgreen.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Status](https://img.shields.io/badge/Status-개발중-yellow.svg)]()
[![Contributions](https://img.shields.io/badge/Contributions-환영합니다-green.svg)]()

Java를 활용하여 개발된 경량 2D 게임 프로젝트입니다. Swing 프레임워크를 사용하여 그래픽 렌더링 및 사용자 입력 처리를 구현하였으며, 플레이어, 적, 총알 등의 엔티티와 기본적인 게임 메커니즘(이동, 충돌 감지 등)을 포함하고 있습니다. 코드베이스는 엔티티, 입력 처리, 게임 로직을 위한 모듈화된 패키지로 구성되어 있어 유지보수와 확장이 용이합니다.

---

## 📋 목차
- [프로젝트 개요](#프로젝트-개요)
- [주요 기능](#주요-기능)
- [프로젝트 구조](#프로젝트-구조)
- [핵심 구성 요소](#핵심-구성-요소)
- [시작하기](#시작하기)
- [실행 방법](#실행-방법)
- [기여 방법](#기여-방법)
- [라이선스](#라이선스)

---

## 🌟 프로젝트 개요
이 프로젝트는 Java 언어와 `javax.swing` 라이브러리를 기반으로 제작된 2D 게임 애플리케이션입니다. 게임은 키보드 입력을 통해 플레이어 캐릭터를 조작하고, 마우스 입력으로 상호작용(예: 공격 또는 타겟팅)을 수행할 수 있는 구조를 갖추고 있습니다. 주요 메커니즘으로는 엔티티 렌더링, 사용자 입력 처리, 게임 상태 업데이트를 위한 루프가 포함되어 있습니다. 또한, 이미지 로딩 및 게임 상수 설정을 위한 유틸리티 클래스를 통해 코드의 재사용성과 가독성을 높였습니다.

이 프로젝트는 초보 개발자 및 Java 기반 게임 개발에 관심 있는 분들에게 학습 자료로 활용될 수 있으며, 객체지향 프로그래밍(OOP) 원칙과 게임 개발의 기초를 이해하는 데 유용합니다.

---

## ✨ 주요 기능
- **플레이어 조작**: 키보드 입력(예: 화살표 키 또는 WASD)을 통해 플레이어 엔티티를 이동.
- **마우스 상호작용**: 마우스 이벤트를 통해 공격 또는 타겟 지정과 같은 동작 처리.
- **엔티티 시스템**: `Entity` 기반 클래스를 통해 `Player`, `Enemy`, `Bullet` 등의 개별 엔티티 관리.
- **게임 루프**: `Game` 클래스에서 지속적인 상태 업데이트 및 렌더링을 위한 루프 구현.
- **충돌 감지**: 엔티티 간의 기본 경계 상자(Bounding Box) 충돌 검출 로직 포함.
- **그래픽 렌더링**: Java `Graphics` API를 활용하여 플레이어, 적, 총알 등을 도형과 색상으로 시각화.
- **이미지 로드**: `LoadSave` 클래스를 통해 스프라이트 이미지 파일을 로드하여 리소스 관리.
- **게임 설정**: `Constants` 클래스를 통해 게임 창 크기, FPS, 엔티티 속도 등 주요 상수 정의.

---

## 📁 프로젝트 구조
코드베이스는 모듈화와 유지보수를 고려하여 다음과 같은 패키지 구조로 설계되었습니다:

```
src/
├── game/
│   ├── entities/           # 게임 객체를 위한 클래스
│   │   ├── Entity.java     # 모든 게임 엔티티의 기반 추상 클래스
│   │   ├── Player.java     # 플레이어 엔티티 (이동 및 렌더링 로직 포함)
│   │   ├── Enemy.java      # 적 엔티티 (기본 행동 정의)
│   │   └── Bullet.java     # 총알 엔티티 (발사체 메커니즘)
│   ├── inputs/             # 사용자 입력 처리를 위한 클래스
│   │   ├── KeyboardInputs.java  # 키보드 이벤트 처리 (플레이어 이동)
│   │   └── MouseInputs.java     # 마우스 이벤트 처리 (상호작용)
│   ├── utils/              # 유틸리티 클래스 (리소스 관리 및 상수)
│   │   ├── LoadSave.java   # 스프라이트 이미지 로드 및 관리
│   │   └── Constants.java  # 게임 설정 상수 정의 (창 크기, 속도 등)
│   └── main/               # 핵심 게임 로직 및 창 설정
│       ├── Main.java       # 애플리케이션 진입점
│       ├── Game.java       # 게임 루프 및 핵심 로직 구현
│       ├── GamePanel.java  # 게임 그래픽 렌더링을 위한 JPanel
│       └── GameWindow.java # 게임 창 설정을 위한 JFrame
```

---

## 🔑 핵심 구성 요소
### 엔티티 (`game.entities`)
- **`Entity.java`**: 모든 게임 객체의 공통 속성(위치 `x`, `y`)과 메서드(`tick`으로 업데이트, `render`로 렌더링)를 제공하는 추상 기반 클래스.
- **`Player.java`**: 플레이어를 표현하며 속도, 크기, 체력 등의 속성을 포함. 다각형 또는 사각형 형태로 렌더링되며 고유 색상을 가짐.
- **`Enemy.java`**: 적의 행동을 정의하며 `Constants` 클래스의 속성을 활용해 속도 등을 설정.
- **`Bullet.java`**: 발사체를 구현하며 위치와 작은 도형으로 렌더링.

### 입력 처리 (`game.inputs`)
- **`KeyboardInputs.java`**: `KeyListener`를 구현하여 키보드 이벤트를 처리, 플레이어 이동 제어.
- **`MouseInputs.java`**: `MouseListener`를 구현하여 마우스 클릭 및 기타 상호작용 관리.

### 유틸리티 (`game.utils`)
- **`LoadSave.java`**: `/images/` 디렉토리에서 스프라이트 이미지를 로드하여 게임 내 리소스로 활용. `BufferedImage`를 반환하며 예외 처리를 포함.
- **`Constants.java`**: 게임 창 크기(800x600), FPS(120), UPS(200), 플레이어 속도(5.0f), 총알 속도(10.0f), 적 속도(2.0f) 등 주요 상수를 정의.

### 메인 게임 로직 (`game.main`)
- **`Main.java`**: 애플리케이션의 진입점으로 게임 창을 초기화하고 실행.
- **`Game.java`**: `Runnable` 인터페이스를 구현하여 게임 루프를 관리, 게임 상태 업데이트 및 렌더링 주기 제어.
- **`GamePanel.java`**: `JPanel`을 확장하여 모든 엔티티(플레이어, 적 등)의 렌더링 처리 및 입력 리스너 관리.
- **`GameWindow.java`**: `JFrame`을 설정하여 게임 화면을 표시, 고정 크기와 제목 지정.

---

## 🚀 시작하기
이 프로젝트를 실행하거나 기여하려면 아래의 필수 항목을 준비하세요:
- **Java Development Kit (JDK)**: 버전 17 이상.
- **IDE**: IntelliJ IDEA, Eclipse, NetBeans 등 Java 지원 IDE.
- **빌드 도구**: (선택 사항) Maven 또는 Gradle을 활용한 의존성 관리.

### 📥 저장소 클론
```bash
git clone https://github.com/yourusername/java-2d-game.git
cd java-2d-game
```

---

## 🖥️ 실행 방법
1. **코드 컴파일**: IDE에서 프로젝트를 빌드하거나 명령줄을 사용:
   ```bash
   javac -d bin src/game/main/*.java src/game/entities/*.java src/game/inputs/*.java src/game/utils/*.java
   ```
2. **게임 실행**: `Main` 클래스를 실행:
   ```bash
   java -cp bin game.main.Main
   ```
3. **게임 조작**:
   - 키보드 키(코드상 WASD 또는 화살표 키로 추정)를 사용하여 플레이어 이동.
   - 마우스 클릭으로 상호작용(공격 등, `MouseInputs.java` 기반).

> **참고**: 이미지 리소스가 필요한 경우, `/images/` 디렉토리에 적절한 스프라이트 파일이 준비되어 있어야 합니다. 파일이 없으면 `LoadSave.java`에서 예외가 발생할 수 있습니다.

---

## 🤝 기여 방법
기여를 환영합니다! 아래 절차를 따라 주세요:
1. 저장소를 포크(Fork)합니다.
2. 새로운 브랜치를 생성합니다(`git checkout -b feature/your-feature`).
3. 변경 사항을 적용하고 커밋합니다(`git commit -m '기능 추가: your-feature'`).
4. 브랜치에 푸시합니다(`git push origin feature/your-feature`).
5. 변경 내용을 설명하는 Pull Request를 생성합니다.

코드 작성 시 Java 표준 코딩 규칙을 준수하고, 주요 로직에는 주석을 추가하여 가독성을 높여 주세요.

### 기여 가이드라인
- 새로운 기능을 추가하거나 버그를 수정할 경우, 관련 클래스를 명확히 문서화.
- 성능 최적화 또는 리팩토링 제안 시, 기존 코드와의 호환성을 유지.
- 테스트 코드 추가 시, 별도의 `test/` 디렉토리에 작성 권장.

---

## 📜 라이선스
이 프로젝트는 MIT 라이선스에 따라 배포됩니다. 자세한 내용은 [LICENSE](LICENSE) 파일을 확인하세요.

---

> **Java를 통한 게임 개발의 열정을 함께 나누세요. 즐거운 코딩 되시길!**  
> 문의 사항이 있으시면 이슈(Issue)를 통해 연락 부탁드립니다.
