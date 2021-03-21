package haileyj.wordofmouth.repository

import haileyj.wordofmouth.entity.Snack
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface SnackRepository : MongoRepository<Snack, String>