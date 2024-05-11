package ua.kpi.its.lab.data

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import ua.kpi.its.lab.data.config.Config
import ua.kpi.its.lab.data.entity.Route
import ua.kpi.its.lab.data.entity.Train
import ua.kpi.its.lab.data.svc.TrainService
import java.math.BigDecimal
import java.util.Calendar


fun main() {
    val context = AnnotationConfigApplicationContext(Config::class.java)
    val service = context.getBean(TrainService::class.java)
    val calendar = context.getBean(Calendar::class.java)

    val route1 = Route(
        departurePoint = "Lviv",
        destination = "Ternopil",
        departureDate = calendar.apply { set(2024, 0, 1, 0, 0, 0) }.time,
        mileage = 200,
        ticketPrice = 700,
        circular = true,
    )

    val train1 = Train(
        model = "Train Model 1.0",
        manufacturer = "Manufactorer 1.0",
        type = "Train Type 1",
        dateOfCommissioning = calendar.apply { set(2015, 0, 1, 0, 0, 0) }.time,
        seatsNumber = 1000,
        weight = BigDecimal("15626124.00"),
        availabilityOfAirConditioning = true,
        route = route1
    )

    val train2 = Train(
        model = "Train Model 2.0",
        manufacturer = "Manufactorer 2.0",
        type = "Train Type 2",
        dateOfCommissioning = calendar.apply { set(2016, 0, 1, 0, 0, 0) }.time,
        seatsNumber = 2000,
        weight = BigDecimal("15626124.00"),
        availabilityOfAirConditioning = false,
        route = route1
    )

    val train3 = Train(
        model = "Train Model 3.0",
        manufacturer = "Manufactorer 3.0",
        type = "Train Type 3",
        dateOfCommissioning = calendar.apply { set(2017, 0, 1, 0, 0, 0) }.time,
        seatsNumber = 3000,
        weight = BigDecimal("15626124.00"),
        availabilityOfAirConditioning = true,
        route = route1
    )

    val train4 = Train(
        model = "Train Model 4.0",
        manufacturer = "Manufactorer 4.0",
        type = "Train Type 4",
        dateOfCommissioning = calendar.apply { set(2018, 0, 1, 0, 0, 0) }.time,
        seatsNumber = 4000,
        weight = BigDecimal("15626124.00"),
        availabilityOfAirConditioning = false,
        route = route1
    )

    val train5 = Train(
        model = "Train Model 5.0",
        manufacturer = "Manufactorer 5.0",
        type = "Train Type 5",
        dateOfCommissioning = calendar.apply { set(2019, 0, 1, 0, 0, 0) }.time,
        seatsNumber = 5000,
        weight = BigDecimal("15626124.00"),
        availabilityOfAirConditioning = true,
        route = route1
    )

    service.create(train1)
    service.create(train2)
    service.create(train3)
    service.create(train4)
    service.create(train5)


    // get instance with index = 3
    val traibSelected3 = service.readByIndex(3)
    println("Retrieved $trainSelected3")
    // remove instance with index = 4
    val trainDeleted4 = service.deleteByIndex(4)
    println("Removed $trainDeleted4")
}