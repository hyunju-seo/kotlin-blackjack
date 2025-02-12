package blackjack.view

import blackjack.domain.participant.BetAmount

object InputView {
    fun getPlayerNames(): List<String> {
        println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)")
        val input = readln()
        return input
            .split(",")
            .map { it.trim() }
            .filter { it.isNotEmpty() }
    }

    fun getBetAmount(name: String): BetAmount {
        println("${name}의 베팅 금액은?")
        val input = readln()
        return BetAmount.of(input)
    }

    fun isHit(playerName: String): Boolean {
        println("${playerName}은 한장의 카드를 더 받겠습니다?(예는 y, 아니오는 n)")
        return when (readln()) {
            "y" -> true
            "n" -> false
            else -> throw IllegalArgumentException("y나 n 중에 하나만 입력하세요.")
        }
    }
}
