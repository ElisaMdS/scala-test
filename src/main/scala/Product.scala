import java.util.Date

class Product() {
  var name : String = ""
  var category : String = ""
  var weight : Double = 0.0
  var price : Double = 0.0
  var creationDate : Date = new Date()

  def this(name: String, category: String, weight: Double, price: Double, creationDate: String) {
    this()

    this.name = name
    this.category = category
    this.weight = weight
    this.price = price
    this.creationDate = Utils.convertDate(creationDate)
  }
}
