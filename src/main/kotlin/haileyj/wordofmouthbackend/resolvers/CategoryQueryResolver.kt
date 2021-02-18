package haileyj.wordofmouthbackend.resolvers

import haileyj.wordofmouthbackend.constants.Category

class CategoryQueryResolver {
    fun categories() : List<Category> {
        return Category.values().toList()
    }
}