package haileyj.wordofmouthbackend.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import haileyj.wordofmouthbackend.constants.Category
import org.springframework.stereotype.Component

@Component
class CategoryQueryResolver : GraphQLQueryResolver {
    fun categories() : List<Category> {
        return Category.values().toList()
    }
}