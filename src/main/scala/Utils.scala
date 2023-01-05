import java.text.SimpleDateFormat
import java.util.Date

object Utils {
  def convertDate(date: String): Date = {
    var formatDate = new SimpleDateFormat("yyyy-MM-dd")
    return formatDate.parse(date)
  }
}
