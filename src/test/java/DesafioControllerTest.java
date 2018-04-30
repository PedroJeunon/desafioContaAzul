import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.desafio.application.DesafioController;
import br.com.desafio.domain.Boleto;
import br.com.desafio.domain.StatusEnum;
import br.com.desafio.service.DesafioService;

public class DesafioControllerTest extends SpringApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private DesafioController desafioController;

	@Autowired
	private DesafioService service;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(desafioController).build();
	}

	@After
	public void tearDown() {
		service.deleteAll();
	}

	@Test
	public void testGETBoletosOK() throws Exception {
		// Cria boleto para ter banco preenchido no retorno.
		testPOSTCreateBoletosOK();
		this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/bankslips"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testGETBoletosNoContent() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/bankslips"))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}

	@Test
	public void testPOSTCreateBoletosOK() throws Exception {
		Boleto boleto = new Boleto(new Date(), 1000000, "Customer 1", StatusEnum.PENDING);

		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/rest/bankslips").contentType("application/json")
						.content(formataJson(boleto)))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content().string("Bankslip created"));
	}

	@Test
	public void testPOSTCreateBoletosNoStatus() throws Exception {
		Boleto boleto = new Boleto();
		boleto.setDue_date(new Date());
		boleto.setTotal_in_cents(1000000);
		boleto.setCustomer("Customer 1");

		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/rest/bankslips").contentType("application/json")
						.content(formataJson(boleto)))
				.andExpect(MockMvcResultMatchers.status().isUnprocessableEntity())
				.andExpect(MockMvcResultMatchers.content().string(
						"Invalid bankslip provided.The possible reasons are: A field of the provided bankslip was null or with invalid values"));
	}

	@Test
	public void testGETDetalheBoletoOK() throws Exception {
		Boleto boleto = new Boleto(new Date(), 1000000, "Customer 1", StatusEnum.PENDING);
		service.criarBoleto(boleto);
		boleto = service.findByCustomer("Customer 1");

		this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/bankslips/" + boleto.getId()))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testGETDetalheBoletoInvalidUUID() throws Exception {
		Boleto boleto = new Boleto("1", new Date(), 1000000, "Customer 1", StatusEnum.PENDING, 0.0);

		try {
			this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/bankslips/" + boleto.getId()));
		} catch (Exception e) {
			assertEquals("Invalid id provided - it must be a valid UUID", e.getCause().getMessage());
		}

	}

	@Test
	public void testGETDetalheBoletoNotFound() throws Exception {
		Boleto boleto = new Boleto("58bda2d5-8855-4dec-976a-29e92f5281e7", new Date(), 1000000, "Customer 1",
				StatusEnum.PENDING, 0.0);

		try {
			this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/bankslips/" + boleto.getId()));
		} catch (Exception e) {
			assertEquals("Bankslip not found with the specified id", e.getCause().getMessage());
		}

	}

	@Test
	public void testPUTBoletoPaidNotFound() throws Exception {
		Boleto boleto = new Boleto();
		boleto.setId("58bda2d5-8855-4dec-976a-29e92f5281e7");
		boleto.setStatus(StatusEnum.PAID);

		this.mockMvc
				.perform(MockMvcRequestBuilders.put("/rest/bankslips/" + boleto.getId() + "/pay")
						.contentType("application/json").content(formataJson(boleto)))
				.andExpect(MockMvcResultMatchers.status().isNotFound())
				.andExpect(MockMvcResultMatchers.content().string("Bankslip not found with the specified id"));

	}

	@Test
	public void testPUTBoletoPaidOK() throws Exception {
		Boleto boleto = new Boleto(new Date(), 1000000, "Customer 1", StatusEnum.PENDING);
		service.criarBoleto(boleto);
		boleto = service.findByCustomer("Customer 1");

		Boleto boletoPago = new Boleto();
		boletoPago.setId(boleto.getId());
		boletoPago.setStatus(StatusEnum.PAID);

		this.mockMvc
				.perform(MockMvcRequestBuilders.put("/rest/bankslips/" + boletoPago.getId() + "/pay")
						.contentType("application/json").content(formataJson(boletoPago)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Bankslips paid"));
	}

	@Test
	public void testDELETEBoletoCancelNotFound() throws Exception {
		Boleto boleto = new Boleto();
		boleto.setId("58bda2d5-8855-4dec-976a-29e92f5281e7");
		boleto.setStatus(StatusEnum.CANCELLED);

		this.mockMvc
				.perform(MockMvcRequestBuilders.delete("/rest/bankslips/" + boleto.getId() + "/cancel")
						.contentType("application/json").content(formataJson(boleto)))
				.andExpect(MockMvcResultMatchers.status().isNotFound())
				.andExpect(MockMvcResultMatchers.content().string("Bankslip not found with the specified id"));

	}

	@Test
	public void testDELETEBoletoCancelOK() throws Exception {
		Boleto boleto = new Boleto(new Date(), 1000000, "Customer 1", StatusEnum.PENDING);
		service.criarBoleto(boleto);
		boleto = service.findByCustomer("Customer 1");

		Boleto boletoCancelado = new Boleto();
		boletoCancelado.setId(boleto.getId());
		boletoCancelado.setStatus(StatusEnum.CANCELLED);

		this.mockMvc
				.perform(MockMvcRequestBuilders.delete("/rest/bankslips/" + boletoCancelado.getId() + "/cancel")
						.contentType("application/json").content(formataJson(boletoCancelado)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Bankslips cancelled"));
	}

	private String formataJson(Boleto boleto) {
		ObjectMapper obj = new ObjectMapper();
		try {
			return obj.writeValueAsString(boleto);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
