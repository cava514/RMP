package com.example.clicker34

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    var score by mutableStateOf(0.0)
    val upgrades = mutableStateMapOf(
        UpgradeType.AutoClick to Upgrade(
            UpgradeType.AutoClick,
            title = "Автоклик",
            baseCost = 10.0,
            costMultiplier = 1.15,
            baseValue = 0.0,
            valueMultiplier = 1.05
        ),
        UpgradeType.Multiplier to Upgrade(
            UpgradeType.Multiplier,
            title = "Множитель",
            baseCost = 10.0,
            costMultiplier = 1.15,
            baseValue = 0.0,
            valueMultiplier = 1.1
        ),
        UpgradeType.OfflineIncome to Upgrade(
            UpgradeType.OfflineIncome,
            title = "Офлайн доход",
            baseCost = 10.0,
            costMultiplier = 1.15,
            baseValue = 0.0,
            valueMultiplier = 1.1
        )
    )

    fun onClick(){
        score++
    }
    fun onUpgrade(upgrade: Upgrade){
        if (score >= upgrade.currentCost()){
            score -= upgrade.currentCost()
            upgrades[upgrade.type] = upgrade.next()
        }

    }
}