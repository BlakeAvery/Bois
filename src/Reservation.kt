class Reservation: Reserve {
    var returnGrabber: Int = 0 //This is the var that controls which array list item to grab pretty much
    override fun getFlight(flight: Short, list: ArrayList<Flight>): Flight {
        var flightFound: Boolean = true
        var returner: Flight
        for(x in 0 until list.size) {
            val iteration = list[x]
            //println(iteration.getFlightNumber())
            val flightNum = iteration.getFlightNumber()
            if(flight == flightNum) {
                returnGrabber = x
                flightFound = true
            } else flightFound = false
        }
        //TODO: You think there's a way to create a null plane object?
        if(flightFound) returner = list[returnGrabber]
        else returner = Flight(0, 0, Plane("Boeing 404 - Plane not found", 0, 0), 0.toFloat())
        return returner
    }

    override fun bookFlight(seats: Int, flight: Short, list: ArrayList<Flight>): ArrayList<Flight> {
        var booked = getFlight(flight, list)
        val currentSeats = booked.getSeatsOpen()
        booked.setSeatsOpen(seats)
        if(currentSeats != booked.getSeatsOpen()) booked.setPrice((booked.getPrice() + 2))
        else {
            println("Flight not successfully booked.")
        }
        list[returnGrabber] = booked
        return list
    }
}