# Date
Classe obsoleta, não instânciar datas com ele.
Utiliza um Long que conta os millissegundos desde 01 de Janeiro de 1970. Para capturar a data usa-se:  
 Date date = c.getTime(); 

# Calendar
Classe abstrata, para pegar a data usa-se:   
Calendar c = Calendar.getInstance();

# Formatação de datas
## DateFormat
 Classe com alguns tipos específicos de formatação pré prontos. 

 ## Internacionalização de datas com Locale
A classe Locale pode ser instânciada passando por parâmetro a sigla do idioma e do país, com isto a data será formatado conforme o local desejado. Este caso é utilizado quando não se tem o Enum do local desejado.  
Ex: Locale dataJapao = new Locale("ja", "JP");  
Ou então utilizar, caso tenha a constante:   
Locale localJapao = Locale.JAPAN;
* Para verificar em qual região o S.O está configurado:  
System.out.println(Locale.getDefault());
* Verificar quais países podem ser usados:  
String[] isoCountries = Locale.getISOCountries();
* Verificar as linguas:
String[] isoLanguages = Locale.getISOLanguages();  


## Internacionalização de números com NumberFormat
Primeiro utiliza o Locale para definir a região. Em seguida utilizar **NumberFormat** para formatar os números da região.   
Locale localeBR = new Locale("pt", "BR");  
NumberFormat.getInstance(localeBR);  

## Formatar moedas com Locale
Para formatar moedas é só usar o Locale.getCurrencyInstance(); e passar o local por parâmetro que automátiicamente o valor será convertido para monetário.  
Formatar casas decimais:  
NumberFormat.getMaximumFractionDigits(quantidade);


## Formatando com SimpleDateFormat
Precisa criar um **Pattern** de formatação. Frases que devem ser ignoradas devem estar entre aspas simples.  
String pattern = "'Brazil' dd 'de' MMMM 'de' yyyy";  
SimpleDateFormat sdf = new SimpleDateFormat(pattern);  
Para formatar a data então fica assim:  
sdf.format(new Date());  
Formata a data de Hoje. Para o mês ser formatado por extenso foi utiliado 4 letras M.


# Nova API java.time
## LocalDate
Só trabalha com a data, sem horas. Sempre que mudar algo na data deste objeto deve-se referenciá-lo novamente.  
LocalDate agora = LocalDate.now();
agora = agora.plusWeeks(4);  
Para capturar dados separados utilizar o ChronoField.

## LocalTime
Só trabalha com tempo, sem data. São o mesmo estilo dos métodos do LocalDate para capturar as datas. Também pode utilizar o ChronoField.

## LocalDateTime
Tempo e data juntos. Básicamente a junção dos objetos LocalTime e localDate.

## Instant
Diferença para as outras classes é que ela trabalha com nanossegundos.

## Duration
Serve para trabalhar com passagem de tempo entre datas utilizando horas, minutos e segundos.

## Period
Serve para trabalhar com passagem de tempo entre datas utilizando dias, meses e anos. Não trabalha com semanas.

## ChronoUnit
Classe que relaciona datas e períodos.

## TemporalAdjusters
Classe para ajustes de tempo.Por exemplo para saber quando foi a última quinta-feira após uma data específica:  
LocalDate now = LocalDate.now();

now = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));

## ZoneId, ZonedDateTime e ZoneOffSet
Usado para mudar a área de onde se tem o horário.   
LocalDateTime now = LocalDateTime.now();
ZoneId zoneTokyo = ZoneId.of("Asia/Tokyo"));
ZonedDateTime zoned = now.atZone(zoneTokyo);  
Modou a hora de now para a região de Tokyo.  
**ZoneOffSet**: Utilizada quando você sabe o horário mas não sabe a zona.

## DateTimeFormatter
Usada para formatar datas.