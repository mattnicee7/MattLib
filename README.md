# MattLib

[![GitHub stars](https://img.shields.io/github/stars/mattnicee7/mattlib)](https://github.com/mattnicee7/MattLib/stargazers)
[![CodeFactor](https://www.codefactor.io/repository/github/mattnicee7/mattlib/badge/master)](https://www.codefactor.io/repository/github/mattnicee7/mattlib/overview/master)
[![wakatime](https://wakatime.com/badge/user/3408feff-bd97-4f32-be4d-77a253fdf982/project/e5620731-e5df-419d-9658-2e63a79dfa40.svg)](https://wakatime.com/badge/user/3408feff-bd97-4f32-be4d-77a253fdf982/project/e5620731-e5df-419d-9658-2e63a79dfa40)

Uma biblioteca completa para seus projetos, com funções que abrangem desde de banco de dados como MySQL, SQLite, PostgreSQL, MariaDB a verificação de documentos como CPF/CNPJ. Além de um código limpo e robusto facilitando o uso. Issues e Pull-Requests são bem vindos nesse repositório.

# Recursos

Lista dos principais recursos disponíveis na biblioteca:

✱ Projeto multi-modulo dividido entre misc, sql e spigot. Você pode escolher o módulo que você quer usar.

✱ Verificador de documentos (CPF e CNPJ).

✱ Serviço de envio de e-mails automatico.

✱ Verificador de segurança de senhas.

✱ Sistema para geração e leitura de QR code.

✱ Conector de SQL com opções de 4 database: MySQL, SQLite, PostgreSQL, MariaDB.

✱ Formatador de tempo.

✱ E muito mais...

# Maven

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.mattnicee7.mattlib</groupId>
        <artifactId>MODULE</artifactId>
        <version>VERSION</version>
    </dependency>
</dependencies>
```

# Gradle

```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.mattnicee7.mattlib:MODULE:VERSION'
}
```

# TO-DO List

* Relocate in some dependencies
* Add more features (misc, sql)
* Add features in spigot (utils, builders)

# Exemplos de usos

# Bibliotecas utilizadas

✱ [Lombok](https://projectlombok.org/)

✱ [Javax Mail](https://mvnrepository.com/artifact/javax.mail)

✱ [Jetbrains Annotation](https://www.jetbrains.com/help/idea/annotating-source-code.html)

✱ MySQL, PostgreSQL, MariaDB, SQLite Drivers.

# Contribuidores

✱ [mattnicee7](https://github.com/mattnicee7/)

✱ [zGumeloBr](https://github.com/zGumeloBr)
