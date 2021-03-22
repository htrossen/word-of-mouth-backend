package haileyj.wordofmouthbackend.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import haileyj.wordofmouthbackend.constants.Qualification
import org.springframework.stereotype.Component

@Component
class QualificationQueryResolver : GraphQLQueryResolver {
    fun qualifications() : List<Qualification> {
        return Qualification.values().toList()
    }
}