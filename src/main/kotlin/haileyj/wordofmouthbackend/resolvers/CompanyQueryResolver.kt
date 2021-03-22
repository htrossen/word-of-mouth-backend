package haileyj.wordofmouthbackend.resolvers

import haileyj.wordofmouthbackend.entity.Review
import haileyj.wordofmouthbackend.entity.Company
import haileyj.wordofmouthbackend.repository.CompanyRepository
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class CompanyQueryResolver(val companyRepository: CompanyRepository, private val mongoOperations: MongoOperations) : GraphQLQueryResolver {
    fun companies(): List<Company> {
        val list = companyRepository.findAll()
        for (item in list) {
            val reviews = getReviews(companyId = item.id)
            item.rating = if (reviews.isNotEmpty()) reviews.sumOf { it.rating }.toFloat().div(reviews.size) else null
            item.reviews = getReviews(companyId = item.id)
        }
        return list
    }

    private fun getReviews(companyId: String): List<Review> {
        val query = Query()
        query.addCriteria(Criteria.where("companyId").`is`(companyId))
        return mongoOperations.find(query, Review::class.java)
    }
}
