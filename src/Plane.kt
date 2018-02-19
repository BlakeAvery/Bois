data class Plane(private val aircraftType: String, private val seats: Short, private val engineCount: Byte) {
    // Slightly less painful constructor than Flight, innit?
    fun getAircraftType(): String {
        return aircraftType
    }
    fun getSeats(): Short {
        return seats
    }
    fun getEngineCount(): Byte {
        return engineCount
    }
}