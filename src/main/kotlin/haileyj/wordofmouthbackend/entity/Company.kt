package haileyj.wordofmouthbackend.entity

import haileyj.wordofmouthbackend.constants.Category
import haileyj.wordofmouthbackend.constants.Qualification
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "company")
data class Company(
        var name: String,
        var category: Category,
        var imageUrl: String,
        var companyUrl: String?,
        var address: String?,
        var city: String?,
        var state: String?,
        var zipcode: String?,
        var qualifications: List<Qualification>
) {
    @Id
    var id: String = ""

    @Transient
    var rating: Float? = null

    @Transient
    var reviews: List<Review> = ArrayList()
}