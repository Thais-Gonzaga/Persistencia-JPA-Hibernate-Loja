package testes;

import dao.CategoriaDao;
import dao.ProdutoDao;
import modelo.Categoria;
import modelo.Produto;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Categoria celulares = new Categoria("CELULARES");



        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(celulares);

        em.getTransaction().commit();
        em.close();
    }
}
