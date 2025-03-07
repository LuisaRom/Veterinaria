import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val veterinaria = Veterinaria()

    while (true) {
        println("\nVETERIANRIA")
        println("1. Agregar mascota")
        println("2. Registrar consulta médica")
        println("3. Mostrar historial de consultas")
        println("4. Modificar datos de mascota")
        println("5. Mostrar lista de mascotas")
        println("6. Calcular costo total de consultas")
        println("0. Salir")
        print("Seleccione una opción: ")

        when (scanner.nextInt()) {
            1 -> {
                print("Nombre: ")
                val nombre = scanner.next()
                print("Especie: ")
                val especie = scanner.next()
                print("Edad: ")
                val edad = scanner.nextInt()
                print("Peso: ")
                val peso = scanner.nextDouble()
                veterinaria.agregarMascota(Mascota(nombre, especie, edad, peso))
                println("Mascota agregada exitosamente.")
            }

            2 -> {
                print("Nombre de la mascota: ")
                val nombre = scanner.next()
                val mascota = veterinaria.obtenerMascotas().find { it.nombre == nombre }
                if (mascota != null) {
                    print("Diagnóstico: ")
                    val diagnostico = scanner.next()
                    print("Costo base: ")
                    val costoBase = scanner.nextDouble()
                    print("¿Incluye medicación? (true/false): ")
                    val incluyeMedicacion = scanner.nextBoolean()
                    veterinaria.registrarConsulta(mascota, diagnostico, costoBase, incluyeMedicacion)
                    println("Consulta registrada exitosamente.")
                } else {
                    println("Mascota no encontrada.")
                }
            }

            3 -> {
                print("Nombre de la mascota: ")
                val nombre = scanner.next()
                val mascota = veterinaria.obtenerMascotas().find { it.nombre == nombre }
                if (mascota != null) {
                    veterinaria.mostrarHistorialConsultas(mascota)
                } else {
                    println("Mascota no encontrada.")
                }
            }

            4 -> {
                print("Nombre de la mascota: ")
                val nombre = scanner.next()
                val mascota = veterinaria.obtenerMascotas().find { it.nombre == nombre }
                if (mascota != null) {
                    print("Nuevo peso (o -1 para no cambiar): ")
                    val nuevoPeso = scanner.nextDouble()
                    print("Nueva edad (o -1 para no cambiar): ")
                    val nuevaEdad = scanner.nextInt()
                    veterinaria.modificarDatosMascota(
                        mascota,
                        if (nuevoPeso > 0) nuevoPeso else null,
                        if (nuevaEdad > 0) nuevaEdad else null
                    )
                    println("Datos modificados correctamente.")
                } else {
                    println("Mascota no encontrada.")
                }
            }

            5 -> {
                veterinaria.mostrarMascotas()
            }

            6 -> {
                print("Nombre de la mascota: ")
                val nombre = scanner.next()
                val mascota = veterinaria.mascotas.find { it.nombre == nombre }
                if (mascota != null) {
                    val costoTotal = veterinaria.calcularCostoTotalConsultas(mascota)
                    println("Costo total de consultas para ${mascota.nombre}: $costoTotal")
                } else {
                    println("Mascota no encontrada.")
                }
            }

            0 -> {
                println("Saliendo del sistema...")
                break
            }

            else -> println("Opción no válida.")
        }
    }
}


