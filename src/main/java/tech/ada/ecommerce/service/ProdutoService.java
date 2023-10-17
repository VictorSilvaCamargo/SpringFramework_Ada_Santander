package tech.ada.ecommerce.service;

import org.springframework.stereotype.Service;
import tech.ada.ecommerce.model.Produto;
import tech.ada.ecommerce.repository.ProdutoRepository;

import java.util.List;

@Service
public class ProdutoService {

    ProdutoRepository produtoRepository;
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> buscarTodosOsProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos;
    }

    public List<Produto> buscarProdutosPorNome(String nome) {
        List<Produto> produtos = produtoRepository.findByNomeCustom(nome);
        return produtos;
    }

    public Produto criarNovoProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> excluirProdutoPorId(Long id) {
        produtoRepository.deleteById(id);
        return null;
    }

    public Produto atualizarEstoque(Long id,int novoEstoque) {
        Produto estoque = produtoRepository.findById(id).orElse(null);

        if(estoque != null){
            estoque.setQtdEstoque(novoEstoque);

            return produtoRepository.save(estoque);
        }else{
            return null;
        }

    }

    public Produto atualizarNome(Long id, String novoNome) {
        // Obter o produto atual
        Produto produto = produtoRepository.findById(id).orElse(null);

        // Verificar se o produto com o ID fornecido existe
        if (produto != null) {
            // Usar o setter para atualizar o nome
            produto.setNome(novoNome);
            // Salvar as alterações no repositório
            return produtoRepository.save(produto);
        } else {
            // Lidar com o caso em que o produto não existe
            return null;
        }
    }

    public Produto atualizarSKU(Long id, String novoSku) {
        // Obter o produto atual
        Produto produto = produtoRepository.findById(id).orElse(null);

        // Verificar se o produto com o ID fornecido existe
        if (produto != null) {
            // Usar o setter para atualizar o SKU
            produto.setSku(novoSku);
            // Salvar as alterações no repositório
            return produtoRepository.save(produto);
        } else {
            // Lidar com o caso em que o produto não existe
            return null;
        }
    }

    public Produto atualizarPreco(Long id, double novoPreco) {
        // Obter o produto atual
        Produto produto = produtoRepository.findById(id).orElse(null);

        // Verificar se o produto com o ID fornecido existe
        if (produto != null) {
            // Usar o setter para atualizar o preço
            produto.setPreco(novoPreco);
            // Salvar as alterações no repositório
            return produtoRepository.save(produto);
        } else {
            // Lidar com o caso em que o produto não existe
            return null;
        }
    }

    public void buscarProdutosPorPrecos(double preco1, double preco2) {
//        List<Produto> produtos = produtoRepository.findByPrecoBetween(preco1, preco2);
//        int page = 0;
//        int total = 100;
//        Pageable pageable = PageRequest.of(page, total, Sort.Direction.DESC, "preco");
//        Sort sort = Sort.by(Sort.Direction.DESC);
//        Page<Produto> produtos2 = produtoRepository.findAll(pageable);
//        List<Produto> produtos3 = produtoRepository.findAll(sort);
//        return produtos;
    }



}
