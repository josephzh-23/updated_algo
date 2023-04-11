fun main() {

    var c= Cool()
    var joe = c.run{
        cool2()
    }
    println("joe")
}

class Cool(){
    fun cool2(): String{

        return "cool"
    }
}

