# Optional
É um objeto que encapsula outros objetos para tentar evitar o **NullPointerException**. Às vezes o retorno **Null** é desejado, neste caso pode-se retornar um **Optional**.  
Sintaxe:  

    //Optional.of(): Utilizado quando sabe que o retorno não será Null.
    Optional<Tipo> optional1 = Optional.of(Parâmetro);
    //Optional.ofNullable(): Quando não se tem certeza se o retorno será Not Null.
    Optional<Tipo> optional2 = Optional.ofNullable(Parâmetro);
    //Optional.empty(): Optional vazio.
    Optional<Tipo> optional2 = Optional.empty();

Em uma função pode-se encapsular o tipo do retorno com **Optional**, e caso encontre algo encapsular este retorno com **Optinal.of(retorno)** e se não encontrar nada usar **Optional.empty()**.

* Não usar **Optional** como parâmetro e nem como atributo de classe.
* Usar ele no retorno dos métodos.
