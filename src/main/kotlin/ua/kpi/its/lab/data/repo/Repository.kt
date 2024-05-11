package ua.kpi.its.lab.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import ua.kpi.its.lab.data.entity.Train
import ua.kpi.its.lab.data.entity.Route

interface TrainRepository : JpaRepository<Train, Long> {

}

interface RouteRepository : JpaRepository<Route, Long> {

}