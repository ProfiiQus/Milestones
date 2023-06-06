package com.fesenpav.milestones.model

/**
 * Class representing a progress-able milestone and it's sub-parts.
 */
class Milestone(private val identifier: String) {

    private val levels: Map<Int, Level> = TODO()

    class Level(private val id: Int) {

        private val requirements: Map<String, Requirement> = TODO()

        class Requirement {

        }
    }
}