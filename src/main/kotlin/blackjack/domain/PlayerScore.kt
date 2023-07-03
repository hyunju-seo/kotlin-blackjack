package blackjack.domain

import blackjack.domain.card.CardScore

@JvmInline
value class PlayerScore(val value: Int) {
    fun plus(score: CardScore): PlayerScore {
        val primaryScoreAdded = PlayerScore(score.primary + value)
        val secondaryScoreAdded = PlayerScore(score.secondary + value)
        return primaryScoreAdded.takeIf { it.isBust().not() } ?: secondaryScoreAdded
    }

    private fun isBust() = value > MAX_VALUE

    fun plus(scores: List<CardScore>): PlayerScore {
        return scores
            .sortedByDescending { it.isPrimaryEqualToSecondary() }
            .fold(this) { acc, score -> acc.plus(score) }
    }

    fun isBustOrMax() = value >= MAX_VALUE

    companion object {
        const val MAX_VALUE = 21
        val ZERO = PlayerScore(0)
    }
}
