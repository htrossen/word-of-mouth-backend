package haileyj.wordofmouthbackend.resolvers

import haileyj.wordofmouthbackend.entity.Review
import haileyj.wordofmouthbackend.repository.ReviewRepository
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component
import java.util.*

@Component
class ReviewMutationResolver(private val reviewRepository: ReviewRepository): GraphQLMutationResolver {
    fun newReview(
            snackId: String,
            rating: Int,
            wouldRecommend: Boolean?,
            description: String?
    ): Review {
        val review = Review(snackId, rating, wouldRecommend, description)
        review.id = UUID.randomUUID().toString()
        reviewRepository.save(review)
        return review
    }

    fun helpful(id: String, selected: Boolean): Review {
        val review = reviewRepository.findById(id)
        review.ifPresent {
            if (selected) {
                it.helpful = it.helpful + 1
            } else {
                it.helpful = it.helpful - 1
            }
        }
        return review.get()
    }

    fun notHelpful(id: String, selected: Boolean): Review {
        val review = reviewRepository.findById(id)
        review.ifPresent {
            if (selected) {
                it.notHelpful = it.notHelpful + 1
            } else {
                it.notHelpful = it.notHelpful - 1
            }
        }
        return review.get()
    }

    fun reported(id: String, selected: Boolean): Review {
        val review = reviewRepository.findById(id)
        review.ifPresent {
            if (selected) {
                it.reported = it.reported + 1
            } else {
                it.reported = it.reported - 1
            }
        }
        return review.get()
    }
}