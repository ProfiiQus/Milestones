package com.fesenpav.milestones.listener

import com.fesenpav.milestones.MilestonesPlugin
import com.fesenpav.milestones.model.BlockMineProgression
import com.fesenpav.milestones.manager.ProgressionManager
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

/**
 * Block mine listener class.
 */
class PlayerBlockMineListener(private val plugin: MilestonesPlugin, private val progressionManager: ProgressionManager) : Listener {

    /**
     * When a block is mined, asynchronously passes the progression update to [ProgressionManager].
     */
    @EventHandler
    fun onPlayerBlockMine(event: BlockBreakEvent) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, Runnable {
            val player = event.player
            progressionManager.progress(player, BlockMineProgression(event.block.type, 1))
        })
    }
}