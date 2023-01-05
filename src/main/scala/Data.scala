//Em scala utilizamos objetos quando queremos usar métodos estáticos
object Data {
  def addData(): List[Order] = {
    var product1 : Product = new Product("Celular", "Dispositivos Móveis", 300.00, 1000.99, "2021-01-03 00:00:00")
    var product2 : Product = new Product("Tablet", "Dispositivos Móveis", 500.00, 2500.99, "2022-01-03 00:00:00")
    var product3 : Product = new Product("Fone de Ouvido", "Som Portátil", 50.00, 500.99, "2022-11-03 00:00:00")

    var item1 : Item = new Item(4524.67, 27.34, 39.93, product1)
    var item2 : Item = new Item(2195.12, 41.21, 12.31, product2)
    var item3 : Item = new Item(3388.23, 24.02, 6.36, product2)
    var item4 : Item = new Item(4364.34, 5.25, 7.96, product3)
    var item5 : Item = new Item(2190.45, 4.08, 34.63, product3)

    var listItem1 : List[Item] = List(item1, item3, item5)
    var listItem2 : List[Item] = List(item3)
    var listItem3 : List[Item] = List(item1, item3, item4, item5)
    var listItem4 : List[Item] = List(item2, item5)
    var listItem5 : List[Item] = List(item1, item2, item3, item4, item5)

    var order1 : Order = new Order("Maria", "Rua 3328", 3169.56, "2021-01-03 00:00:00", listItem1)
    var order2 : Order = new Order("Luisa", "Rua 1391", 3169.56, "2021-01-03 00:00:00", listItem2)
    var order3 : Order = new Order("Diego", "Rua 3328", 3169.56, "2021-01-03 00:00:00", listItem3)
    var order4 : Order = new Order("Ana", "Rua 3328", 3169.56, "2021-01-03 00:00:00", listItem4)
    var order5 : Order = new Order("Flavio", "Rua 3328", 3169.56, "2022-01-03 00:00:00", listItem5)

    return List(order1, order2, order3, order4, order5)
  }

}