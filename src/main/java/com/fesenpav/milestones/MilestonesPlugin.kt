package com.fesenpav.milestones

import com.fesenpav.milestones.manager.MilestoneManager
import com.github.sirblobman.api.configuration.ConfigurationManager
import com.github.sirblobman.api.plugin.ConfigurablePlugin

class MilestonesPlugin : ConfigurablePlugin() {

    private lateinit var configurationManager: ConfigurationManager
    private lateinit var milestoneManager: MilestoneManager

    /**
     * Initializes configuration objects.
     */
    override fun onLoad() {
        configurationManager = getConfigurationManager()
        configurationManager.saveDefault("milestones.yml")
        milestoneManager = MilestoneManager.parseFrom(configurationManager.get("milestones.yml"))
    }

    override fun onEnable() {
        TODO("Not yet implemented")
    }

    override fun onDisable() {
        TODO("Not yet implemented")
    }

}
