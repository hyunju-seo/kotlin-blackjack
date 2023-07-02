package blackjack.domain

import blackjack.domain.card.Card

data class Player(val name: String, val state: PlayerState) {
    fun canAddCard(): Boolean = state.canAddCard()

    fun addCard(card: Card): Player {
        val newState = this.state.add(card)
        return copy(state = newState)
    }

    fun addCards(cards: List<Card>): Player {
        val newState = this.state.add(cards)
        return copy(state = newState)
    }

    fun cards() = state.cards

    fun score() = state.score

    companion object {
        fun init(name: String): Player {
            return Player(name, PlayerState.init)
        }
    }
}
