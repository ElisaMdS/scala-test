class Item() {
  var cost : Double = 0.0
  var shippingFee : Double = 0.0
  var taxAmmount : Double = 0.0
  var product : Product = new Product()

  def this(cost: Double, shippingFee: Double, taxAmmount: Double, product: Product) {
    this()

    this.cost = cost
    this.shippingFee = shippingFee
    this.taxAmmount = taxAmmount
    this.product = product
  }
}