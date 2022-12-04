# Stream
Processamento de dados de forma mais funcional.  
* **Stream** trabalha com dados no tempo, não está sendo guardando nada.   
### Operações com Stream
* Intermediárias: Ação que retorna um próprio **Stream**.   
    Ex: filtrar, encadear, limitar. 

Alguns dos principais métodos Intermediários:  
**sorted()**: Ordena a lista.  
**filter()**: Filtra.  
**limit(quantidade)**: Limita a quantidade de retorno.  
**map()**: O que será retornado.  
**flatMap()**: Utilizado para retornar os itens de uma lista multidimencional.  
Ex:

        lista.stream().flatMap(Collection::stream).forEach(System.out::println);

Imprime todos os itens da lista.  
**anyMatch()**: Recebe um **Predicate** e retorna um booleano do resultado da busca.  
**allMatch**: Recebe um **Predicate** e retorna true caso todos os elementos da lista atendam o mesmo.  
**noneMatch**: Recebe um **Predicate** e retorna true caso nenhum dos elementos da lista atendam o **Predicate**. Esses dois elementos devem vir com ordem inversa do **Predicate**, se um buscar o maior o outro deve verificar se tem algum menor.

* Finais: Os métodos finais trazem os dados do tempo para o espaço. 

Principais métodos **Finais**:  
**collect()**: Entre os principais, pode retornar um **Collectors.toSet()** ou um **Collectors.toList()**.  
**forEach()**: Método que faz a iteração dos itens de uma lista. Caso só queira imprimir dados na tela, é melhor usar o método **forEach** diretamente na lista, sem **Stream()**.  
**count()**: Conta os itens de uma lista, normalmente usado após o **filter()**.  


## Reduce
Uma operação terminal que possíbilita ter um resultado único a partir de uma sequência de elementos.  
Ex:

        List<Integer> list = List.of(1,2,3,4,5,6);
        list.stream.reduce(Integer::sum).ifPresent(System.out::println);

Soma todos os valores da lista e imprime o resultado. Para evitar um retorno de **Optional** pode-se colocar um valor no reduce indicando o valor de início da operação. 
**OBS**: Tomar cuidado ao usar o **Reduce**, esse método faz o boxing e unboxing dos elementos e isso pode afetar o desempenho da aplicação. Para evitar isso pode-se usar o mapTo para converter o tipo para um valor específico primitivo, nestes casos usam-se as classes **DoubleStream, IntStream, LongStream**.

## Gerando Streams diretamente

        IntStream.rangedClose(1,50).filter(in -> in % 2 == 0).forEach(in -> System.out.println(in + " "));

Neste exemplo o **rangedClose()** irá filtrar do número 1 até o 50 e imprimir somente os pares. Se fosse usado o **range()** o primeiro e o último número são exclusivos.  
Gerar Streams de iteração até um ponto definido: _**iterate()** e **generate()**_.  


## Summarizing
Método do **collect()** muito importante, automátiza muitas funcionalidades do código.  
Ex:  

        String titles = lista.stream().map(lista::getTitle).collect(Collectors.joining(", "));

Este método agrupa String's em uma lista separando por vírgula e leva em conta o último elemento da lista.

        lista.stream().collect(Collectos.summarizingDouble(lista::getPrice));

Este método retorna todas as estátiscas de preço da lista: soma, mínimo, máximo, média.


## Grouping by
Agrupa elementos em um Map.

        Map<Categoty, List<lista>> collect = lista.stream.collect(Collectors.groupingBy(lista::getCategory));

Este código irá separar em um Map as listas baseadas nas suas categorias.  
Também é possível agrupar vários **groupingBy()**:  

        Map<Category, Map<Promotion, List<lista>>> collect1 = lista.stream()
        .collect(groupingBy(lista::getCategory,
        groupingBy(l -> l.getPrice() ? < 6 ? UNDER_PROMOTION : NORMAL_PRICE)));

Este segundo exemplo irá inserir como chave do **Map** a categoria, e após isso será passado como valor um novo **Map** com chave o tipo da promoção e o valor a lista de itens.

Retirar o maior valor de um Collector: 

        Collectors.maxBy(Comparator.comparing(lista::getPrice));

Compara os preços da lista e retorna o maior preço. Se utilizar o **minBy()** será feito o contrário.