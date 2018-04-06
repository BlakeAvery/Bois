interface Reserve {
    fun getFlight(flight: Short, list: ArrayList<Flight>): Flight
    fun bookFlight(seats: Int, flight: Short, list: ArrayList<Flight>): ArrayList<Flight>
    fun flightIndex(flight: Short, list: ArrayList<Flight>): Int
    fun newFlight(flightnum: Short, aircraft: Plane, price: Float, origin: String, dest: String): Flight
}