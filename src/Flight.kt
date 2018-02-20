data class Flight(private val flightNumber: Short, private var seatsOpen: Int, private var aircraftType: Plane, private var price: Float, private val origin: String, private val destination: String) {
    // Have fun with that unnecessarily long constructor up there ^
    fun getFlightNumber(): Short {
        return flightNumber
    }
    fun getSeatsOpen(): Int {
        return seatsOpen
    }
    fun getAircraftType(): Plane {
        return aircraftType
    }
    fun getPrice(): Float {
        return price
    }
    fun setSeatsOpen(param: Int) {
        if(seatsOpen - param < 0) {
            println("This amount of seats is not available.")
        } else {
            seatsOpen -= param
        }
    }
    fun setAircraftType(param: Plane) {
        aircraftType = param
    }
    fun setPrice(param: Float) {
        price = param
    }
    override fun toString(): String {
        return "Vestoria Flight $flightNumber: From $origin to $destination on an " + aircraftType.getAircraftType() + ". $seatsOpen seats available. Price: $$price."
    }
}