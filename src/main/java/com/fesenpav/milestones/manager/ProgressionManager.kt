package com.fesenpav.milestones.manager

import com.fesenpav.milestones.exception.MilestonesException
import com.fesenpav.milestones.model.MilestonePlayer
import com.fesenpav.milestones.model.Progression
import org.bukkit.entity.Player

class ProgressionManager {

    private val playerData: Map<Player, MilestonePlayer> = TODO()

    /**
     * Progresses the [player]'s data object.
     * If the [player] has no data object, throws [MilestonesException].
     */
    fun progress(player: Player, progression: Progression) {
        val milestonePlayer = getMilestonePlayer(player)
        milestonePlayer.progress(progression);
    }

    /**
     * Gets the [player]'s representative data object.
     * If the [player] has no data object in memory, throws [MilestonesException].
     */
    private fun getMilestonePlayer(player: Player): MilestonePlayer {
        if(!playerData.containsKey(player)) {
            throw MilestonesException("Player '${player.name}' was not found in the plugin's memory. Forward this error to the plugin's developer.")
        }
        return playerData[player]!!
    }
}