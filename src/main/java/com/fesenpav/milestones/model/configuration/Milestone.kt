package com.fesenpav.milestones.model.configuration

import org.bukkit.configuration.ConfigurationSection

/**
 * Model class representing a [Milestone] in the configuration.
 */
class Milestone(val key: String, val levels: MutableList<Level>) {
    companion object {
        /**
         * Parses the [Milestone] from the provided [configuration] section.
         * Subsequently calls upon parsing of its levels and that level's requirement's.
         */
        fun parseFrom(sectionKey: String, configuration: ConfigurationSection): Milestone {
            val milestone = Milestone(sectionKey, mutableListOf())
            val levelsSection = configuration.getConfigurationSection("levels")
            levelsSection?.getKeys(false)?.forEach { key ->
                val level = Level.parseFrom(levelsSection.getConfigurationSection(key)!!)
                milestone.register(level)
            }
            return milestone
        }
    }

    /**
     * Adds the specified [Level] into the [Milestone]'s [levels] collection.
     */
    fun register(level: Level) {
        levels.add(level)
    }

}