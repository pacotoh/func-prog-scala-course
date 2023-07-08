package enums

enum DayOfWeek {
  case Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday

  def isWeekend(day: DayOfWeek): Boolean = day match {
    case Saturday | Sunday => true
    case _ => false
  }
}
