object Main extends App {


  //creation de clase mutable
  class Bicicleta(_cadencia: Int, _marcha: Int, _velocidad: Int) {
    var cadencia: Int = _cadencia
    var marcha: Int = _marcha
    var velocidad: Int = _velocidad
  }

  //definir class

  val bl = new Bicicleta(1, 10, 100)

  class Bicicleta(val cadencia: Int, marcha: Int, velocidad: Int)

  val b3

}