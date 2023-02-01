package com.debanshu.animax.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Anime(
    @SerialName("aired")
    val aired: Aired = Aired(),
    @SerialName("airing")
    val airing: Boolean = false, // false
    @SerialName("approved")
    val approved: Boolean = false, // true
    @SerialName("background")
    val background: String? = "", // The anime adapts the final manga arc, Sennen Kessen-hen (Thousand-Year Blood War Arc), which spans from the 55th to the 74th volumes.
    @SerialName("broadcast")
    val broadcast: Broadcast = Broadcast(),
    @SerialName("demographics")
    val demographics: List<Demographic> = listOf(),
    @SerialName("duration")
    val duration: String = "", // 24 min per ep
    @SerialName("episodes")
    val episodes: Int = 0, // 13
    @SerialName("explicit_genres")
    val explicitGenres: List<String> = listOf(),
    @SerialName("favorites")
    val favorites: Int = 0, // 15235
    @SerialName("genres")
    val genres: List<Genre> = listOf(),
    @SerialName("images")
    val images: Images = Images(),
    @SerialName("licensors")
    val licensors: List<Licensor> = listOf(),
    @SerialName("mal_id")
    val malId: Int = 0, // 41467
    @SerialName("members")
    val members: Int = 0, // 379070
    @SerialName("popularity")
    val popularity: Int = 0, // 534
    @SerialName("producers")
    val producers: List<Producer> = listOf(),
    @SerialName("rank")
    val rank: Int = 0, // 1
    @SerialName("rating")
    val rating: String = "", // R - 17+ (violence & profanity)
    @SerialName("score")
    val score: Double = 0.0, // 9.11
    @SerialName("scored_by")
    val scoredBy: Int = 0, // 162333
    @SerialName("season")
    val season: String? = "", // fall
    @SerialName("source")
    val source: String = "", // Manga
    @SerialName("status")
    val status: String = "", // Finished Airing
    @SerialName("studios")
    val studios: List<Studio> = listOf(),
    @SerialName("synopsis")
    val synopsis: String = "", // Substitute Soul Reaper Ichigo Kurosaki spends his days fighting against Hollows, dangerous evil spirits that threaten Karakura Town. Ichigo carries out his quest with his closest allies: Orihime Inoue, his childhood friend with a talent for healing; Yasutora Sado, his high school classmate with superhuman strength; and Uryuu Ishida, Ichigo's Quincy rival.Ichigo's vigilante routine is disrupted by the sudden appearance of Asguiaro Ebern, a dangerous Arrancar who heralds the return of Yhwach, an ancient Quincy king. Yhwach seeks to reignite the historic blood feud between Soul Reaper and Quincy, and he sets his sights on erasing both the human world and the Soul Society for good.Yhwach launches a two-pronged invasion into both the Soul Society and Hueco Mundo, the home of Hollows and Arrancar. In retaliation, Ichigo and his friends must fight alongside old allies and enemies alike to end Yhwach's campaign of carnage before the world itself comes to an end.[Written by MAL Rewrite]
    @SerialName("themes")
    val themes: List<Theme> = listOf(),
    @SerialName("title")
    val title: String = "", // Bleach: Sennen Kessen-hen
    @SerialName("title_english")
    val titleEnglish: String? = "", // Bleach: Thousand-Year Blood War
    @SerialName("title_japanese")
    val titleJapanese: String = "", // BLEACH 千年血戦篇
    @SerialName("title_synonyms")
    val titleSynonyms: List<String> = listOf(),
    @SerialName("titles")
    val titles: List<Title> = listOf(),
    @SerialName("trailer")
    val trailer: Trailer = Trailer(),
    @SerialName("type")
    val type: String = "", // TV
    @SerialName("url")
    val url: String = "", // https://myanimelist.net/anime/41467/Bleach__Sennen_Kessen-hen
    @SerialName("year")
    val year: Int? = 0 // 2022
)