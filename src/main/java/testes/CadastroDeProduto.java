package testes;

import dao.CategoriaDao;
import dao.ProdutoDao;
import modelo.Categoria;
import modelo.Produto;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {

    public static void main(String[] args) {
        cadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarPorId(1l);
        System.out.println(p.getPreco());

        List<Produto> todos = produtoDao.buscarPorNome("Xiaomi Redmi");
        todos.forEach(p2-> System.out.println(p.getNome()));

        BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProduto("Xiaomi Redmi");
        System.out.println("AHAHHAHAH" + precoDoProduto);
    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares );

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }

}
