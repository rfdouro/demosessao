<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Página inicial</title>
 </head>
 <body>

  <%
   /*
   caso não haja a variável login na sessão
   então redireciona a navegação para a página de login
  esse trecho do código é um scriplet – um ‘pedaço’ de código Java embutido no arquivo JSP e que é executado no servidor
   trechos de código com ${} são códigos que usam Expression Language
    */
   if (request.getSession().getAttribute("usuario") == null) {
    response.sendRedirect("/login");
   }
  %>

  <h1>${titulo}</h1>
  <i style="color: red">Timeout de sessão: ${timoutsessao}s</i>
  <i style="color: blue">Usuário logado: ${usuario}</i>
  <form action="/somar">
   <fieldset>
    <legend>Soma</legend>
    <input type="number" name="n1"/>
    <input type="number" name="n2"/>
    <input type="submit" value="Somar"/>
   </fieldset>
  </form>
  
  <b>Resultado = ${soma}</b>
  
 </body>
</html>