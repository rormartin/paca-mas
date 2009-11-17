<%@ page import="jade.core.*"%>
<%@ page import="javax.servlet.jsp.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jade.core.Runtime"%>
<%@ page import="jade.wrapper.*"%>
<%@ page import="es.urjc.ia.paca.util.*"%>
<%@page import="es.urjc.ia.paca.ontology.Practica" %>
<%@page import="es.urjc.ia.paca.ontology.Test" %>

<jsp:useBean id="interfazGestor" class="es.urjc.ia.paca.util.AgentBeanGestor" scope="session"/>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Copiar Test</title>
        <LINK REL=STYLESHEET TYPE="text/css" HREF="estilos/estiloInterfazGestor.css">
        <SCRIPT TYPE="text/javascript">
            <!--

            salida = true;


            function exit()
            {
                if (salida)
                    window.open("salida.jsp",'frame','width=580,height=480,scrollbars=yes,resizable=yes');
                return true;
            }

            function comprobar(){
                if((document.formTest.DescripcionTest.value=="") ||
                    (document.formTest.NombreTest.value=="")){
                    alert("Debe rellenar todos los datos del formulario")
                    return false
                }
                else{
                    return true
                }
            }
            function valida(){
                if((document.formTest.DescripcionTest.value=="") ||
                    (document.formTest.NombreTest.value=="")){
                    alert("Debe rellenar todos los datos del formulario")
                    return false
                }
                else{
                    alert("Debe guardar el test")
                    return false
                }
            }

            //-->
        </SCRIPT>
    </head>
    <body onUnload="exit();">
        <%
            String DescripcionTestACopiar = request.getParameter("DescripcionTestACopiar");
            String NombreTestACopiar = request.getParameter("NombreTestACopiar");
            String NombrePracticaACopiar = request.getParameter("NombrePracticaACopiar");


        %>
        <p class="derecha" > <a href="mostrarPracticas.jsp" class="menu"  onclick="javascript:salida=false;">[Listado de Practicas]</a> |
            <a href="modificarPractica.jsp" class="menu" onclick="javascript:salida=false;"> [Practica] |
                <a href="salida.jsp" class="menu"  onclick="javascript:salida=false;">[Salir]</a> </p>
        <h1 class="center"  class="color">
			Copiar Test.
        </h1>

        <div id="cuerpo">
            <form method="post" name="formTest" action="modificarPractica.jsp" onsubmit="return comprobar();">
                <p> Nuevo Nombre: <input type="text" name="NombreTest" size="25" value="<%= NombreTestACopiar%>"> </p>
                <input type="hidden" name="DescripcionTest" value="<%= DescripcionTestACopiar%>">
                <input  type="hidden" value="<%= NombreTestACopiar%>" name="NombreTestACopiar">
                <input  type="hidden" value="<%= NombrePracticaACopiar%>" name="NombrePracticaACopiar">
                <input type="hidden" value="<%= DescripcionTestACopiar%>" name="DescripcionTestACopiar">
                <input type="hidden" name="operacion" value="copiar">
                <input type="submit" name="Copiar" value="Copiar Test" onclick="javascript:salida=false;">
            </form>

        </div>

    </body>
</html>