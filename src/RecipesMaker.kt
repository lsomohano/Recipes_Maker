val recetas: MutableList<MutableList<String>> = mutableListOf()
val productList: List<String> = listOf<String>("Agua","Leche","Carne","Verduras","Frutas","Cereal","Huevos","Aceite")
val menuPrincipal: String = """
               :: Bienvenido a Recipe Maker ::

                Selecciona la opción deseada
                1. Hacer una receta
                2. Ver mis recetas
                3. Salir""".trimIndent()
val menuIngredientes = """
        :: Menu Ingredientes ::
        Selecciona la opción deseada
        1. Agua
        2. Leche
        3. Carne
        4. Verduras
        5. Frutas
        6. Cereal
        7. Huevos
        8. Aceite
        9. Salir
        """.trimIndent()
fun main(args: Array<String>) {

        principal@ while (true){
                println(menuPrincipal)
                val opciones:String? = readLine();
                val opcion:Int = opciones?.toInt()?:0
                if (opcion !in 1..3){
                        println("Seleccione una opcion valida")
                        continue@principal
                }
                when(opcion){
                        1-> {
                                val re = makeRecipe()
                                if (!re.size.equals(0)) {
                                        recetas.add(re)
                                        println("Su receta se a guardado correctamente")
                                } else {
                                        println("No se guardo ninguna receta")
                                }
                        }
                        2 -> {viewRecipe(recetas)}
                        3->break

                }
        }
}
 fun makeRecipe(): MutableList<String> {
         var receta: MutableList<String> = mutableListOf()
         println(menuIngredientes)
         while (true){
                 val opciones:String? = readLine();
                 val opcion:Int = opciones?.toInt()?:0
                 when(opcion){
                         9->{
                                 return receta
                         }
                         in 1..8->{
                                 receta.add(productList.get(opcion.minus(1)))
                                 println("Se agrego ${productList.get(opcion.minus(1))} ")
                                 //println("Tamaño ${receta.size}")
                         }
                         else-> println("Ingrese una opccion correcta!")
                 }

         }
 }

fun viewRecipe(Lista:MutableList<MutableList<String>>){
        println(":: Ver mis recetas ::")
        for (i in Lista){
                val number= Lista.indexOf(i).plus(1)
                println("Receta $number")
                println(i)
                println()
        }
}