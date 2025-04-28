class VirtualPet(val nome: String) {
    var contagemTempo = 0
    var idade = 1
    var nivelDeFome = 0
    var nivelFelicidade = 100
    var nivelCansaco = 0
    var nivelIrBanheiro = 0
    var nivelSujeira = 0

    fun alimentar() {
        nivelDeFome -= 25
        nivelIrBanheiro += 20
        println("\n$nome foi alimentado.\n- Fome: $nivelDeFome\n- Ir ao Banheiro: $nivelIrBanheiro")
        contagemTempo ++
    }

    fun brincar() {
        nivelFelicidade += 30
        println("\n$nome está brincando e se sentindo mais feliz.")
        nivelCansaco += 10
        nivelSujeira += 10
        println("\n- Cansaço: $nivelCansaco \n- Sujeira: $nivelSujeira")
        contagemTempo ++
    }

    fun irAoBanheiro(){
        nivelIrBanheiro = 0
        println("\n$nome usou o banheiro. \n- Necessidades: $nivelIrBanheiro")
        contagemTempo ++
    }

    fun banho(){
        nivelSujeira = 0
        println("\n$nome tomou banho.\n Sujeira: $nivelSujeira")
        contagemTempo ++
    }

    fun verificarStatus() {
        println("\nStatus atual de $nome:")
        println("Idade: $idade")
        println("Nível de fome: $nivelDeFome")
        println("Nível de felicidade: $nivelFelicidade")
        println("Nível de cansaço: $nivelCansaco")
        println("Nivel de Necessidades: $nivelIrBanheiro")
        println("Nivel de Sujeira: $nivelSujeira")
        contagemTempo ++
    }

    fun passarTempo() {
        idade ++
        nivelFelicidade -= 20
        nivelCansaco += 10
        nivelDeFome += 20
        println("\ntempo esta passando: \nIdade: $idade\n- Felicidade: $nivelFelicidade\n- Cansaço: $nivelCansaco\n- Fome: $nivelDeFome")
    }

    fun descansar() {
        println("\nQuanto tempo deseja que $nome descanse? (1 a 8)")
        var tempoDescanso = readln().toIntOrNull()
        while(tempoDescanso == 0){
            println("Insira um numero valido. Tente Novamente: ")
            tempoDescanso = readln().toIntOrNull()
        }

        if(tempoDescanso == 8){
            nivelCansaco = 0
            nivelDeFome += 30
            nivelIrBanheiro += 20
        }
        else{
            nivelCansaco -= 20
            nivelDeFome += 10
            nivelIrBanheiro += 5
        }

        println("\n$nome descansou e pronto para brincar novamente!\n- Fome: $nivelDeFome\n- Ir ao banheiro: $nivelIrBanheiro")

    }
}

fun main() {
    println("Bem-vindo ao Simulador de Animal de Estimação Virtual!\n")
    println("\n --- Regras ---\n")
    println("- O objetivo é chegar à idade 50.\n" +
            "- Se chegar ao nivel 100 de cansaço ou fome, perdera. \n" +
            "- Sempre que o tempo passar o nivel de felicidade diminui em 20. \n" +
            "- Sempre que o tempo passar o nível de cansaço aumenta em 10.\n" +
            "- Se o nivel de Necessidade ou Sujeira chegar a 50, perdera\n" +
            "- Se o nivel de Felicidade chegar a 0, perdera\n")


    println("Digite o nome do seu animal de estimação:")
    val nomePet = readLine() ?: "Baltazar Guilherme Tenório"
    val pet = VirtualPet(nomePet)


    while (true) {
        if(pet.idade == 50){
            println("\nParabens, voce deixou seu Pet muito feliz, mas agora ele precisa seguir sua propria vida..." +
                    "\n\nObrigado por jogar!")
            false
            return
        }
        if(pet.nivelCansaco >= 100 || pet.nivelDeFome >= 100 || pet.nivelIrBanheiro >= 50 || pet.nivelFelicidade <= 0 || pet.nivelSujeira >= 50){
            println("\nVoce expirou as estatiscas do $nomePet e ele foi embora...")
            false
            return
        }
        if(pet.contagemTempo == 2){
            pet.passarTempo()
            pet.contagemTempo = 0
        }

        println("\nEscolha uma ação:")
        println("1. Alimentar $nomePet")
        println("2. Brincar com $nomePet")
        println("3. Colocar $nomePet para descasar")
        println("4. Colocar $nomePet para ir ao Banheiro")
        println("5. Colocar $nomePet para tomar banho")
        println("6. Verificar o status de $nomePet")
        println("7. Sair\n")

        val escolha = readLine()?.toIntOrNull() ?: continue

        when (escolha) {
            1 -> pet.alimentar()
            2 -> pet.brincar()
            3 -> pet.descansar()
            4 -> pet.irAoBanheiro()
            5 -> pet.banho()
            6 -> pet.verificarStatus()
            7 -> {
            println("\nSaindo do Simulador de Animal de Estimação Virtual. Adeus!")
            return
        }
            else -> println("\nEscolha inválida. Tente novamente.")
        }


    }
}