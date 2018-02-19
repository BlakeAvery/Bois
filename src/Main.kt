fun main(args: Array<String>) {
    val licenseName: String = "Generic Open Source License" //I'll figure this line out later
    val reserve = Reservation()
    // Let's attempt to create a bunch of objects dynamically in a for loop and shove it into an array list!
    var flightList: ArrayList<Flight> = ArrayList<Flight>()
    val defaultPlane = Plane("A320-200", 150, 2)
    for(x in 0 until 100) { //100 flights is good enough?
        val flightnumber: Short = ((Math.random() * 1000).toShort())
        val seats = defaultPlane.getSeats()
        val frickbat: Float = ((Math.random() * (1000 - 70)).toFloat())
        val defaultCost: Float = "%.2f".format(frickbat).toFloat() //STUPIDEST NUMBER FORMATTING HACK EVER KOTLIN GET YOUR SHIT TOGETHER
        flightList.add(x, Flight(flightnumber, seats.toInt(), defaultPlane, defaultCost))
    }
    //for(x in 0 until flightList.size) println(flightList[x].toString()) //commented out in case i wanna re-add the line later
    println("Vestoria Flight Reservation System v0.1")
    println("This software is licensed under the $licenseName. See the LICENSE file for details.")
    whomstve@ while(true) {
        print("\nEnter operation (1: Find flights, 2: Book flight, 3: print current flight status) ")
        var input = readLine()?.toInt() ?: 1
        when(input) {
            1 -> {
                print("Enter flight number: ")
                input = readLine()?.toInt() ?: 0
                print(reserve.getFlight(input.toShort(), flightList))
            }
            2 -> {
                print("Enter seats needed: ")
                input = readLine()?.toInt() ?: 0
                print("Enter flight number to book: ")
                val flight: Short = readLine()?.toShort() ?: 0
                flightList = reserve.bookFlight(input, flight, flightList)
            }
            3 -> {
                for(x in 0 until flightList.size) {
                    println(flightList[x].toString())
                }
            }
        }
    }
}