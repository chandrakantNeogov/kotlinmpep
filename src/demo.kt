fun main() {
    println("Adapter Pattern Practical Example")

    // Legacy payment system
    val legacyPaymentSystem = LegacyPaymentSystem()

    // Adapter to use legacy system with modern interface
    val paymentAdapter = PaymentAdapter(legacyPaymentSystem)
    paymentAdapter.processPayment(100.0) // Adapts the call to the legacy system


    val redCircle = Circle(RedColor())
    val blueSquare = Square(BlueColor())

    redCircle.draw()
    blueSquare.draw()
}

// Legacy payment system with an old method
class LegacyPaymentSystem {
    fun processOldPayment(amount: Double) {
        println("Processing payment of $$amount using LegacyPaymentSystem")
    }
}

// Modern payment system interface
interface ModernPaymentSystem {
    fun processPayment(amount: Double)
}

// Adapter to bridge LegacyPaymentSystem to ModernPaymentSystem
class PaymentAdapter(private val legacyPaymentSystem: LegacyPaymentSystem) : ModernPaymentSystem {
    override fun processPayment(amount: Double) {
        legacyPaymentSystem.processOldPayment(amount) // Adapts the call
    }
}




// Implementor interface
interface Color {
    fun applyColor(): String
}

// Concrete Implementors
class RedColor : Color {
    override fun applyColor() = "Red"
}

class BlueColor : Color {
    override fun applyColor() = "Blue"
}

// Abstraction
abstract class Shape(protected val color: Color) {
    abstract fun draw()
}

// Refined Abstractions
class Circle(color: Color) : Shape(color) {
    override fun draw() {
        println("Drawing Circle in ${color.applyColor()} color")
    }
}

class Square(color: Color) : Shape(color) {
    override fun draw() {
        println("Drawing Square in ${color.applyColor()} color")
    }
}