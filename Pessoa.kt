package exercicio2

import kotlin.system.exitProcess

class Pessoa {
    private var idade = 0
    private var diaNascimento = 0
    private var mesNascimento = 0
    private var anoNascimento = 0
    private var nome = ""
    private var diaAtual = 0
    private var mesAtual = 0
    private var anoAtual = 0


    fun pegarNome() {
        println("---------------------------------------------------")
        println("Informe o nome da pessoa que terá a idade calculada")
        println("---------------------------------------------------")
        nome = readln()
    }

    fun pegarDataDeNascimento() {
        println("---------------------------------------------------")
        println("Insira a data de nascimento de $nome")
        print("Mês: ")
        mesNascimento = readln().toInt()
        print("Dia: ")
        diaNascimento = readln().toInt()
        print("Ano: ")
        anoNascimento = readln().toInt()
        rodaNovamenteDataNascimento()
    }


    fun pegarDataAtual(){
        println("---------------------------------------------------")
        println("Insira a data de hoje")
        print("Mês: ")
        mesAtual = readln().toInt()
        print("Dia: ")
        diaAtual = readln().toInt()
        print("Ano: ")
        anoAtual = readln().toInt()
        rodaNovamenteDataAtual()

        calculaIdade()
    }

    private fun calculaIdade() {
        if (mesAtual >= mesNascimento && diaAtual >= diaNascimento){
            idade = anoAtual - anoNascimento
        } else {
            idade = anoAtual - anoNascimento - 1
        }
    }

    fun informarNomeEIdade() {
        println("---------------------------------------------------")
        println("$nome tem/teria $idade anos")
        println("---------------------------------------------------")
    }

    fun questinamentoNovoCalculo(){
        println("Deseja calcular outra idade? (1 - Sim/ 2 - Não)")
        println("---------------------------------------------------")

        when (readln().toInt()) {
            1 -> {
                main()
            }
            2 -> {
                exitProcess(0)
            }
            else -> {
                println("---------------------------------------------------")
                println("Escolha inválida. Tente novamente")
                println("---------------------------------------------------")
                questinamentoNovoCalculo()
            }
        }
    }

    private fun verificaMes(mesParametro: Int): Boolean {
        var resultado = true

        if (mesParametro > 12) {
            resultado = false
        }

        return resultado
    }

    private fun verificaDia(mesParametro : Int, diaParametro : Int): Boolean {
        var resultado = true

        when (mesParametro) {
            1, 3, 5, 7, 8, 10, 12 -> {
                if (diaParametro > 31){
                    resultado = false
                }
            }

            4, 6, 9, 11 -> {
                if (diaParametro > 30){
                    resultado = false
                }
            }

            2 -> if (diaParametro > 29){
                resultado = false
            }
        }

        return resultado
    }

    private fun rodaNovamenteDataNascimento(){
        if (!verificaMes(mesNascimento)){
            println("---------------------------------------------------")
            println("Mês inválido, tente cadastrar novamente.")
            pegarDataDeNascimento()
        }

        if (!verificaDia(mesNascimento, diaNascimento)){
            println("---------------------------------------------------")
            println("Dia inválido, tente cadastrar novamente.")
            pegarDataDeNascimento()
        }
    }

    private fun rodaNovamenteDataAtual(){
        if (!verificaMes(mesAtual)){
            println("---------------------------------------------------")
            println("Mês inválido, tente cadastrar novamente.")
            pegarDataAtual()
        }

        if (!verificaDia(mesAtual, diaAtual)){
            println("---------------------------------------------------")
            println("Dia inválido, tente cadastrar novamente.")
            pegarDataAtual()
        }
    }
}