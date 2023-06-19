package br.org.demosessao;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
criamos um controller MVC
 */
@Controller
@SpringBootApplication
public class DemosessaoApplication {

 public static void main(String[] args) {
  SpringApplication.run(DemosessaoApplication.class, args);
 }

 /*
injeção de dependência - necessário para usar a sessão baseada em uma requisição (request)
  */
 @Autowired
 HttpServletRequest request;

 /*
 
trata o endpoint inicial da aplicação mostra a tela para efetuar a soma de dois números essa tela só é exibida se houver usuário logado (exemplificando autorização) -> direciona para o arquivo 'index.jsp'
 
  */
 @RequestMapping(path = {"/"}, method = RequestMethod.GET)
 public String index(Model model) {
  System.out.println(request.getSession().getAttribute("usuario"));
  model.addAttribute("timoutsessao", request.getSession().getMaxInactiveInterval());
  model.addAttribute("titulo", "Teste de sessão");
  return "index";
 }

 /*
 trata o endpoint que é usado para efetuar o login na aplicação recebe um usuário (nome apenas) e adiciona na sessão do navegador usando o nome de atributo "usuario" retorna usando o método testeSessao que mostra o arquivo 'index.jsp'
  */
 @RequestMapping(path = {"/logar"}, method = RequestMethod.GET)
 public String efetuaLogin(Model model, String usuario) {
  request.getSession().setAttribute("usuario", usuario);
  return index(model);
 }

 /*
trata o endpoint para abertura da página de login -> direciona para o arquivo 'login.jsp'
  */
 @RequestMapping(path = {"/login"}, method = RequestMethod.GET)
 public String abrePaginaLogin(Model model) {
  return "login";
 }

 /*
 trata o endpoint da ação de somar 2 números recebe os dois números e adiciona o resultado da soma no modelo que é retornado à página (front) retorna usando o método testeSessao que mostra o arquivo 'index.jsp'
  */
 @RequestMapping(path = {"/somar"}, method = RequestMethod.GET)
 public String efetuaSoma(Model model, Double n1, Double n2) {
  model.addAttribute("soma", (n1 + n2));
  return index(model);
 }

}
