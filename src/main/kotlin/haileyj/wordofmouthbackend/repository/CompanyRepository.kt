package haileyj.wordofmouthbackend.repository

import haileyj.wordofmouthbackend.entity.Company
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CompanyRepository : MongoRepository<Company, String>