package tech.ada.ecommerce.controller;

import org.springframework.web.bind.annotation.*;
import tech.ada.ecommerce.model.Produto;
import tech.ada.ecommerce.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/listar")
    public List<Produto> getProdutos(){
        return produtoService.buscarTodosOsProdutos();
    }

    @GetMapping("/nome")
    public List<Produto> getProdutosPorNome(@RequestParam String nome){
        return produtoService.buscarProdutosPorNome(nome);
    }

    @DeleteMapping("/{id}/excluir")
    public List<Produto> excluirProduto(@PathVariable Long id){
        return produtoService.excluirProdutoPorId(id);
    }

    @PostMapping("/criar")
    public Produto criarProduto(@RequestBody Produto produto){
        return produtoService.criarNovoProduto(produto);
    }

    @PutMapping("/{id}/atualizar-estoque")
    public Produto atualizarEstoque(@PathVariable Long id, @RequestParam int novoEstoque) {
        return produtoService.atualizarEstoque(id, novoEstoque);
    }

    @PutMapping("/{id}/atualizar-nome")
    public Produto atualizarNome(@PathVariable Long id, @RequestParam String novoNome) {
        return produtoService.atualizarNome(id, novoNome);
    }

    @PutMapping("/{id}/atualizar-sku")
    public Produto atualizarSku(@PathVariable Long id, @RequestParam String novoSku) {
        return produtoService.atualizarSKU(id, novoSku);
    }

    @PutMapping("/{id}/atualizar-preco")
    public Produto atualizarPreco(@PathVariable Long id, @RequestParam double novoPreco) {
        return produtoService.atualizarPreco(id, novoPreco);
    }
}

