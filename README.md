Introdução JPA e Hibernate coms Maven e MySQL no Docker 

Para rodar o projeto vai precisar tem banco de dados Mysql 

Baixando a imagem Mysql no Docker
Simples, basta executar o seguinte comando e você irá baixar a imagem escolhida:

docker pull mysql

Criando o container
Agora que já temos a imagem, falta criar o container baseado nela. Para isso basta executar:

docker run -d -p 3306:3306 --name nome-do-container -e "MYSQL_DATABASE=nomedobanco" -e "MYSQL_ROOT_PASSWORD=password" mysql

Veja os containers que estão em execução com:

# docker ps

Agora você pode acessar o Shell do container e testar o MySQL:

# docker exec -it container-teste-mysql bash
# mysql -uroot -p

Agora vamos criar a database

mysql> create database aulajpa

volte para programa e descomente entrada de dados 

    Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Maria da Silva", "maria@gmail.com");
		Pessoa p3 = new Pessoa(null, "João da Silva", "joao@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");		
		EntityManager em = emf.createEntityManager();
		//Imprimir os dados de entrda
		
		em.getTransaction().begin(); //inicia uma comunicação com o banco
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit(); ///escreve no banco
    System.out.println("Pronto!");
		em.close();
		emf.close();

Pronto banco foi alimentado com os dados

para conferir  
os dados vamos fazer o comando:
mysql> SELECT * FROM aulajpa.Pessoa;
+----+------------------+-----------------+
| id | email            | nome            |
+----+------------------+-----------------+
|  1 | carlos@gmail.com | Carlos da Silva |
|  2 | maria@gmail.com  | Maria da Silva  |
|  3 | joao@gmail.com   | Jo�o da Silva  |
+----+------------------+-----------------+
6 rows in set (0.01 sec)
