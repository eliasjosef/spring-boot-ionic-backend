package com.elias.regaliacrud;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.elias.regaliacrud.domain.Categoria;
import com.elias.regaliacrud.domain.Cidade;
import com.elias.regaliacrud.domain.Cliente;
import com.elias.regaliacrud.domain.Endereco;
import com.elias.regaliacrud.domain.Estado;
import com.elias.regaliacrud.domain.ItemPedido;
import com.elias.regaliacrud.domain.Pagamento;
import com.elias.regaliacrud.domain.PagamentoComBoleto;
import com.elias.regaliacrud.domain.PagamentoComCartao;
import com.elias.regaliacrud.domain.Pedido;
import com.elias.regaliacrud.domain.Produto;
import com.elias.regaliacrud.domain.enums.EstadoPagamento;
import com.elias.regaliacrud.domain.enums.TipoCliente;
import com.elias.regaliacrud.repositories.CategoriaRepository;
import com.elias.regaliacrud.repositories.CidadeRepository;
import com.elias.regaliacrud.repositories.ClienteRepository;
import com.elias.regaliacrud.repositories.EnderecoRepository;
import com.elias.regaliacrud.repositories.EstadoRepository;
import com.elias.regaliacrud.repositories.ItemPedidoRepository;
import com.elias.regaliacrud.repositories.PagamentoRepository;
import com.elias.regaliacrud.repositories.PedidoRepository;
import com.elias.regaliacrud.repositories.ProdutoRepository;

@SpringBootApplication
public class RegaliacrudApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository; 
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired 
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(RegaliacrudApplication.class, args);
			
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		
		Produto pr1 = new Produto(null, "Notebook", "Dell 14': Intel Core i5");
		Produto pr2 = new Produto(null, "Impressora", "Epson L330");
		Produto pr3 = new Produto(null, "Mouse", "Dell M660");
		
		Estado est1 = new Estado(null, "Pernambuco");
		Estado est2 = new Estado(null, "Alagoas");
		
		Cidade cd1 = new Cidade(null, "Recife", est1);
		Cidade cd2 = new Cidade(null, "Olinda", est1);
		Cidade cd3 = new Cidade(null, "Maceió", est2);
		
		
		c1.getProdutos().addAll(Arrays.asList(pr1, pr2, pr3));
		c2.getProdutos().addAll(Arrays.asList(pr2));
		
		pr1.getCategorias().addAll(Arrays.asList(c1));
		pr2.getCategorias().addAll(Arrays.asList(c1, c2));
		pr3.getCategorias().addAll(Arrays.asList(c1));
		
		est1.getCidades().addAll(Arrays.asList(cd1, cd2));
		est2.getCidades().addAll(Arrays.asList(cd3));
		
		categoriaRepository.saveAll(Arrays.asList(c1, c2));
		produtoRepository.saveAll(Arrays.asList(pr1, pr2, pr3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cd1, cd2, cd3));
		
		Cliente cl1 = new Cliente(null, "Elias Santos", "elias@elias.com", "123.345.567-78", TipoCliente.PESSOAJURIDICA);
		
		cl1.getTelefones().addAll(Arrays.asList("8888-8888", "9999-9999"));
		
		clienteRepository.saveAll(Arrays.asList(cl1));
		
		Endereco ed1 = new Endereco(null, "Rua Icó", "74", "Casa", "Pina", "51011-090", cd1, cl1);
		
		enderecoRepository.saveAll(Arrays.asList(ed1));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("07/03/2019 12:02"), cl1, ed1);
		Pedido ped2 = new Pedido(null, sdf.parse("08/03/2019 21:02"), cl1, ed1);
		
		Pagamento pgmt1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 12);
		ped1.setPagamento(pgmt1);
		
		Pagamento pgmt2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("22/04/2018 18:23"), sdf.parse("19/02/2019 21:17"));
		ped2.setPagamento(pgmt2);
		
		cl1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pgmt1, pgmt2));
		
		ItemPedido ip1 = new ItemPedido(ped1, pr1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, pr3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, pr2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		pr1.getItens().addAll(Arrays.asList(ip2));
		pr2.getItens().addAll(Arrays.asList(ip3));
		pr3.getItens().addAll(Arrays.asList(ip1));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
		
	}

}
