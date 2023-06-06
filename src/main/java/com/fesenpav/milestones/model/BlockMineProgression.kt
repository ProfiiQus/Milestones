package com.fesenpav.milestones.model

import org.bukkit.Material

/**
 * Progression when a player mines a block.
 * Holds information about the [material] the player has mined and the [amount] of it.
 */
class BlockMineProgression(private val material: Material, amount: Int) : Progression(amount) {
}