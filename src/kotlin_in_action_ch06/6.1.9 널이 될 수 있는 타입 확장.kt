package kotlin_in_action_ch06

/*

        null이 될 수 있는 객체의 경우
        수신 객체의 메서드를 사용할 수 없음

        하지만, 확장 함수에서의 이야기면 달라지는데
        예를들어, String의 isNullOrBlank() 함수 같은 경우
        확장함수로 정의가 다음과 같이 되어있다.

        fun String?.isNullOrBlank(): Boolean =
            this == null || this.isBlank()

        즉, String? 을 통해 그 수신 객체가 null인지를 먼저 판단하는 과정을 거칠 수 있다.
        null이면 객체가 null임을 인식하고
        null이 아니면 isBlank() 함수를 실행하는 식이다.

 */