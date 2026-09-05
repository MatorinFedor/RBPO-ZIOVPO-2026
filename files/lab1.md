## Короткое введение в Java + Maven

### 1) Что потребуется
* Среда разработки (рекомендуется [IntelliJ IDEA](https://www.jetbrains.com/idea/download/?section=windows))
* JDK версии 21 или выше (среда разработки установит сама)
* Maven

### 2) Создаём простой проект в IDE и компилируем его в консоли

**Шаг 0. Готовим окружение и `PATH`**  
Задача — чтобы `java`, `javac` и `mvn` были доступны в любой консоли.

* **Проверяем доступность инструментов:**

  ```bash
  java --version
  javac --version
  mvn -v
  ```

Если команды не находятся — нужно добавить в `PATH` путь к папке bin.

Примерный путь к Maven:  
C:\Program Files\JetBrains\\<ваша версия IDE>\plugins\maven\lib\maven3\bin

Примерный путь к JDK:  
C:\Users\<user>\.jdks\\<ваша версия JDK>\bin

**Шаг 1. Создаём простой Java-проект в IntelliJ IDEA (без Maven)**

IDE создаст минимальную структуру с папкой `src`.
Код:

  ```java
  package com.example;

  public class Hello {
      public static void main(String[] args) {
          System.out.println("Hello from IDE!");
      }
  }
  ```

**Шаг 2. Запускаем тот же код из консоли (ручная компиляция)**

1. **Откройте терминал в корне проекта** `hello` (где лежит папка `src`).

    * В IntelliJ: на снизу на левой панели значок терминала.
    * Либо откройте системный терминал в корневой папке проекта.

2. **Создаём папку для скомпилированных классов** (выходной каталог):

    * Windows (PowerShell/CMD):

      ```powershell
      mkdir out
      ```

3. **Компилируем исходник в байткод (`.class`)**:

    * Windows:

      ```powershell
      javac -d out src\Hello.java
      ```

   Что здесь происходит:

    * `javac` — компилятор Java.
    * `-d out` — сложить все скомпилированные `.class` в папку `out`, сохраняя структуру пакетов.

4. **Смотрим, что получилось**:

   В `out` появилcя файл `out/Hello.class`.

5. **Запускаем JVM на скомпилированных классах**:

    * macOS/Linux/Windows:
      ```bash
      java -cp out Hello
      ```

   Пояснения:

    * `java` — запуск байткода на JVM.
    * `-cp out` — `classpath`, где искать классы (наша папка `out`). -cp (или -classpath) говорит JVM/javac, где искать ваши классы.
    * `Hello` — **полное имя класса**, а не путь к файлу.

**Шаг 3. Собираем исполняемый JAR**

1. Находясь в корне проекта:

   ```bash
   jar --create --file out/hello.jar --main-class Hello -C out .
   ```

   Что делает команда:

    * `jar --create --file out/hello.jar` — создаёт архив JAR.
    * `--main-class Hello` — прописывает в манифест главный класс.
    * `-C out .` — взять все классы из каталога `out`.

2. Запуск:

   ```bash
   java -jar out/hello.jar
   ```
---

### 3) Maven

#### 3.1 Создаём новый Maven-проект с «Hello» в IntelliJ IDEA (или используйте этот)

1. **File → New Project → Maven** (можно выбрать archetype `maven-archetype-quickstart`).
2. **SDK:** JDK 21, **GroupId:** `com.example`, **ArtifactId:** `hello-mvn`.

#### 3.2 Ключевые **фазы** стандартного жизненного цикла

* `validate` — проверка корректности структуры проекта;
* `compile` — компиляция `src/main/java`;
* `test` — запуск юнит-тестов (`src/test/java`);
* `package` — упаковка артефакта (обычно JAR в `target/`);
* `verify` — доп. проверки качества (если настроены плагины);
* `install` — установка артефакта в локальный репозиторий `~/.m2`;
* `deploy` — публикация в удалённый репозиторий (CI/CD).

Ещё есть отдельный цикл `clean` (удаляет `target/`) и `site` (генерация сайта/отчётов).

#### 3.3 Собираем JAR и запускаем проект из консоли

Собираем:

```bash
mvn clean package
```

Запускаем байткод классом (в quickstart-JAR нет `Main-Class` в манифесте):

```bash
java -cp target/hello-mvn-1.0-SNAPSHOT.jar ru.mfa.App
```

#### 3.4 Добавляем `exec-maven-plugin` и запускаем

Чтобы не возиться с `-cp` и манифестами, нужно добавить в конец pox.xml плагин, упрощающий запуск:

```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.codehaus.mojo</groupId>
      <artifactId>exec-maven-plugin</artifactId>
      <version>3.2.0</version>
      <configuration>
        <mainClass>ru.mfa.App</mainClass>
      </configuration>
    </plugin>
  </plugins>
</build>
```

Запуск:

```bash
mvn clean compile exec:java
# или
mvn clean package exec:java
# или после первых двух
mvn exec:java
```

> Maven скомпилирует проект и запустит `main` без указания classpath.