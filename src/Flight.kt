data class Flight(private val flightNumber: Short, private var seatsOpen: Int, private var aircraftType: Plane, private var price: Float) {
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
            print("This amount of seats is not available.")
        } else {
            seatsOpen -= param
        }
    }
    fun setAircraftType(param: Plane) {
        aircraftType = param
    }
    fun setPrice(param: Float) {
        
    }
}