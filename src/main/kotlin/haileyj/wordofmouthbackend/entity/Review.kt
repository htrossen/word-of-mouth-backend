package haileyj.wordofmouthbackend.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "reviews")
data class Review(
        var companyId: String,
        var rating: Int,
        var wouldRecommend: Boolean?,
        var description: String?,
        var helpful: Int = 0,
        var notHelpful: Int = 0,
        var reported: Int = 0

) {
    @Id
    var id: String = ""
}