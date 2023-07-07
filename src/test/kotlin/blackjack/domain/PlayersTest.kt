package blackjack.domain

import blackjack.domain.participant.Players
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec

class PlayersTest : StringSpec({
    "플레이어의 이름이 중복되면 예외를 던진다." {
        shouldThrowAny { Players.of(listOf("p1", "p1")) }
    }
})
