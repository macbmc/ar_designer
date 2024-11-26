package com.example.ar_designer.data.models


import com.squareup.moshi.Json

data class MeshyReq(
    @Json(name = "created_at")
    val createdAt: Long?,
    @Json(name = "expires_at")
    val expiresAt: Long?,
    @Json(name = "finished_at")
    val finishedAt: Long?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "model_urls")
    val modelUrls: ModelUrls?,
    @Json(name = "progress")
    val progress: Int?,
    @Json(name = "started_at")
    val startedAt: Long?,
    @Json(name = "status")
    val status: String?,
    @Json(name = "texture_urls")
    val textureUrls: List<TextureUrl?>?,
    @Json(name = "thumbnail_url")
    val thumbnailUrl: String?
) {
    data class ModelUrls(
        @Json(name = "fbx")
        val fbx: String?,
        @Json(name = "glb")
        val glb: String?,
        @Json(name = "obj")
        val obj: String?,
        @Json(name = "usdz")
        val usdz: String?
    )

    data class TextureUrl(
        @Json(name = "base_color")
        val baseColor: String?,
        @Json(name = "metallic")
        val metallic: String?,
        @Json(name = "normal")
        val normal: String?,
        @Json(name = "roughness")
        val roughness: String?
    )
}

data class MeshyTaskID(
    @Json(name = "result")
    val resultId: String?
)

data class MeshyResp(
    @Json(name = "art_style")
    val artStyle: String?,
    @Json(name = "created_at")
    val createdAt: Long?,
    @Json(name = "expires_at")
    val expiresAt: Long?,
    @Json(name = "finished_at")
    val finishedAt: Long?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "model_url")
    val modelUrl: String?,
    @Json(name = "model_urls")
    val modelUrls: ModelUrls?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "negative_prompt")
    val negativePrompt: String?,
    @Json(name = "object_prompt")
    val objectPrompt: String?,
    @Json(name = "progress")
    val progress: Int?,
    @Json(name = "started_at")
    val startedAt: Long?,
    @Json(name = "status")
    val status: String?,
    @Json(name = "style_prompt")
    val stylePrompt: String?,
    @Json(name = "task_error")
    val taskError: String?,
    @Json(name = "texture_urls")
    val textureUrls: List<TextureUrl?>?,
    @Json(name = "thumbnail_url")
    val thumbnailUrl: String?
) {
    data class ModelUrls(
        @Json(name = "fbx")
        val fbx: String?,
        @Json(name = "glb")
        val glb: String?,
        @Json(name = "obj")
        val obj: String?,
        @Json(name = "usdz")
        val usdz: String?
    )

    data class TextureUrl(
        @Json(name = "base_color")
        val baseColor: String?
    )
}
