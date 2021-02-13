package haileyj.wordofmouth.resolvers

import haileyj.wordofmouth.entity.Review
import haileyj.wordofmouth.repository.ReviewRepository
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class ReviewMutationResolver(private val reviewRepository: ReviewRepository): GraphQLMutationResolver {
    fun newReview(snackId: String, rating: Int, text: String): Review {
        val review = Review(snackId, rating, text)
        reviewRepository.save(review)
        return review
    }
}