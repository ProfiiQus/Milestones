package com.fesenpav.milestones.manager

import com.fesenpav.milestones.exception.MilestonesException
import com.fesenpav.milestones.model.configuration.Milestone
import org.bukkit.configuration.file.YamlConfiguration

/**
 * Milestone configuration management class.
 */
class MilestoneManager(private val milestones: MutableMap<String, Milestone>) {
    companion object {
        /**
         * Parses the milestone from the provided [configuration] file.
         * Subsequently calls upon parsing of its milestone's levels and that level's requirement's.
         */
        fun parseFrom(configuration: YamlConfiguration): MilestoneManager {
            val manager = MilestoneManager(mutableMapOf())
            configuration.getKeys(false).forEach { key ->
                val milestone = Milestone.parseFrom(key, configuration.getConfigurationSection(key)!!)
                manager.register(milestone)
            }
            return manager
        }
    }

    /**
     * Registers a new [milestone].
     * Throws [MilestonesException] if the key already exists.
     */
    fun register(milestone: Milestone) {
        if(milestones.containsKey(milestone.key)) {
            throw MilestonesException("Milestone by the key '${milestone.key}' is already registered.")
        }
    }
}