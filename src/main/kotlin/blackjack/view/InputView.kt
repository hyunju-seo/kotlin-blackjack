package blackjack.view

object InputView {
    fun getPlayerNames(): List<String>{
        println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)")
        val input= readln()
        return input
            .split(",")
            .map { it.trim() }
            .filter { it.isNotEmpty() }
    }

    fun askForAdditionalCard(playerName: String): Boolean{
        println("${playerName}은 한장의 카드를 더 받겠습니다?(예는 y, 아니오는 n)")
        val input = readln()
        return when(input){
            "y"-> true
            "n"-> false
            else -> throw IllegalArgumentException("y나 n중에 하나만 입력하세요.")
        }
    }
}
