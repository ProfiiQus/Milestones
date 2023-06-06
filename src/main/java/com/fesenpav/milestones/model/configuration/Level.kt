package com.fesenpav.milestones.model.configuration

import com.fesenpav.milestones.model.configuration.requirement.Requirement
import org.bukkit.configuration.ConfigurationSection

/**
 * Model class representing a [Milestone] [Level] in the configuration.
 */
class Level(private val requirements: MutableList<Requirement>) {
    companion object {
        /**
         * Parses the [Level] from the provided [configuration] section.
         */
        fun parseFrom(configuration: ConfigurationSection): Level {
            val level = Level(mutableListOf())
            val requirementsSection = configuration.getConfigurationSection("requirements")
            requirementsSection?.getKeys(false)?.forEach { key ->
                val requirement = TODO()
                level.register(requirement)
            }
            return level
        }
    }

    /**
     * Adds the specified [Requirement] into the [Milestone]'s [requirements] collection.
     */
    fun register(requirement: Requirement) {
        requirements.add(requirement)
    }
}