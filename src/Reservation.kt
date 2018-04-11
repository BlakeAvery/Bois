class Reservation: Reserve {
    override fun getFlight(flight: Short, list: ArrayList<Flight>): Flight {
        var returnGrabber: Int = 0 //This is the var that controls which array list item to grab pretty much
        //var flightFound: Boolean = true //Bugged implementation, figure out later
        var returner: Flight
        for(x in 0 until list.size) {
            val iteration = list[x]
            val flightNum = iteration.getFlightNumber()
            if(flight == flightNum) {
                returnGrabber = x
                //flightFound = true
            } //else flightFound = false
        }
        returner = list[returnGrabber]
        //else Flight(0, 0, Plane("Boeing 404 - Plane not found", 0, 0), 0.toFloat(), "Nowhere", "Nowhere")
        return returner
    }

    override fun flightIndex(flight: Short, list: ArrayList<Flight>): Int { //basically getFlight but returns an index of the list
        var returnGrabber: Int = 0 //This is the var that controls which array list item to grab pretty much
        //var flightFound: Boolean = true //Bugged implementation, figure out later
        for(x in 0 until list.size) {
            val iteration = list[x]
            val flightNum = iteration.getFlightNumber()
            if(flight == flightNum) {
                returnGrabber = x
                //flightFound = true
            } //else flightFound = false
        }
        /*if(flightFound)*/ return returnGrabber
        //else throw IllegalArgumentException("Flight could not be found.")
    }

    override fun bookFlight(seats: Int, flight: Short, list: ArrayList<Flight>): ArrayList<Flight> {
        var booked = getFlight(flight, list)
        val index = flightIndex(flight, list)
        val currentSeats = booked.getSeatsOpen()
        booked.setSeatsOpen(seats)
        if(currentSeats != booked.getSeatsOpen()) {
            booked.setPrice((booked.getPrice() + (seats.toFloat() / 2.0F * 5.0F)))
            println(list[index])
        }
        else {
            println("Flight not successfully booked.")
        }
        list[index] = booked
        return list
    }

    override fun newFlight(flightnum: Short, aircraft: Plane, price: Float, origin: String, dest: String): Flight {
        return Flight(flightnum, aircraft.getSeats().toInt(), aircraft, price, origin, dest)
    }
}