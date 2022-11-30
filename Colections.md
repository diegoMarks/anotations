## Equals
Compara os valores de duas String's e também compara se dois objetos são lógicamente iguais.  
Regras do **Equals**:  
* Reflexivo: x.equals(x) tem que ser **true** para tudo que for diferente de null.  
* Simétrico: para x e y diferentes de null, se x.equals(y) == true logo, y.equals(x) == true.  
* Transitividade: Para x,y,z diferentes de null, e x.equals(z) == true, logo y.equals(z) == true.  
* Consistente: x.equals(x) sempre retorna true se x for diferente de null.  Para x diferente de null, x.equals(null) tem que retornar false.   
Para sobrescrever o **Equals** deve ser verificado na regra de negócio do objeto quais as caracteristicas que definem igualdade.

## HashCode
É um número gerado para identificar a posição de um item em uma  coleção.  
**Regras de implementação do HashCode**:  
* Se x.equals(y) == true, então y.hasCode() == x.hashCode().
* y.hashCode() == x.hashCode, não necessariamente o equals de y.equals(x) tem que ser true.
* x.equals(y) == false, então o hashCode tem que ser diferente.  
* y.hashCode() != x.hashCode(), x.equals(y) deverá ser falso.

## Complexidade Big-O
Colções em Java são separadas em duas: **Ordered e Sorted**. Para tirar dúvidas sobre qual coleção utilizar dependendo da operação, pesquisar **Complexidade Big-O Java** no Google que é GG.

## List
É uma coleção ordenada. Não é recomendado iterar a lista com for, o melhor é usar o stream() para filtrá-la.

## Sorting Lists
Collections.sort ordena a lista podendo ser em ordem numérica ou alfabética. Uma coisa importante é que a classe Objects tem o método requireNonNull() que se usado no construtor e passado um atributo por parâmetro ele garante que aquele atributo não pode ser nulo.  
**Ordenar uma lista de Objetos personalizada:**  
* Implementar a interface **Comparable<>**.  
* Ao sobrescrever o método **CompareTo**: 
* Retorna negativo se o this < objeto.  
* Se this == objeto retorna 0.  
* Positivo se this > objeto.  
Quando estiver trabalhando com tipo de atributo **Wrapper** essa implelentação não se faz necessário pelo fato dos **Wrapper's** já implentarem a interface **Comparable<>**.  

@Override  
public int compareTo(Objeto objeto){  

        return this.atributoWrapper.CompareTo(comparação);
}  

Ou se o atributo for primitivo podemos utilizar o **Wrapper** também:  

@Override  
public int compareTo(Objeto objeto){  

        return Integer.compare(idCliente, objeto.getIdCliente());
}