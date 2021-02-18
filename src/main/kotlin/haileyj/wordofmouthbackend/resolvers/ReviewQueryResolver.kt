package haileyj.wordofmouthbackend.resolvers

import haileyj.wordofmouthbackend.entity.Review
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class ReviewQueryResolver(val mongoOperations: MongoOperations) : GraphQLQueryResolver {
    fun reviews(companyId: String): List<Review> {
        val query = Query()
        query.addCriteria(Criteria.where("companyId").`is`(companyId))
        return mongoOperations.find(query, Review::class.java)
    }
}