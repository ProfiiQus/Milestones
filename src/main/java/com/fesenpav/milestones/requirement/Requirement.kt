package com.fesenpav.milestones.requirement

import com.fesenpav.milestones.exception.MilestonesException

class Requirement(private val type: ProgressionType) {

    companion object {
        fun parse(requirementString: String) {
            val args = requirementString.split(":")
            if(args.size != 3) {
                throw MilestonesException("Error when parsing requirement string '$requirementString'. The string does not contain 3 arguments.")
            }
        }
    }
}