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

## Ordenar uma lista de Objetos personalizada atraves de Comparable<>  
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

## Ordenar uma lista de Objetos personalizada atraves de Comparator<>  
Essa interface é utilizada quando já implementamos a interface **Comparable<>** e sobrescrevemos o método **compareTo()**. Para ordenar a lista por outro atributo devemos utilizar a interface **Comparator<>** e o método **compare**.  
Para implementar este método é preciso criar uma nova classe que implemena a interface. Após isso sobrescrever.

public class ComparandoId implements Comparable<ListaComId>{  
      @Override  
      
      public int compare(ComparandoId comparandoId, ListaComId listaComId){  
        return comparandoId.getId().compareTo(listaComId.getId());

      }   
}  
Após isso chamar a nova comparação:  

        listaComId.sort(new ComparandoId());

## Binary Search
Método estático da interface **Collections** que busca que retorna a posição em que deveria ser inserido um elemento caso ele não seja encontrado na busca, caso encontre algo retorna o índice. Para utilizar precisar ser passada uma lista já ordenada. Também pode ser feita a busca através da lista atual ordenada, um novo parâmetro de busca. Se estiver sendo feita uma ordenação customizada ela também precisa ser passada por parâmetro no **Collections.binarySearch(listaOrdenada, parametroDeBusca, new listaDeBuscaCustomizada())**.


## Conversão de Lista para Arrays e vice-versa.
Para transformar Array em List primeiro instância o Array, depois cria a lista e usa a função **asList(ArrayParâmetro)**.  
**A List que veio de um Array não pode ser modificada!**  
Como alterar os valores então?  
        
        List<Tipo> lista = new ArrayList<>(Array.asList(ArrayParâmetro));

Para converter uma **List** em **Array** cria-se a lista, após preenche-lá usa-se o método:  
        
        Integer[] arrayLista = lista.toArray(new TipoLista[0]);

Passando 0 no tamanho do novo **Array** o desempenho é melhor.  
**Obs**: Caso faça muitas remoções em uma lista, o mais recomendado é utilizar LinedList<>()

## Iterator
É uma classe que checa antes de fazer alguma ação.

## Set e HashSet
**Set**: Não permite elementos duplicados em uma **Collection**. O **Set** também não possuí índice.  
**HashSet**: Indica que a coleção será organizada pelo **HashCode**, os elementos são ordenados na lista conforma o resultado do **HashCode**. Caso queira adicionar algum elemento  o **Java** verifa o **Equals** e se for igual a algum existente este novo elemento é automáticamente deletado.  
**LinedHashSet**: Utilizado caso queira manter a ordem de inserção.

## NavigableSet e TreeSet
**NavigableSet**: Interface que faz parte do **Set**, segue as mesmas regras acima. Impementa através da classe **TreeSet**. Normalmente estas classes que tem **Tree** necessitam da implementação da interface **Comparable<>** ou o **Comparator<>** nos objetos que deseja adicionar a esta lista e o **TreeSet** não é diferente pelo fato dele não fazer a comparação utilizando o **Equals** mas sim os métodos dessas interfaces.   
Na instânciação dos objetos dentro da lista ele já organiza eles conforme o resultado dos métodos de comparações das respectivas interfaces.


