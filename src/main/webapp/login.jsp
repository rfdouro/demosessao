<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Página de login</title>
 </head>
 <body>
  <i style="color: red">Você não está logado! (sua sessão pode ter expirado)<br/>É preciso estar logado para realizar a operação!</i>
  <form action="/logar">
   <fieldset>
    <legend>Efetuar login</legend>
    <input type="text" name="usuario"/>
    <input type="submit" value="Logar-se"/>
   </fieldset>
  </form>
 </body>
</html>