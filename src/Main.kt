import java.io.File

fun generateNewPlane(name: String, seats: Short, engines: Byte): Plane {
    return Plane(name, seats, engines)
}

fun main(args: Array<String>) {
    val licenseName: String = "Apache License 2.0"
    val version: Float = 0.8F
    val reserve = Reservation()
    val file: String = "airports.txt"
    val reader: File = File(file)
    val bussy: List<String> = reader.readLines()
    // Let's attempt to create a bunch of objects dynamically in a for loop and shove it into an array list!
    var flightList: ArrayList<Flight> = ArrayList<Flight>()
    val A320 = generateNewPlane("A320-200", 150, 2)
    val CRJ700 = generateNewPlane("CRJ-700", 70, 2)
    val Boing = generateNewPlane("747-8", 460, 4)
    for(x in 0 until 12) {
        val flightnumber: Short = ((Math.random() * 1000).toShort())
        val frickbat: Float = (Math.random() * (500 - 60 + 1) + 60).toFloat()
        val defaultCost: Float = "%.2f".format(frickbat).toFloat()
        val origin = bussy[(Math.random() * 16).toInt()]
        val dest = bussy[(Math.random() * 16).toInt()]
        if(defaultCost < 150.00) {
            flightList.add(x, Flight(flightnumber, CRJ700.getSeats().toInt(), CRJ700, defaultCost, origin, dest))
        } else if(defaultCost < 300.00) {
            flightList.add(x, Flight(flightnumber, A320.getSeats().toInt(), A320, defaultCost, origin, dest))
        } else {
            flightList.add(x, Flight(flightnumber, Boing.getSeats().toInt(), Boing, defaultCost, origin, dest))
        }
    }
    //for(x in 0 until flightList.size) println(flightList[x].toString()) //commented out in case i wanna re-add the line later
    println("Vestoria Flight Reservation System v$version")
    println("This software is licensed under the $licenseName. See the LICENSE file for details.")
    while(true) {
        print("\nEnter operation (1: Find flights, 2: Book flight, 3: print current flight status, 4: add a new flight) ")
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
                println()
                for(x in 0 until flightList.size) {
                    println(flightList[x].toString())
                }
            }
            4 -> {
                print("Enter flight number: ")
                val flightnum: Short = readLine()?.toShort() ?: 0
                var airplane: Plane
                print("Choose an aircraft.\n1 for A320, 2 for CRJ-700, 3 for 747-8:")
                val airtype: Int = readLine()?.toInt() ?: 1
                when(airtype) {
                    1 -> airplane = A320
                    2 -> airplane = CRJ700
                    3 -> airplane = Boing
                    else -> airplane = A320
                }
                print("Enter price: ")
                val price = readLine()?.toFloat() ?: 70.0f
                println("Origin codes:")
                for(x in 0 until bussy.size) {
                    println("$x: ${bussy[x]}")
                }
                print("Enter origin code index: ")
                var o = readLine()?.toInt() ?: 1
                if(o > bussy.size - 1) {
                    o = 0
                }
                val origin = bussy[o]
                println("Destination codes:")
                for(x in 0 until bussy.size) {
                    println("$x: ${bussy[x]}")
                }
                print("Enter destination code index: ")
                o = readLine()?.toInt() ?: 1
                if(o > bussy.size - 1) {
                    o = 0
                }
                val dest = bussy[o]
                flightList.add(reserve.newFlight(flightnum, airplane, price, origin, dest))
            }
        }
    }
}