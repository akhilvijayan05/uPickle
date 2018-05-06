package com.example.model

import argonaut.Argonaut.casecodec2
import play.api.libs.json.Json
import upickle.default.{macroRW, ReadWriter}

case class Product(brand: String, model : String)

object Product {
  implicit val playJsonFormatter  = Json.format[Product]
  implicit def uPickleFormatter: ReadWriter[Product] = macroRW
  implicit def PersonCodecJson =
    casecodec2(Product.apply, Product.unapply)("brand", "model")
}
