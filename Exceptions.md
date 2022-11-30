# Exception
São do tipo **Checked**.

* **Checked** :Tipo de *exceção* que é obrigatório fazer o tratamento. Normalmente utilizado para tratamento o bloco

try{

    //Código que pode lançar exceção
} cath(Tipo da exeção || variavel da exceção normalmente usada letra "e"){

    //Tratativa de erro. Lógica de negócio nunca deve estar no cath
    //Colocar o printStackTrace() dentro do cath
}


# Exceções Unchecked
São do tipo **RuntimeException** ou **Unchecked**. Não obrigam um tratamento para poder executar o código.

Para lançar este tipo de exceção não precisar ter declaração do tipo da exceção em bloco try cath.

Ex: Uma divisão por números validando se não tem divisão por 0.

private static int divisao(int a, int b){

    if(b == 0 ){
        throw new IllegalArgumentException("Argumento ilegal");
    }
}


## Utilização do throws na assinatura de métodos:
No final do nome do método colocar **throws** e o tipo da   
exceção que aquele método pode lançar. Isso faz com que quem   
chamar o método tenha de fazer um tratamento para previnir que a 
 exceção ocorra. Métodos que pode ter exceções 
 **RuntimeException** não costumam ter **throws** em sua  
  declaração, é preferivel utilizar um comentário no método 
  indicando que algum erro deve ser previnido.


## Quando utilizar throws ou try cath?
Se o método for **private** utiliar **try cath** caso contrário pode usar o **throws**. Para tratar **múltiplas exceções** usa-se **múltiplos caths**.

Também é possível fazer o relancamento da exceção após trata-lá. Para isso é só inserir o **throw e**. 

## Bloco Finally
Faz com que um bloco de código seja executado independente do  resultado de um **try cath** . Utilizar sempre que precisar que  alguma coisa seja encerrada ao final de um bloco de código.

## Multi cath em linha
Colocar as exceções na mesma linha separa por | se a exceção tiver o mesmo nível de herança ocorre erro.

![Exemplo](Exceptions.png)


## try with resources
Objetos que implementam as interfaces **Closeable** ou **AutoCloseable** podem ser instânciados diretamente no **try** para que a exceção de fechar algum arquivo seja feita pelo Java.  
Ex: try(Reader reader = new Reader())  
Neste caso o Objeto **Reader** implementa as duas interfaces. E não é necessário usar o **cath**, mas por boa prática é bom utilizá-lo.