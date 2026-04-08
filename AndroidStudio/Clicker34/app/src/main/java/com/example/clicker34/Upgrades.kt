package com.example.clicker34

import kotlin.math.pow

sealed class UpgradeType{
    object AutoClick : UpgradeType()
    object Multiplier : UpgradeType()
    object OfflineIncome : UpgradeType()
}

data class Upgrade(
    val type: UpgradeType,
    val title: String,
    val level: Int = 0,
    val baseCost: Double,
    val costMultiplier: Double,
    val baseValue: Double,
    val valueMultiplier: Double
){
    fun currentCost(): Double{
        return baseCost * costMultiplier.pow(level.toDouble())
    }

    fun currentValue(): Double{
        return baseValue + baseValue * valueMultiplier.pow(level.toDouble())
    }

    fun next(): Upgrade{
        return copy(level = level+1)
    }
}