package com.jefpoughon.mphase.model

import java.io.Serializable


/**
 * an article as it is defined in the API
 */
data class Article(
    val id: String,
    val title: String, //localized article title
    val tags: Array<Tag>,
    val thumbnail: Thumbnail,
    val publishedAt: String //ISO8601
) : Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Article

        if (id != other.id) return false
        if (title != other.title) return false
        if (!tags.contentEquals(other.tags)) return false
        if (thumbnail != other.thumbnail) return false
        if (publishedAt != other.publishedAt) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + tags.contentHashCode()
        result = 31 * result + thumbnail.hashCode()
        result = 31 * result + publishedAt.hashCode()
        return result
    }
}

/**
 * tag used in article
 */
data class Tag(
    val name: String, //localized tag name
    val slug: String
) : Serializable

/**
 * Thumbnail used in article
 * url is just a part, without base url
 * use ThumbnailExt to get complete url
 */
data class Thumbnail(
    val url: String //relative to the API base URL
) : Serializable
