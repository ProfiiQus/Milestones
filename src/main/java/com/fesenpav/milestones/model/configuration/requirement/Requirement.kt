package com.fesenpav.milestones.model.configuration.requirement

/**
 * Abstract class for creation of [RequirementType]'s.
 * Represents a simple player action with a specified identifier.
 * Examples: [MINE, CRAFT, PLACE]
 */
abstract class RequirementType(val identifier: String) {
}