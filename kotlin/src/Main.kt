enum class FormacaoNivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Aluno(val id: Int, val nome: String) {
    override fun toString(): String {
        return "$id - $nome"
    }
}

class ConteudoEducacional(val id: Int, val nome: String) {
    private val _alunos: MutableList<Aluno> = mutableListOf()

    fun matricular(aluno: Aluno) {
        _alunos.add(aluno)
    }

    override fun toString(): String {
        return "$nome (Alunos cadastrados: ${_alunos.joinToString(" | ")})"
    }
}

data class Formacao(val nome: String, val nivel: FormacaoNivel, val conteudosEducacionais: List<ConteudoEducacional>) {
    override fun toString(): String {
        return "Formação: $nome. Nível: $nivel. Conteúdos Educacionais: [ ${conteudosEducacionais.joinToString(" | ")} ]"
    }
}

fun main() {
    val aluno1 = Aluno(id = 1, nome = "Fulano")
    val aluno2 = Aluno(id = 2, nome = "Ciclano")
    val aluno3 = Aluno(id = 3, nome = "Beltrano")

    val formacao1 = Formacao(
        "Kotlin Básico", FormacaoNivel.BASICO, listOf(
            ConteudoEducacional(id = 1, nome = "Sintaxe básica"),
            ConteudoEducacional(id = 2, nome = "Funções"),
            ConteudoEducacional(id = 3, nome = "Orientação a Objetos")
        )
    )

    val formacao2 = Formacao(
        "Kotlin Intermediário", FormacaoNivel.INTERMEDIARIO, listOf(
            ConteudoEducacional(id = 4, nome = "Control Flow"),
            ConteudoEducacional(id = 5, nome = "Tratamento de Exceções"),
            ConteudoEducacional(id = 6, nome = "Scope Functions")
        )
    )

    val formacao3 = Formacao(
        "Kotlin Avançado", FormacaoNivel.AVANCADO, listOf(
            ConteudoEducacional(id = 7, nome = "Domínios ricos"),
            ConteudoEducacional(id = 8, nome = "Lambda Functions"),
            ConteudoEducacional(id = 9, nome = "Design Patterns")
        )
    )

    formacao1.conteudosEducacionais.find { it -> it.id == 1 }?.apply {
        matricular(aluno1)
        matricular(aluno2)
        matricular(aluno3)
    }

    formacao1.conteudosEducacionais.find { it -> it.id == 2 }?.apply {
        matricular(aluno1)
        matricular(aluno2)
        matricular(aluno3)
    }

    formacao1.conteudosEducacionais.find { it -> it.id == 3 }?.apply {
        matricular(aluno1)
        matricular(aluno2)
        matricular(aluno3)
    }

    formacao2.conteudosEducacionais.find { it -> it.id == 4 }?.apply {
        matricular(aluno1)
        matricular(aluno2)
    }

    formacao2.conteudosEducacionais.find { it -> it.id == 5 }?.apply {
        matricular(aluno1)
        matricular(aluno2)
    }

    formacao2.conteudosEducacionais.find { it -> it.id == 6 }?.apply {
        matricular(aluno1)
    }

    formacao3.conteudosEducacionais.find { it -> it.id == 7 }?.apply {
        matricular(aluno1)
    }

    formacao3.conteudosEducacionais.find { it -> it.id == 8 }?.apply {
        matricular(aluno1)
    }

    println(formacao1)
    println(formacao2)
    println(formacao3)
}