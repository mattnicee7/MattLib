# MattLib

[![GitHub stars](https://img.shields.io/github/stars/mattnicee7/mattlib)](https://github.com/mattnicee7/MattLib/stargazers)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/0b674fb11244458dbfe9ea2134909964)](https://www.codacy.com/gh/mattnicee7/MattLib/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=mattnicee7/MattLib&amp;utm_campaign=Badge_Grade)

Uma biblioteca completa para seus projetos, com funções que abrangem desde de banco de dados como MySQL, SQLite, PostgreSQL, MariaDB a verificação avançada de documentos como CPF/CNPJ. Além de um código limpo e robusto facilitando o uso.

# Recursos

Lista de recursos disponíveis na biblioteca:

✱ Verificador de documentos (CPF e CNPJ).

✱ Serviço de envio de e-mails automatico.

✱ Verificador de segurança de senhas.

✱ Sistema para geração e leitura de QR code.

✱ Conector de SQL com opções de 4 database: MySQL, SQLite, PostgreSQL, MariaDB.

✱ Formatador de horários e tempo.

# Maven

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.mattnicee7</groupId>
    <artifactId>{MODULE}</artifactId>
    <version>{VERSION}</version>
</dependency>
```

# Gradle

```gradle
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }

    dependencies {
            implementation 'com.github.mattnicee7.mattlib:{MODULE}:{VERSION}'
    }
```

# Exemplos de usos

# Bibliotecas Usadas

✱ [Lombok](https://projectlombok.org/)

✱ [Javax Mail](https://mvnrepository.com/artifact/javax.mail)

✱ [Jetbrains Annotation](https://www.jetbrains.com/help/idea/annotating-source-code.html)
