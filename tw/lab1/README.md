
# Teoria współbieżności - laboratorium 1: model i programowanie wielowątkowe
* Dokument: https://github.com/balis/balis.github.io/blob/master/tw/lab1/README.md
* Slajdy: http://balis.github.io/tw/lab1/

---

## Wątki vs procesy

![Alt text](http://galaxy.agh.edu.pl/~balis/dydakt/tw/lab1/ThreadDiagram.png "test")

---

## Wątki w języku Java

Tworzenie wątku przez dziedziczenie z klasy `Thread`:

```java
class MyThread extends Thread {
     . . .
     public void run() {
          . . .
     }
}

MyThread t = new MyThread();
t.start();
```

Tworzenie wątku przez implementację interfejsu `Runnable`:

```java
class MyThreadR implements Runnable {
     . . .
     public void run() { 
          . . . 
     } 
}

MyThreadR r = new MyThreadR();
Thread t = new Thread(r);
t.start();
```

[Dokumentacja klasy Thread](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html)


Niektóre ważne metody:

```java
void start()
void join()
static void sleep(long milis, int nanos)
static Thread currentThread()
void setName(String name)
String getName()
String toString()
```

---

## Wątki w JVM
![JVM Arch](http://galaxy.agh.edu.pl/~balis/dydakt/tw/lab1/JVM_Internal_Architecture.png) 
<!-- .element height="50%" width="50%" -->
