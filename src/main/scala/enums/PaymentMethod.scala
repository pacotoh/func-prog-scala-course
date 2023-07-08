package enums

import java.util.Date

enum PaymentMethod {
  case CreditCard(kind: Card, holder: String, number: Long, expires: Date)
  case PayPal(email: String)
}

enum Card {
  case Visa, Mastercard, Amex
}