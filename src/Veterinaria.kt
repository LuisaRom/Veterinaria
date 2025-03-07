class Veterinaria {
     val mascotas = mutableListOf<Mascota>()
     val consultas = mutableListOf<ConsultaMedica>()

    fun agregarMascota(mascota: Mascota) {
        mascotas.add(mascota)
    }

    fun registrarConsulta(mascota: Mascota, diagnostico: String, costoBase: Double, medicacion: Boolean) {
        val consulta = ConsultaMedica(mascota, diagnostico, costoBase, medicacion)
        consultas.add(consulta)
    }

    fun mostrarHistorialConsultas(mascota: Mascota) {
        println("Historial de consultas para ${mascota.nombre}:")
        for (consulta in consultas) {
            if (consulta.mascota == mascota) {  // Ahora sí se pueden comparar
                println("Diagnóstico: ${consulta.diagnostico}, Costo: ${consulta.calcularCosto()}")
            }
        }
    }

    fun calcularCostoTotalConsultas(mascota: Mascota): Double {
        return consultas.filter { it.mascota == mascota }.sumOf { it.calcularCosto() }
    }

    fun modificarDatosMascota(mascota: Mascota, nuevoPeso: Double? = null, nuevaEdad: Int? = null) {
        nuevoPeso?.let { mascota.actualizarPeso(it) }
        nuevaEdad?.let { mascota.edad = it }
    }

    fun mostrarMascotas() {
        println("Lista de mascotas:")
        for (mascota in mascotas) {
            println(mascota.describirMascota())
        }
    }

    fun obtenerMascotas(): List<Mascota> {
        return mascotas
    }

}
