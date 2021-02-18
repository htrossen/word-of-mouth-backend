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
            category: Category,
            imageUrl: String,
            companyUrl: String?,
            address: String?,
            city: String?,
            state: String?,
            zipcode: String?,
            qualifications: List<Qualification>?
    ): Company {
        val company = Company(
                name,
                category,
                imageUrl,
                companyUrl,
                address,
                city,
                state,
                zipcode,
                qualifications ?: emptyList()
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