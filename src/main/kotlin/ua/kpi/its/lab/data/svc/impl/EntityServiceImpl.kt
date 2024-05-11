package ua.kpi.its.lab.data.svc.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.kpi.its.lab.data.entity.Train
import ua.kpi.its.lab.data.repo.TrainRepository
import ua.kpi.its.lab.data.svc.TrainService

@Service
class TrainServiceImpl @Autowired constructor(
    private val repository: TrainRepository
): TrainService {
    // Your code here
    override fun create(train: Train): Train {
        if (repository.existsById(train.id)) {
            throw IllegalArgumentException("Train with ID = ${train.id} already exists")
        }
        return repository.save(train)
    }

    override fun read(): List<Train> {
        return repository.findAll()
    }

    override fun readByIndex(index: Int): Train {
        return this.read()[index]
    }

    override fun update(train: Train): Train {
        if (!repository.existsById(train.id)) {
            throw IllegalArgumentException("Train with ID = ${train.id} not found")
        }
        return repository.save(train
    }

    override fun delete(train: Train) {
        if (!repository.existsById(train.id)) {
            throw IllegalArgumentException("Train with ID = ${train.id} not found")
        }
        repository.deleteById(train.id)
    }

    override fun deleteByIndex(index: Int): Train {
        val target = this.readByIndex(index)
        this.delete(target)
        return target
    }
}