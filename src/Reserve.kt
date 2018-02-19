interface Reserve {
    fun getFlight(flight: Short, list: ArrayList<Flight>): Flight
    fun bookFlight(seats: Int, flight: Short, list: ArrayList<Flight>): ArrayList<Flight>
}