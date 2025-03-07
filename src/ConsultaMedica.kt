class ConsultaMedica {
    val mascota: Mascota
    val diagnostico: String
    private var costoBase: Double
    val incluyeMedicacion: Boolean

    constructor(mascota: Mascota, diagnostico: String, costoBase: Double, incluyeMedicacion: Boolean) {
        this.mascota = mascota
        this.diagnostico = diagnostico
        this.costoBase = costoBase
        this.incluyeMedicacion = incluyeMedicacion
    }

    override fun toString(): String {
        return "ConsultaMedica(mascota=${mascota.nombre}, diagnostico='$diagnostico', costoBase=$costoBase, incluyeMedicacion=$incluyeMedicacion)"
    }

    fun calcularCosto(): Double {
        return if (incluyeMedicacion) costoBase * 1.15 else costoBase
    }

    fun descripcionConsulta(): String {
        return "Mascota: ${mascota.nombre}, Diagnóstico: $diagnostico, Costo: ${calcularCosto()}"
    }
}

