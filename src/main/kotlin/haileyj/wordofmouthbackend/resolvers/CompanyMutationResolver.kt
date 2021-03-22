package haileyj.wordofmouthbackend.resolvers

import haileyj.wordofmouthbackend.entity.Company
import haileyj.wordofmouthbackend.repository.CompanyRepository
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import haileyj.wordofmouthbackend.constants.Category
import haileyj.wordofmouthbackend.constants.Qualification
import org.springframework.stereotype.Component
import java.util.*

@Component
class CompanyMutationResolver(private val companyRepository: CompanyRepository): GraphQLMutationResolver {
    fun newCompany(
            name: String,
            category: String,
            imageUrl: String,
            companyUrl: String?,
            address: String?,
            city: String?,
            state: String?,
            zipcode: String?,
            qualifications: List<String>?
    ): Company {

        val qualificationsList: MutableList<Qualification> = mutableListOf()

        qualifications?.forEach {
            qualificationsList.add(Qualification.valueOf(it))
        }

        val company = Company(
                name,
                Category.valueOf(category),
                imageUrl,
                companyUrl,
                address,
                city,
                state,
                zipcode,
                qualificationsList
        )
        company.id = UUID.randomUUID().toString()
        companyRepository.save(company)
        return company
    }

    fun deleteCompany(id: String): Boolean {
        companyRepository.deleteById(id)
        return true
    }
}