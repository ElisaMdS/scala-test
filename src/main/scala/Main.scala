import java.time.{LocalDate, Period, ZoneId}
import java.util.{Calendar, Date}
import scala.collection.mutable
import scala.math.Ordering.Implicits._

object Main {
  private def filterOrderListByDate(orders: List[Order], initialDateFormatted: Date, finalDateFormatted: Date): List[Order] = {
    var filteredOrders: List[Order] = orders.filter(order => order.dateWhenTheOrderWasPlaced >= initialDateFormatted && order.dateWhenTheOrderWasPlaced <= finalDateFormatted)
    return filteredOrders
  }

  private def generateResultMap(orders: List[Order], localFormatActualDay: LocalDate, intervalList: List[List[String]]): mutable.Map[String, Int] = {
    var intervals: scala.collection.mutable.Map[String, Int] = scala.collection.mutable.Map()
    intervalList.foreach(interval =>
      if (interval.head.isEmpty) intervals.put(">" + interval(1), 0)
      else intervals.put(interval.head + "-" + interval(1), 0)
    )

    orders.foreach(order => order.item.foreach(item => {
      var productCreationDate = item.product.creationDate.toInstant.atZone(ZoneId.systemDefault()).toLocalDate
      var monthDifference = Period.between(localFormatActualDay, productCreationDate).toTotalMonths.abs

      intervalList.foreach(interval => {
        if (interval.head.isEmpty) {
          if(monthDifference > interval(1).toInt)
            intervals(">" + interval(1)) += 1
        }
        else if (monthDifference >= interval.head.toInt && monthDifference <= interval(1).toInt) {
          intervals(interval.head + "-" + interval(1)) += 1
        }
      })
    }))

    return intervals
  }

  def main(args: Array[String]): Unit = {
    var resultMapKeys: List[String] =
      if (args.length == 2) List("1-3", "4-6", "7-12", ">12")
      else args.slice(2, args.length).toList

    var initialDate: String = args(0)
    var finalDate: String = args(1)

    var initialDateFormatted = Utils.convertDate(initialDate)
    var finalDateFormatted = Utils.convertDate(finalDate)

    var currentDate = Calendar.getInstance().getTime

    val localFormatActualDay = currentDate.toInstant.atZone(ZoneId.systemDefault()).toLocalDate

    var orders: List[Order] = Data.addData()

    var filteredOrders: List[Order] = filterOrderListByDate(orders, initialDateFormatted, finalDateFormatted)

    var intervalList: List[List[String]] = List()
    resultMapKeys.foreach(interval => {
      var splittedInterval = interval.split("\\D+").toList
      intervalList = splittedInterval :: intervalList
    })

    var intervals = generateResultMap(filteredOrders, localFormatActualDay, intervalList)

    for ((key, value) <- intervals.toSeq.sortWith(_._1 < _._1)) println(s"$key months: $value orders")
  }
}
