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
        <title>Modificaci&oacute;n de pr&aacute;ctica</title>
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


            function valida(){
                if(!(document.formTest.DescripcionPractica.value==document.formTest.DescripcionAntigua.value)
                    || !(document.formTest.FechaPractica.value==document.formTest.FechaAntigua.value)){
                    alert("Debe guardar la practica antes de continuar")
                    return false
                }
                else{
                    return true
                }
            }

            //-->
        </SCRIPT>
    </head>
    <body onUnload="exit();">

        <p class="derecha" > <a href="mostrarPracticas.jsp" class="menu"  onclick="javascript:salida=false;">[Listado de Practicas]</a> |
            <a href="salida.jsp" class="menu"  onclick="javascript:salida=false;">[Salir]</a> </p>
        <h1 class="center"  class="color">
			Modificaci&oacute;n de la pr&aacute;ctica.
    </h1>


    <%

        boolean autenticado = false;

        Testigo resultado = new Testigo();
        if (request.getParameter("operacion").equalsIgnoreCase("crear")){
                resultado.setOperacion(Testigo.Operaciones.crearPractica);
            }
        else{
            resultado.setOperacion(Testigo.Operaciones.modificarPractica);
        }

        resultado.setParametro((HttpServletRequest) request);

        interfazGestor.sendTestigo(resultado);

        autenticado = resultado.isResultadoB();



    %>

    <%
        if (autenticado) {

    %>


    <%

            String nombre = request.getParameter("NombrePractica");
            String descripcion = request.getParameter("DescripcionPractica");
            String fechaEntrega = request.getParameter("FechaPractica");

            Testigo resultado2 = new Testigo();
            resultado2.setOperacion(Testigo.Operaciones.pedirTests);
            resultado2.setParametro((HttpServletRequest) request);


            interfazGestor.sendTestigo(resultado2);

            while (!resultado2.isRelleno()) {
            }

            Test[] tests = (Test[]) resultado2.getResultado();

    %>
    <div id="cuerpo">
        <form method="post" name="formTest" action="guardarPractica.jsp" onclick="javascript:salida=false;">
            <h2> <%= nombre%> </h2>
            <p> Descripci&oacute;n: <input type="text" name="descripcion" size="25" value="<%= descripcion%>">  </p>
            <p> Fecha Entrega: <input type="text" name="fechaEntrega" size="25" value="<%= fechaEntrega%>">
                <input  type="hidden" value="<%= descripcion%>" name="DescripcionAntigua">
                <input  type="hidden" value="<%= fechaEntrega%>" name="FechaAntigua">
                <input  type="hidden" value="<%= nombre%>" name="nombrePractica">
                <input type="hidden" value="modificar" name="operacion">
            </p>
            <input type="submit" name="seleccionar" value="Guardar Practica" onclick="javascript:salida=false;">
        </form>
        <div id="enlaces">
            <table border="0">
                <tbody>
                    <tr>
                        <td>
                            <form method="post" name="formAnadir" action="crearTest.jsp" onsubmit="return valida();">
                                <input type="submit" name="seleccionar" value="A&ntilde;adir Test" onclick="javascript:salida=false;">
                            </form>
                        </td>
                        <td>
                            <form method="post" name="formAnadir" action="peticionTest2.jsp" onsubmit="return valida();">
                                <input type="submit" name="seleccionar" value="Seleccionar Test" onclick="javascript:salida=false;">
                            </form> </td>
                    </tr>

                </tbody>
            </table>
        </div>
    </div>
    <div id="central">
        <table border="4" cellspacing="4" cellpadding="4" width="380" class="center">
            <tbody>

                <% for (int i = 0; i < tests.length; i++) {%>

                <tr>
                    <td> <%= tests[i].getId()%></td>
                    <td>
                        <form method="post" name="formpracticas" action="modificarTest.jsp" onsubmit="return valida();">
                            <input  type="hidden" value="<%= tests[i].getId()%>" name="NombreTest">
                            <input  type="hidden" value="<%= tests[i].getDescripcion()%>" name="DescripcionTest">
                            <input type="submit" name="Ver" value="Ver" onclick="javascript:salida=false;">
                        </form>
                    </td>
                    <td>
                        <form method="post" name="formpracticas" action="eliminarTest.jsp" onsubmit="return valida();">
                            <input  type="hidden" value="<%= tests[i].getId()%>" name="NombrePractica">
                            <input type="submit" name="Eliminar" value="Eliminar" onclick="javascript:salida=false;">
                        </form>
                    </td>
                </tr>
                <%
            }
                %>
            </tbody>
        </table>
    </div>
    <% } else {
    %>

    <h2 class="error" align="center">
        ERROR!!! En la base de datos </h2>
    <br>
    <p class="error" align="center">
        Ha ocurrido un problema en la base de datos al intentar crear la practica.
        Revise el nombre de la practica.
    </p>
    <br>
    <br>


    <% }
    %>

</body>
</html>
