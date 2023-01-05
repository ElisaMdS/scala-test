import java.util.Date

class Order() {
  var customerNameAndContact : String = ""
  var shippingAddress : String = ""
  var grandTotal : Double = 0.0
  var dateWhenTheOrderWasPlaced: Date = new Date()
  var item : List[Item] = List()

  def this(customerNameAndContact: String, shippingAddress: String, grandTotal: Double, dateWhenTheOrderWasPlaced: String, item: List[Item]) {
    this()

    this.customerNameAndContact = customerNameAndContact
    this.shippingAddress = shippingAddress
    this.grandTotal = grandTotal
    this.dateWhenTheOrderWasPlaced = Utils.convertDate(dateWhenTheOrderWasPlaced)
    this.item = item
  }
}