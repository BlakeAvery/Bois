import java.io.File
fun main(args: Array<String>) {
    val licenseName: String = "Apache License 2.0"
    val version: Float = 0.5F
    val reserve = Reservation()
    val file: String = "airports.txt"
    val reader: File = File(file)
    val bussy: List<String> = reader.readLines()
    // Let's attempt to create a bunch of objects dynamically in a for loop and shove it into an array list!
    var flightList: ArrayList<Flight> = ArrayList<Flight>()
    val defaultPlane = Plane("A320-200", 150, 2)
    for(x in 0 until 12) {
        val flightnumber: Short = ((Math.random() * 1000).toShort())
        val seats = defaultPlane.getSeats()
        val frickbat: Float = (Math.random() * (500 - 70 + 1) + 70).toFloat()
        val defaultCost: Float = "%.2f".format(frickbat).toFloat() //STUPIDEST NUMBER FORMATTING HACK EVER KOTLIN GET YOUR SHIT TOGETHER
        val origin = bussy[(Math.random() * 16).toInt()]
        val dest = bussy[(Math.random() * 16).toInt()]
        flightList.add(x, Flight(flightnumber, seats.toInt(), defaultPlane, defaultCost, origin, dest))
    }
    //for(x in 0 until flightList.size) println(flightList[x].toString()) //commented out in case i wanna re-add the line later
    println("Vestoria Flight Reservation System v$version")
    println("This software is licensed under the $licenseName. See the LICENSE file for details.")
    while(true) {
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
                println()
                for(x in 0 until flightList.size) {
                    println(flightList[x].toString())
                }
            }
        }
    }
}