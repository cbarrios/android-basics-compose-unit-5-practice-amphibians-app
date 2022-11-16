package com.lalosapps.amphibiansapp.fake.repository

import com.lalosapps.amphibiansapp.data.network.dto.Amphibian

object FakeDataSource {

    val amphibians = listOf(
        Amphibian("Amphibian 1", "Toad", "Amphibian 1 is great.", "Url 1"),
        Amphibian("Amphibian 2", "Salamander", "Amphibian 2 is awesome.", "Url 2"),
        Amphibian("Amphibian 3", "Frog", "Amphibian 3 is amazing.", "Url 3")
    )
}