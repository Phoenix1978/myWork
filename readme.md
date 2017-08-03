# <img src="https://image.freepik.com/free-icon/chart-analysis_318-81675.jpg" alt="" width=100/>  
MyWork - analysing text
========

**Welcome on my text analyser project!**

This project has been done for exercise purpose only but if it can help somebody on his way, it's under MIT license.

It can be extended to analyze all type of object list, not only a phrase.

The work as to analyze a text WITHOUT using Java collections Framework, otherwise most of this could be written like this:

```java
      ((Map<String, List<String>>) Arrays.asList(textToAnalyse.split(" "))
            .stream()
            .collect(Collectors.groupingBy(Function.identity())))
            .entrySet()
            .stream()
            .sorted((e1,e2)->((Integer)e1.getValue().size()).compareTo(((Integer)e2.getValue().size())))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new))
            .forEach((key,value)->{System.out.println(value.size() + " " + key);}); 
```

### How it work

It include a class hierarchy the contains the super class "Analyzer" that will do the job, and the package "com.me.analysing.entity" that gather all object that can be instantiated to keep the data analyzed 

### To test it
You can use the code as it or launch the runnable jar file present in the dist folder like this :
```java
java -cp ./TextAnalyzer.jar main.com.me.analysing.TextAnalyzer [Text]
```
Where [Text] is the text you want to analyze

### Possible evolution
As said before you can extends this work to analyze all type of object list. You can also define more unit tests, managing logs...
