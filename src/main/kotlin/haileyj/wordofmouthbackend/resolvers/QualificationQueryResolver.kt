package haileyj.wordofmouthbackend.resolvers

import haileyj.wordofmouthbackend.constants.Qualification

class QualificationQueryResolver {
    fun qualifications() : List<Qualification> {
        return Qualification.values().toList()
    }
}