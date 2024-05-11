package ua.kpi.its.lab.data.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "train")
class Train(
    @Column
    var model: String,

    @Column
    var manufacturer: String,

    @Column
    var type: String,

    @Column
    var dateOfCommissioning: Date,

    @Column
    var seatsNumber: Int,

    @Column
    var weight: BigDecimal,

    @Column
    var availabilityOfAirConditioning: Boolean,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    var route: Route
) : Comparable<Train> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1

    override fun compareTo(other: Train): Int {
        val equal = this.model == other.model && this.weight == other.weight
        return if (equal) 0 else 1
    }

    override fun toString(): String {
        return "Train(model=$model, manufacturer=$manufacturer, route=$route)"
    }
}

@Entity
@Table(name = "route")
class Route(
    @Column
    var departurePoint: String,

    @Column
    var destination: String,

    @Column
    var departureDate: Date,

    @Column
    var mileage: BigDecimal,

    @Column
    var ticketPrice: Int,

    @Column
    var circular: Boolean,

    @OneToOne(mappedBy = "route")
    var train: Train? = null,
): Comparable<Route> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1

    override fun compareTo(other: Route): Int {
        val equal = this.departurePoint == other.departurePoint && this.mileage == other.mileage
        return if (equal) 0 else 1
    }

    override fun toString(): String {
        return "Route(departure date=$departureDate, departure point=$departurePoint, destination=$destination)"
    }
}